package com.project.ProjectManagement.DTOs;

import java.time.LocalDate;

public class EmployeeDTO {
    private Long id;
    private String name;
    private String email;
    private String department;
    private String role;
    private String skills;
    private LocalDate dateOfJoining;
    private String status;
	
    
    public EmployeeDTO() {
		super();
	}
	public EmployeeDTO(Long id, String name, String email, String department, String role, String skills,
			LocalDate dateOfJoining, String status) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.department = department;
		this.role = role;
		this.skills = skills;
		this.dateOfJoining = dateOfJoining;
		this.status = status;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	public LocalDate getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(LocalDate dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
    
    
}