package com.project.ProjectManagement.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ProjectManagement.DTOs.InvoiceDTO;
import com.project.ProjectManagement.Entity.Client;
import com.project.ProjectManagement.Entity.Invoice;
import com.project.ProjectManagement.Entity.Project;
import com.project.ProjectManagement.Entity.TimeEntry;
import com.project.ProjectManagement.Enums.ApprovalStatus;
import com.project.ProjectManagement.Enums.InvoiceStatus;
import com.project.ProjectManagement.Repository.ClientRepository;
import com.project.ProjectManagement.Repository.InvoiceRepository;
import com.project.ProjectManagement.Repository.ProjectRepository;
import com.project.ProjectManagement.Repository.TimeEntryRepository;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private TimeEntryRepository timeEntryRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ModelMapper mapper;

    private static final double HOURLY_RATE = 1000.0; // Example ₹1000/hour

    @Override
    public InvoiceDTO generateInvoice(InvoiceDTO dto) {
        Client client = clientRepository.findById(dto.getClientId())
                .orElseThrow(() -> new RuntimeException("Client not found"));
        Project project = projectRepository.findById(dto.getProjectId())
                .orElseThrow(() -> new RuntimeException("Project not found"));

        // 🔹 Fetch all approved time entries for this project
        List<TimeEntry> approvedEntries = timeEntryRepository.findByProjectId(project.getId())
                .stream()
                .filter(entry -> entry.getApprovalStatus() == ApprovalStatus.APPROVED)
                .collect(Collectors.toList());

        // 🔹 Calculate total amount
        double total = approvedEntries.stream()
                .mapToDouble(entry -> entry.getHours() * HOURLY_RATE)
                .sum();

        // 🔹 Map and save invoice
        Invoice invoice = new Invoice();
        invoice.setClient(client);
        invoice.setProject(project);
        invoice.setIssueDate(LocalDate.now());
        invoice.setDueDate(LocalDate.now().plusDays(15));
        invoice.setTotalAmount(total);
        invoice.setStatus(InvoiceStatus.PENDING);
        invoice.setRemarks("Auto-generated based on approved time entries");

        Invoice saved = invoiceRepository.save(invoice);
        return mapper.map(saved, InvoiceDTO.class);
    }

    @Override
    public InvoiceDTO updateInvoiceStatus(Long id, String status) {
        Invoice invoice = invoiceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Invoice not found"));
        invoice.setStatus(InvoiceStatus.valueOf(status.toUpperCase()));
        Invoice updated = invoiceRepository.save(invoice);
        return mapper.map(updated, InvoiceDTO.class);
    }

    @Override
    public List<InvoiceDTO> getInvoicesByClient(Long clientId) {
        return invoiceRepository.findByClientId(clientId)
                .stream().map(inv -> mapper.map(inv, InvoiceDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<InvoiceDTO> getInvoicesByProject(Long projectId) {
        return invoiceRepository.findByProjectId(projectId)
                .stream().map(inv -> mapper.map(inv, InvoiceDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<InvoiceDTO> getAllInvoices() {
        return invoiceRepository.findAll()
                .stream().map(inv -> mapper.map(inv, InvoiceDTO.class))
                .collect(Collectors.toList());
    }
}