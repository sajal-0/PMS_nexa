package com.project.ProjectManagement.DTOs;


public class ClientBillingReportDTO {
    private Long clientId;
    private String clientName;
    private double totalInvoiced;
    private double totalPaid;
    private double outstanding;
    
    
	public ClientBillingReportDTO() {
		super();
	}


	public ClientBillingReportDTO(Long clientId, String clientName, double totalInvoiced, double totalPaid,
			double outstanding) {
		super();
		this.clientId = clientId;
		this.clientName = clientName;
		this.totalInvoiced = totalInvoiced;
		this.totalPaid = totalPaid;
		this.outstanding = outstanding;
	}


	public Long getClientId() {
		return clientId;
	}


	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}


	public String getClientName() {
		return clientName;
	}


	public void setClientName(String clientName) {
		this.clientName = clientName;
	}


	public double getTotalInvoiced() {
		return totalInvoiced;
	}


	public void setTotalInvoiced(double totalInvoiced) {
		this.totalInvoiced = totalInvoiced;
	}


	public double getTotalPaid() {
		return totalPaid;
	}


	public void setTotalPaid(double totalPaid) {
		this.totalPaid = totalPaid;
	}


	public double getOutstanding() {
		return outstanding;
	}


	public void setOutstanding(double outstanding) {
		this.outstanding = outstanding;
	}
	
	
    
    
}