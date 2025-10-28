package com.project.ProjectManagement.Service;

import java.util.List;
import java.util.Map;

import com.project.ProjectManagement.DTOs.ClientBillingReportDTO;
import com.project.ProjectManagement.DTOs.EmployeeTimeReportDTO;
import com.project.ProjectManagement.DTOs.ProjectSummaryDTO;

public interface ReportService {
    List<EmployeeTimeReportDTO> getEmployeeTimeReport();
    List<ProjectSummaryDTO> getProjectSummaryReport();
    List<ClientBillingReportDTO> getClientBillingReport();
    Map<String, Object> getDashboardMetrics();
}
