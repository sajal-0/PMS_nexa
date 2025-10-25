package com.project.ProjectManagement.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ProjectManagement.DTOs.TaskAssignmentDTO;
import com.project.ProjectManagement.Entity.TaskAssignment;
import com.project.ProjectManagement.Repository.EmployeeRepository;
import com.project.ProjectManagement.Repository.SubtaskRepository;
import com.project.ProjectManagement.Repository.TaskAssignmentRepository;
import com.project.ProjectManagement.Repository.TaskRepository;

@Service
public class TaskAssignmentServiceImpl implements TaskAssignmentService {

    @Autowired
    private TaskAssignmentRepository taskAssignmentRepository;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private SubtaskRepository subtaskRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public TaskAssignmentDTO assignEmployee(TaskAssignmentDTO dto) {
        if (dto.getEmployeeId() == null) {
            throw new IllegalArgumentException("Employee ID must not be null");
        }
        if (dto.getTaskId() == null) {
            throw new IllegalArgumentException("Task ID must not be null");
        }
        TaskAssignment assignment = new TaskAssignment();

        assignment.setEmployee(employeeRepository.findById(dto.getEmployeeId())
                .orElseThrow(() -> new RuntimeException("Employee not found")));

        assignment.setTask(taskRepository.findById(dto.getTaskId())
                .orElseThrow(() -> new RuntimeException("Task not found")));

        if (dto.getSubtaskId() != null) {
            assignment.setSubtask(subtaskRepository.findById(dto.getSubtaskId())
                    .orElseThrow(() -> new RuntimeException("Subtask not found")));
        }

        TaskAssignment saved = taskAssignmentRepository.save(assignment);
        return mapper.map(saved, TaskAssignmentDTO.class);
    }

    @Override
    public List<TaskAssignmentDTO> getAssignmentsByEmployee(Long employeeId) {
        return taskAssignmentRepository.findByEmployeeId(employeeId)
                .stream()
                .map(assign -> mapper.map(assign, TaskAssignmentDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<TaskAssignmentDTO> getAssignmentsByTask(Long taskId) {
        return taskAssignmentRepository.findByTaskId(taskId)
                .stream()
                .map(assign -> mapper.map(assign, TaskAssignmentDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteAssignment(Long id) {
        taskAssignmentRepository.deleteById(id);
    }
}
