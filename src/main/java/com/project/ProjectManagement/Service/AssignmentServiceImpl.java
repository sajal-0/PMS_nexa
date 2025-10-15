package com.project.ProjectManagement.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ProjectManagement.DTOs.AssignmentDTO;
import com.project.ProjectManagement.Entity.Assignment;
import com.project.ProjectManagement.Entity.Employee;
import com.project.ProjectManagement.Entity.Project;
import com.project.ProjectManagement.Repository.AssignmentRepository;
import com.project.ProjectManagement.Repository.EmployeeRepository;
import com.project.ProjectManagement.Repository.ProjectRepository;

@Service
public class AssignmentServiceImpl implements AssignmentService {

    @Autowired
    private AssignmentRepository assignmentRepo;

    @Autowired
    private EmployeeRepository employeeRepo;

    @Autowired
    private ProjectRepository projectRepo;

    private AssignmentDTO toDTO(Assignment a) {
        AssignmentDTO dto = new AssignmentDTO();
        dto.setId(a.getId());
        dto.setEmployeeId(a.getEmployee().getId());
        dto.setProjectId(a.getProject().getId());
        dto.setRoleInProject(a.getRoleInProject());
        dto.setStartDate(a.getStartDate());
        dto.setEndDate(a.getEndDate());
        return dto;
    }

    @Override
    public AssignmentDTO assignEmployeeToProject(AssignmentDTO dto) {
        Employee employee = employeeRepo.findById(dto.getEmployeeId())
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        Project project = projectRepo.findById(dto.getProjectId())
                .orElseThrow(() -> new RuntimeException("Project not found"));

        Assignment assignment = new Assignment();
        assignment.setEmployee(employee);
        assignment.setProject(project);
        assignment.setRoleInProject(dto.getRoleInProject());
        assignment.setStartDate(dto.getStartDate());
        assignment.setEndDate(dto.getEndDate());

        Assignment saved = assignmentRepo.save(assignment);
        return toDTO(saved);
    }

    @Override
    public List<AssignmentDTO> getAssignmentsByProject(Long projectId) {
        return assignmentRepo.findByProjectId(projectId)
                .stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public List<AssignmentDTO> getAssignmentsByEmployee(Long employeeId) {
        return assignmentRepo.findByEmployeeId(employeeId)
                .stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public void deleteAssignment(Long id) {
        assignmentRepo.deleteById(id);
    }
}
