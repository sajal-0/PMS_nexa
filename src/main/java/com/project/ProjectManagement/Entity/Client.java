package com.project.ProjectManagement.Entity;

import java.util.List;

import com.project.ProjectManagement.Enums.Status;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;



@Entity
	@Table(name = "clients")
	public class Client {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	
	    @NotBlank(message = "Client name is required")
	    private String name;
	
	    private String company;
	
	    @Email(message = "Invalid email format")
	    @Column(unique = true)
	    private String email;
	
	    private String address;
	
	    @Enumerated(EnumType.STRING)
	    private Status status = Status.ACTIVE;
	
	    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
	    private List<Project> projects;

    
	public Client() {
		super();
	}


	public Client(Long id, @NotBlank(message = "Client name is required") String name, String company,
			@Email(message = "Invalid email format") String email, String address, Status status,
			List<Project> projects) {
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


	public Status getStatus() {
		return status;
	}


	public void setStatus(Status status) {
		this.status = status;
	}


	public List<Project> getProjects() {
		return projects;
	}


	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	
	
    
    
    
    
}

   