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

import com.project.ProjectManagement.DTOs.TimeEntryDTO;
import com.project.ProjectManagement.Service.TimeEntryService;

@RestController
@RequestMapping("/api/timeentries")
@CrossOrigin(origins = "*")
public class TimeEntryController {

    @Autowired
    private TimeEntryService timeEntryService;

    @PostMapping
    public ResponseEntity<TimeEntryDTO> logTime(@RequestBody TimeEntryDTO dto) {
        return ResponseEntity.ok(timeEntryService.logTime(dto));
    }

    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<List<TimeEntryDTO>> getTimeEntriesByEmployee(@PathVariable Long employeeId) {
        return ResponseEntity.ok(timeEntryService.getTimeEntriesByEmployee(employeeId));
    }

    @GetMapping("/project/{projectId}")
    public ResponseEntity<List<TimeEntryDTO>> getTimeEntriesByProject(@PathVariable Long projectId) {
        return ResponseEntity.ok(timeEntryService.getTimeEntriesByProject(projectId));
    }

    @PutMapping("/{id}/approve")
    public ResponseEntity<TimeEntryDTO> approveTimeEntry(
            @PathVariable Long id,
            @RequestParam String approvedBy,
            @RequestParam boolean isApproved) {
        return ResponseEntity.ok(timeEntryService.approveTimeEntry(id, approvedBy, isApproved));
    }
}
