package com.project.ProjectManagement.Entity;

import java.time.LocalDate;

import com.project.ProjectManagement.Enums.InvoiceStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "invoices")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    private LocalDate issueDate;
    private LocalDate dueDate;
    private Double totalAmount;

    @Enumerated(EnumType.STRING)
    private InvoiceStatus status = InvoiceStatus.PENDING;

    private String remarks;

	
    public Invoice() {
		super();
	}


	public Invoice(Long id, Client client, Project project, LocalDate issueDate, LocalDate dueDate, Double totalAmount,
			InvoiceStatus status, String remarks) {
		super();
		this.id = id;
		this.client = client;
		this.project = project;
		this.issueDate = issueDate;
		this.dueDate = dueDate;
		this.totalAmount = totalAmount;
		this.status = status;
		this.remarks = remarks;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}


	public Project getProject() {
		return project;
	}


	public void setProject(Project project) {
		this.project = project;
	}


	public LocalDate getIssueDate() {
		return issueDate;
	}


	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}


	public LocalDate getDueDate() {
		return dueDate;
	}


	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}


	public Double getTotalAmount() {
		return totalAmount;
	}


	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}


	public InvoiceStatus getStatus() {
		return status;
	}


	public void setStatus(InvoiceStatus status) {
		this.status = status;
	}


	public String getRemarks() {
		return remarks;
	}


	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	
    
    
}