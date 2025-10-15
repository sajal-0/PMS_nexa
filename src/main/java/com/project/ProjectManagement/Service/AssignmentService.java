package com.project.ProjectManagement.Service;

import java.util.List;

import com.project.ProjectManagement.DTOs.AssignmentDTO;

public interface AssignmentService {
    AssignmentDTO assignEmployeeToProject(AssignmentDTO dto);
    List<AssignmentDTO> getAssignmentsByProject(Long projectId);
    List<AssignmentDTO> getAssignmentsByEmployee(Long employeeId);
    void deleteAssignment(Long id);
}