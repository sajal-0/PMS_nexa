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

import com.project.ProjectManagement.DTOs.TaskAssignmentDTO;
import com.project.ProjectManagement.Service.TaskAssignmentService;

@RestController
@RequestMapping("/api/taskassignments")
@CrossOrigin(origins = "*")
public class TaskAssignmentController {

    @Autowired
    private TaskAssignmentService taskAssignmentService;

    @PostMapping
    public ResponseEntity<TaskAssignmentDTO> assignEmployee(@RequestBody TaskAssignmentDTO dto) {
    	System.out.println("Incoming TaskAssignmentDTO: " + dto);
        return ResponseEntity.ok(taskAssignmentService.assignEmployee(dto));
    }

    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<List<TaskAssignmentDTO>> getAssignmentsByEmployee(@PathVariable Long employeeId) {
        return ResponseEntity.ok(taskAssignmentService.getAssignmentsByEmployee(employeeId));
    }

    @GetMapping("/task/{taskId}")
    public ResponseEntity<List<TaskAssignmentDTO>> getAssignmentsByTask(@PathVariable Long taskId) {
        return ResponseEntity.ok(taskAssignmentService.getAssignmentsByTask(taskId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAssignment(@PathVariable Long id) {
        taskAssignmentService.deleteAssignment(id);
        return ResponseEntity.noContent().build();
    }
}
