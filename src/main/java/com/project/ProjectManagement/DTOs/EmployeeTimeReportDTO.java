package com.project.ProjectManagement.DTOs;

public class EmployeeTimeReportDTO {
    private Long employeeId;
    private String employeeName;
    private String projectName;
    private double totalHours;
    
    
	public EmployeeTimeReportDTO() {
		super();
	}


	public EmployeeTimeReportDTO(Long employeeId, String employeeName, String projectName, double totalHours) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.projectName = projectName;
		this.totalHours = totalHours;
	}


	public Long getEmployeeId() {
		return employeeId;
	}


	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}


	public String getEmployeeName() {
		return employeeName;
	}


	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}


	public String getProjectName() {
		return projectName;
	}


	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}


	public double getTotalHours() {
		return totalHours;
	}


	public void setTotalHours(double totalHours) {
		this.totalHours = totalHours;
	}
	
	
    
    
}