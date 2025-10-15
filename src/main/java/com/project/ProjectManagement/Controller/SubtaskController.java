package com.project.ProjectManagement.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.ProjectManagement.DTOs.SubtaskDTO;
import com.project.ProjectManagement.Service.SubtaskService;

@RestController
@RequestMapping("/api/subtasks")
@CrossOrigin(origins = "*")
public class SubtaskController {

    @Autowired
    private SubtaskService subtaskService;

    @PostMapping
    public ResponseEntity<SubtaskDTO> createSubtask(@RequestBody SubtaskDTO dto) {
        return ResponseEntity.ok(subtaskService.createSubtask(dto));
    }
    
    @PostMapping("/batch")
    public ResponseEntity<List<SubtaskDTO>> createSubtasksMulti(@RequestBody List<SubtaskDTO> dtoList) {
        return ResponseEntity.ok(subtaskService.createSubtasksMulti(dtoList));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SubtaskDTO> updateSubtask(@PathVariable Long id, @RequestBody SubtaskDTO dto) {
        return ResponseEntity.ok(subtaskService.updateSubtask(id, dto));
    }

    @GetMapping("/task/{taskId}")
    public ResponseEntity<List<SubtaskDTO>> getSubtasksByTask(@PathVariable Long taskId) {
        return ResponseEntity.ok(subtaskService.getSubtasksByTask(taskId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubtask(@PathVariable Long id) {
        subtaskService.deleteSubtask(id);
        return ResponseEntity.noContent().build();
    }
}
