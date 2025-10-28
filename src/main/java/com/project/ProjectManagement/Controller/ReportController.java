package com.project.ProjectManagement.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.ProjectManagement.DTOs.ClientBillingReportDTO;
import com.project.ProjectManagement.DTOs.EmployeeTimeReportDTO;
import com.project.ProjectManagement.DTOs.ProjectSummaryDTO;
import com.project.ProjectManagement.Service.ReportService;

@RestController
@RequestMapping("/api/reports")
@CrossOrigin(origins = "*")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/employee-time")
    public ResponseEntity<List<EmployeeTimeReportDTO>> employeeTimeReport() {
        return ResponseEntity.ok(reportService.getEmployeeTimeReport());
    }

    @GetMapping("/project-summary")
    public ResponseEntity<List<ProjectSummaryDTO>> projectSummaryReport() {
        return ResponseEntity.ok(reportService.getProjectSummaryReport());
    }

    @GetMapping("/client-billing")
    public ResponseEntity<List<ClientBillingReportDTO>> clientBillingReport() {
        return ResponseEntity.ok(reportService.getClientBillingReport());
    }

    @GetMapping("/dashboard")
    public ResponseEntity<Map<String, Object>> dashboardMetrics() {
        return ResponseEntity.ok(reportService.getDashboardMetrics());
    }
}
