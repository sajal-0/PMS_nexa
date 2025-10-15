package com.project.ProjectManagement.DTOs;

import java.time.LocalDate;

import com.project.ProjectManagement.Enums.ApprovalStatus;
import com.project.ProjectManagement.Enums.ProjectStatus;

public class TaskDTO {
    private Long id;
    private String title;
    private String description;
    private ProjectStatus projectStatus;              // NOT_STARTED, WIP, COMPLETED, ON_HOLD
    private ApprovalStatus approvalStatus;  // PENDING, APPROVED, REJECTED
    private LocalDate deadline;
    private String approvedBy;
    private Long projectId;
	
    public TaskDTO() {
		super();
	}

	public TaskDTO(Long id, String title, String description, ProjectStatus projectStatus, ApprovalStatus approvalStatus,
			LocalDate deadline, String approvedBy, Long projectId) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.projectStatus = projectStatus;
		this.approvalStatus = approvalStatus;
		this.deadline = deadline;
		this.approvedBy = approvedBy;
		this.projectId = projectId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ProjectStatus getProjectStatus() {
		return projectStatus;
	}

	public void setProjectStatus(ProjectStatus projectStatus) {
		this.projectStatus = projectStatus;
	}

	public ApprovalStatus getApprovalStatus() {
		return approvalStatus;
	}

	public void setApprovalStatus(ApprovalStatus approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

	public LocalDate getDeadline() {
		return deadline;
	}

	public void setDeadline(LocalDate deadline) {
		this.deadline = deadline;
	}

	public String getApprovedBy() {
		return approvedBy;
	}

	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	
    
    
    
}
