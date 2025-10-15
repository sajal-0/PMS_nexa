package com.project.ProjectManagement.Service;

import java.util.List;

import com.project.ProjectManagement.DTOs.TaskDTO;

public interface TaskService {
    TaskDTO createTask(TaskDTO dto);
    List<TaskDTO> createMultiTasks(List<TaskDTO> dtoList);
    TaskDTO updateTask(Long id, TaskDTO dto);
    TaskDTO getTaskById(Long id);
    List<TaskDTO> getTasksByProject(Long projectId);
    void deleteTask(Long id);
}