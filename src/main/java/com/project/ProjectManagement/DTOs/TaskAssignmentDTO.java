package com.project.ProjectManagement.DTOs;

 
public class TaskAssignmentDTO {
    private Long id;
    private Long taskId;
    private Long subtaskId;
    private Long employeeId;
    
    
	public TaskAssignmentDTO() {
		super();
	}

	public TaskAssignmentDTO(Long id, Long taskId, Long subtaskId, Long employeeId) {
		super();
		this.id = id;
		this.taskId = taskId;
		this.subtaskId = subtaskId;
		this.employeeId = employeeId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTaskId() {
		return taskId;
	}

	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}

	public Long getSubtaskId() {
		return subtaskId;
	}

	public void setSubtaskId(Long subtaskId) {
		this.subtaskId = subtaskId;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	
	
    
    
    
}