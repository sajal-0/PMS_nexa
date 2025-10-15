package com.project.ProjectManagement.DTOs;



import java.math.BigDecimal;
import java.time.LocalDate;


public class ProjectDTO {
    private Long id;
    private String name;
    private String description;
    private BigDecimal budget;
    private LocalDate startDate;
    private LocalDate endDate;
    private Long clientId;
    
    
	public ProjectDTO() {
		super();
	}
	public ProjectDTO(Long id, String name, String description, BigDecimal budget, LocalDate startDate,
			LocalDate endDate, Long clientId) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.budget = budget;
		this.startDate = startDate;
		this.endDate = endDate;
		this.clientId = clientId;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public BigDecimal getBudget() {
		return budget;
	}
	public void setBudget(BigDecimal budget) {
		this.budget = budget;
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
	public Long getClientId() {
		return clientId;
	}
	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}
    
    
    
}
