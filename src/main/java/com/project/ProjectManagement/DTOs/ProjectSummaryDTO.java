package com.project.ProjectManagement.DTOs;

public class ProjectSummaryDTO {
    private Long projectId;
    private String projectName;
    private String clientName;
    private double totalHoursLogged;
    private long totalTasks;
    private long completedTasks;
    private double totalBilledAmount;
    
    
	public ProjectSummaryDTO() {
		super();
	}


	public ProjectSummaryDTO(Long projectId, String projectName, String clientName, double totalHoursLogged,
			long totalTasks, long completedTasks, double totalBilledAmount) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.clientName = clientName;
		this.totalHoursLogged = totalHoursLogged;
		this.totalTasks = totalTasks;
		this.completedTasks = completedTasks;
		this.totalBilledAmount = totalBilledAmount;
	}


	public Long getProjectId() {
		return projectId;
	}


	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}


	public String getProjectName() {
		return projectName;
	}


	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}


	public String getClientName() {
		return clientName;
	}


	public void setClientName(String clientName) {
		this.clientName = clientName;
	}


	public double getTotalHoursLogged() {
		return totalHoursLogged;
	}


	public void setTotalHoursLogged(double totalHoursLogged) {
		this.totalHoursLogged = totalHoursLogged;
	}


	public long getTotalTasks() {
		return totalTasks;
	}


	public void setTotalTasks(long totalTasks) {
		this.totalTasks = totalTasks;
	}


	public long getCompletedTasks() {
		return completedTasks;
	}


	public void setCompletedTasks(long completedTasks) {
		this.completedTasks = completedTasks;
	}


	public double getTotalBilledAmount() {
		return totalBilledAmount;
	}


	public void setTotalBilledAmount(double totalBilledAmount) {
		this.totalBilledAmount = totalBilledAmount;
	}
    
    
}