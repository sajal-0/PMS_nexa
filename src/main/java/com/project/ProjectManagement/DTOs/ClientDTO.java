package com.project.ProjectManagement.DTOs;

import java.util.List;

public class ClientDTO {
    private Long id;
    private String name;
    private String company;
    private String email;
    private String address;
    private String status;
    private List<ProjectDTO> projects;
    
    
    
	public ClientDTO() {
		super();
	}
	public ClientDTO(Long id, String name, String company, String email, String address, String status,
			List<ProjectDTO> projects) {
		super();
		this.id = id;
		this.name = name;
		this.company = company;
		this.email = email;
		this.address = address;
		this.status = status;
		this.projects = projects;
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
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<ProjectDTO> getProjects() {
		return projects;
	}
	public void setProjects(List<ProjectDTO> projects) {
		this.projects = projects;
	}
    
    
}
