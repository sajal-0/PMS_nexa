package com.project.ProjectManagement.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.ProjectManagement.Entity.Invoice;
import com.project.ProjectManagement.Enums.InvoiceStatus;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

    List<Invoice> findByClientId(Long clientId);

    List<Invoice> findByProjectId(Long projectId);

    List<Invoice> findByStatus(InvoiceStatus status);
}