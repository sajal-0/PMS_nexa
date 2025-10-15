package com.project.ProjectManagement.Service;

import java.util.List;

import com.project.ProjectManagement.DTOs.TimeEntryDTO;

public interface TimeEntryService {
    TimeEntryDTO logTime(TimeEntryDTO dto);
    List<TimeEntryDTO> getTimeEntriesByEmployee(Long employeeId);
    List<TimeEntryDTO> getTimeEntriesByProject(Long projectId);
    TimeEntryDTO approveTimeEntry(Long id, String approvedBy, boolean isApproved);
}
