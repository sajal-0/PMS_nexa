package com.project.ProjectManagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.ProjectManagement.DTOs.AssignmentDTO;
import com.project.ProjectManagement.Service.AssignmentService;

@RestController
@RequestMapping("/api/assignments")
@CrossOrigin(origins = "*")
public class AssignmentController {

    @Autowired
    private AssignmentService assignmentService;

    // ✅ Assign employee to a project
    @PostMapping
    public ResponseEntity<AssignmentDTO> assignEmployeeToProject(@RequestBody AssignmentDTO dto) {
        return ResponseEntity.ok(assignmentService.assignEmployeeToProject(dto));
    }

    // ✅ Get all employees assigned to a project
    @GetMapping("/project/{projectId}")
    public ResponseEntity<List<AssignmentDTO>> getAssignmentsByProject(@PathVariable Long projectId) {
        return ResponseEntity.ok(assignmentService.getAssignmentsByProject(projectId));
    }

    // ✅ Get all projects assigned to an employee
    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<List<AssignmentDTO>> getAssignmentsByEmployee(@PathVariable Long employeeId) {
        return ResponseEntity.ok(assignmentService.getAssignmentsByEmployee(employeeId));
    }

    // ✅ Delete assignment
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAssignment(@PathVariable Long id) {
        assignmentService.deleteAssignment(id);
        return ResponseEntity.noContent().build();
    }
}