package com.project.ProjectManagement.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ProjectManagement.DTOs.ClientBillingReportDTO;
import com.project.ProjectManagement.DTOs.EmployeeTimeReportDTO;
import com.project.ProjectManagement.DTOs.ProjectSummaryDTO;
import com.project.ProjectManagement.Entity.Invoice;
import com.project.ProjectManagement.Entity.TimeEntry;
import com.project.ProjectManagement.Enums.InvoiceStatus;
import com.project.ProjectManagement.Enums.ProjectStatus;
import com.project.ProjectManagement.Repository.ClientRepository;
import com.project.ProjectManagement.Repository.InvoiceRepository;
import com.project.ProjectManagement.Repository.ProjectRepository;
import com.project.ProjectManagement.Repository.TaskRepository;
import com.project.ProjectManagement.Repository.TimeEntryRepository;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private TimeEntryRepository timeEntryRepository;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private ClientRepository clientRepository;

    // ✅ 1. Employee Time Report
    @Override
    public List<EmployeeTimeReportDTO> getEmployeeTimeReport() {
        List<TimeEntry> allEntries = timeEntryRepository.findAll();

        // Group by employeeId + projectId
        Map<String, Double> grouped = allEntries.stream()
                .filter(e -> e.getEmployee() != null && e.getProject() != null)
                .collect(Collectors.groupingBy(
                        e -> e.getEmployee().getId() + "-" + e.getProject().getId(),
                        Collectors.summingDouble(TimeEntry::getHours)
                ));

        // Map to DTO list
        return grouped.entrySet().stream()
                .map(entry -> {
                    String[] ids = entry.getKey().split("-");
                    Long empId = Long.parseLong(ids[0]);
                    Long projectId = Long.parseLong(ids[1]);

                    // Fetch representative entry for correct names
                    TimeEntry representative = allEntries.stream()
                            .filter(e -> e.getEmployee().getId().equals(empId)
                                    && e.getProject().getId().equals(projectId))
                            .findFirst()
                            .orElse(null);

                    String employeeName = representative != null ? representative.getEmployee().getName() : "Unknown";
                    String projectName = representative != null ? representative.getProject().getName() : "Unknown";

                    return new EmployeeTimeReportDTO(empId, employeeName, projectName, entry.getValue());
                })
                .collect(Collectors.toList());
    }


    // ✅ 2. Project Summary Report
    @Override
    public List<ProjectSummaryDTO> getProjectSummaryReport() {
        return projectRepository.findAll().stream().map(project -> {
            double totalHours = timeEntryRepository.findByProjectId(project.getId())
                    .stream().mapToDouble(TimeEntry::getHours).sum();
            long totalTasks = taskRepository.countByProjectId(project.getId());
            long completedTasks = taskRepository.countByProjectIdAndProjectStatus(project.getId(), ProjectStatus.COMPLETED);
            double billed = invoiceRepository.findByProjectId(project.getId())
                    .stream().mapToDouble(Invoice::getTotalAmount).sum();

            return new ProjectSummaryDTO(
                    project.getId(),
                    project.getName(),
                    project.getClient().getName(),
                    totalHours,
                    totalTasks,
                    completedTasks,
                    billed
            );
        }).collect(Collectors.toList());
    }

    // ✅ 3. Client Billing Report
    @Override
    public List<ClientBillingReportDTO> getClientBillingReport() {
        return clientRepository.findAll().stream().map(client -> {
            var invoices = invoiceRepository.findByClientId(client.getId());
            double totalInvoiced = invoices.stream().mapToDouble(Invoice::getTotalAmount).sum();
            double totalPaid = invoices.stream()
                    .filter(inv -> inv.getStatus() == InvoiceStatus.PAID)
                    .mapToDouble(Invoice::getTotalAmount).sum();
            return new ClientBillingReportDTO(
                    client.getId(),
                    client.getName(),
                    totalInvoiced,
                    totalPaid,
                    totalInvoiced - totalPaid
            );
        }).collect(Collectors.toList());
    }

    // ✅ 4. Dashboard Metrics
    @Override
    public Map<String, Object> getDashboardMetrics() {
        Map<String, Object> metrics = new HashMap<>();
        metrics.put("totalClients", clientRepository.count());
        metrics.put("totalProjects", projectRepository.count());
        metrics.put("totalInvoices", invoiceRepository.count());
        metrics.put("totalRevenue", invoiceRepository.findAll().stream()
                .filter(i -> i.getStatus() == InvoiceStatus.PAID)
                .mapToDouble(Invoice::getTotalAmount)
                .sum());
        metrics.put("totalHoursLogged", timeEntryRepository.findAll()
                .stream().mapToDouble(TimeEntry::getHours).sum());
        return metrics;
    }
}
