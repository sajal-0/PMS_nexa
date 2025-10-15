package com.project.ProjectManagement.DTOs;

import java.time.LocalDate;

import com.project.ProjectManagement.Enums.ApprovalStatus;

public class TimeEntryDTO {
    private Long id;
    private Long employeeId;
    private Long projectId;
    private Long taskId;
    private LocalDate date;
    private Double hours;
    private ApprovalStatus approvalStatus;  // PENDING, APPROVED, REJECTED
    private String approvedBy;
    private LocalDate approvalDate;
    
    
	public TimeEntryDTO() {
		super();
	}


	public TimeEntryDTO(Long id, Long employeeId, Long projectId, Long taskId, LocalDate date, Double hours,
			ApprovalStatus approvalStatus, String approvedBy, LocalDate approvalDate) {
		super();
		this.id = id;
		this.employeeId = employeeId;
		this.projectId = projectId;
		this.taskId = taskId;
		this.date = date;
		this.hours = hours;
		this.approvalStatus = approvalStatus;
		this.approvedBy = approvedBy;
		this.approvalDate = approvalDate;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Long getEmployeeId() {
		return employeeId;
	}


	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}


	public Long getProjectId() {
		return projectId;
	}


	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}


	public Long getTaskId() {
		return taskId;
	}


	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}


	public LocalDate getDate() {
		return date;
	}


	public void setDate(LocalDate date) {
		this.date = date;
	}


	public Double getHours() {
		return hours;
	}


	public void setHours(Double hours) {
		this.hours = hours;
	}


	public ApprovalStatus getApprovalStatus() {
		return approvalStatus;
	}


	public void setApprovalStatus(ApprovalStatus approvalStatus) {
		this.approvalStatus = approvalStatus;
	}


	public String getApprovedBy() {
		return approvedBy;
	}


	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
	}


	public LocalDate getApprovalDate() {
		return approvalDate;
	}


	public void setApprovalDate(LocalDate approvalDate) {
		this.approvalDate = approvalDate;
	}
	
	
    
    
    
}