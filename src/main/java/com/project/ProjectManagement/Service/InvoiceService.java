package com.project.ProjectManagement.Service;

import java.util.List;

import com.project.ProjectManagement.DTOs.InvoiceDTO;

public interface InvoiceService {
    InvoiceDTO generateInvoice(InvoiceDTO dto);
    InvoiceDTO updateInvoiceStatus(Long id, String status);
    List<InvoiceDTO> getInvoicesByClient(Long clientId);
    List<InvoiceDTO> getInvoicesByProject(Long projectId);
    List<InvoiceDTO> getAllInvoices();
}