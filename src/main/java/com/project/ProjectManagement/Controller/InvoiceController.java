package com.project.ProjectManagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.ProjectManagement.DTOs.InvoiceDTO;
import com.project.ProjectManagement.Service.InvoiceService;

@RestController
@RequestMapping("/api/invoices")
@CrossOrigin(origins = "*")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    // ✅ Generate new invoice
    @PostMapping
    public ResponseEntity<InvoiceDTO> generateInvoice(@RequestBody InvoiceDTO dto) {
        return ResponseEntity.ok(invoiceService.generateInvoice(dto));
    }

    // ✅ Update invoice status (Paid / Overdue / Pending)
    @PutMapping("/{id}/status")
    public ResponseEntity<InvoiceDTO> updateInvoiceStatus(
            @PathVariable Long id,
            @RequestParam String status) {
        return ResponseEntity.ok(invoiceService.updateInvoiceStatus(id, status));
    }

    // ✅ Get all invoices for a client
    @GetMapping("/client/{clientId}")
    public ResponseEntity<List<InvoiceDTO>> getInvoicesByClient(@PathVariable Long clientId) {
        return ResponseEntity.ok(invoiceService.getInvoicesByClient(clientId));
    }

    // ✅ Get all invoices for a project
    @GetMapping("/project/{projectId}")
    public ResponseEntity<List<InvoiceDTO>> getInvoicesByProject(@PathVariable Long projectId) {
        return ResponseEntity.ok(invoiceService.getInvoicesByProject(projectId));
    }

    // ✅ Get all invoices
    @GetMapping
    public ResponseEntity<List<InvoiceDTO>> getAllInvoices() {
        return ResponseEntity.ok(invoiceService.getAllInvoices());
    }
}