package com.project.ProjectManagement.Repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.ProjectManagement.Entity.TimeEntry;
import com.project.ProjectManagement.Enums.ApprovalStatus;

@Repository
public interface TimeEntryRepository extends JpaRepository<TimeEntry, Long> {
    

    // ✅ Find entries for a specific employee
    List<TimeEntry> findByEmployeeId(Long employeeId);

    // ✅ Find entries for a specific project
    List<TimeEntry> findByProjectId(Long projectId);

    // ✅ Find entries by task
    List<TimeEntry> findByTaskId(Long taskId);

    // ✅ Find entries by date range (useful for reports)
    List<TimeEntry> findByDateBetween(LocalDate startDate, LocalDate endDate);

    // ✅ Find all pending or approved entries
    List<TimeEntry> findByApprovalStatus(ApprovalStatus status);

}
