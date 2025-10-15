package com.project.ProjectManagement.Service;


import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ProjectManagement.DTOs.TimeEntryDTO;
import com.project.ProjectManagement.Entity.Employee;
import com.project.ProjectManagement.Entity.Project;
import com.project.ProjectManagement.Entity.Task;
import com.project.ProjectManagement.Entity.TimeEntry;
import com.project.ProjectManagement.Enums.ApprovalStatus;
import com.project.ProjectManagement.Repository.EmployeeRepository;
import com.project.ProjectManagement.Repository.ProjectRepository;
import com.project.ProjectManagement.Repository.TaskRepository;
import com.project.ProjectManagement.Repository.TimeEntryRepository;

@Service
public class TimeEntryServiceImpl implements TimeEntryService {

    @Autowired
    private TimeEntryRepository timeEntryRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public TimeEntryDTO logTime(TimeEntryDTO dto) {
        Employee emp = employeeRepository.findById(dto.getEmployeeId())
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        Project proj = projectRepository.findById(dto.getProjectId())
                .orElseThrow(() -> new RuntimeException("Project not found"));

        TimeEntry entry = mapper.map(dto, TimeEntry.class);
        entry.setEmployee(emp);
        entry.setProject(proj);

        if (dto.getTaskId() != null) {
            Task task = taskRepository.findById(dto.getTaskId())
                    .orElseThrow(() -> new RuntimeException("Task not found"));
            entry.setTask(task);
        }

        entry.setApprovalStatus(ApprovalStatus.PENDING);
        entry.setDate(dto.getDate() != null ? dto.getDate() : LocalDate.now());

        TimeEntry saved = timeEntryRepository.save(entry);
        return mapper.map(saved, TimeEntryDTO.class);
    }

    @Override
    public List<TimeEntryDTO> getTimeEntriesByEmployee(Long employeeId) {
        return timeEntryRepository.findByEmployeeId(employeeId)
                .stream()
                .map(te -> mapper.map(te, TimeEntryDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<TimeEntryDTO> getTimeEntriesByProject(Long projectId) {
        return timeEntryRepository.findByProjectId(projectId)
                .stream()
                .map(te -> mapper.map(te, TimeEntryDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public TimeEntryDTO approveTimeEntry(Long id, String approvedBy, boolean isApproved) {
        TimeEntry entry = timeEntryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Time entry not found"));

        entry.setApprovalStatus(isApproved ? ApprovalStatus.APPROVED : ApprovalStatus.REJECTED);
        entry.setApprovedBy(approvedBy);
        entry.setApprovalDate(LocalDate.now());

        TimeEntry updated = timeEntryRepository.save(entry);
        return mapper.map(updated, TimeEntryDTO.class);
    }
}
