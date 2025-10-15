package com.project.ProjectManagement.DTOs;

import java.time.LocalDate;

public class AssignmentDTO {
    private Long id;
    private Long employeeId;
    private Long projectId;
    private String roleInProject;
    private LocalDate startDate;
    private LocalDate endDate;
	

    public AssignmentDTO() {
		super();
	}
	public AssignmentDTO(Long id, Long employeeId, Long projectId, String roleInProject, LocalDate startDate,
			LocalDate endDate) {
		super();
		this.id = id;
		this.employeeId = employeeId;
		this.projectId = projectId;
		this.roleInProject = roleInProject;
		this.startDate = startDate;
		this.endDate = endDate;
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
	public String getRoleInProject() {
		return roleInProject;
	}
	public void setRoleInProject(String roleInProject) {
		this.roleInProject = roleInProject;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
    
    
}