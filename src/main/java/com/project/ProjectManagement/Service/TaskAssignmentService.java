package com.project.ProjectManagement.Service;

import java.util.List;

import com.project.ProjectManagement.DTOs.TaskAssignmentDTO;

public interface TaskAssignmentService {
    TaskAssignmentDTO assignEmployee(TaskAssignmentDTO dto);
    List<TaskAssignmentDTO> getAssignmentsByEmployee(Long employeeId);
    List<TaskAssignmentDTO> getAssignmentsByTask(Long taskId);
    void deleteAssignment(Long id);
}
