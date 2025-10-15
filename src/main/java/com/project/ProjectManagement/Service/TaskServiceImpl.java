package com.project.ProjectManagement.Service;



import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ProjectManagement.DTOs.TaskDTO;
import com.project.ProjectManagement.Entity.Project;
import com.project.ProjectManagement.Entity.Task;
import com.project.ProjectManagement.Enums.ApprovalStatus;
import com.project.ProjectManagement.Enums.ProjectStatus;
import com.project.ProjectManagement.Repository.ProjectRepository;
import com.project.ProjectManagement.Repository.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public TaskDTO createTask(TaskDTO dto) {
        Project project = projectRepository.findById(dto.getProjectId())
                .orElseThrow(() -> new RuntimeException("Project not found"));

        Task task = mapper.map(dto, Task.class);
        task.setProject(project);
        task.setProjectStatus(dto.getProjectStatus() != null ? dto.getProjectStatus() : ProjectStatus.NOT_STARTED);
        task.setApprovalStatus(dto.getApprovalStatus() != null ? dto.getApprovalStatus() : ApprovalStatus.PENDING);

        Task saved = taskRepository.save(task);
        return mapper.map(saved, TaskDTO.class);
    }
    
    @Override
    public List<TaskDTO> createMultiTasks(List<TaskDTO> dtoList) {
        List<Task> tasks = dtoList.stream().map(dto -> {
            Project project = projectRepository.findById(dto.getProjectId())
                    .orElseThrow(() -> new RuntimeException("Project not found for ID: " + dto.getProjectId()));

            Task task = mapper.map(dto, Task.class);
            task.setProject(project);
            task.setProjectStatus(dto.getProjectStatus() != null ? dto.getProjectStatus() : ProjectStatus.NOT_STARTED);
            task.setApprovalStatus(dto.getApprovalStatus() != null ? dto.getApprovalStatus() : ApprovalStatus.PENDING);

            return task;
        }).collect(Collectors.toList());

        List<Task> savedTasks = taskRepository.saveAll(tasks);

        return savedTasks.stream()
                .map(task -> mapper.map(task, TaskDTO.class))
                .collect(Collectors.toList());
    }


    @Override
    public TaskDTO updateTask(Long id, TaskDTO dto) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        task.setDeadline(dto.getDeadline());
        task.setProjectStatus(dto.getProjectStatus());
        task.setApprovalStatus(dto.getApprovalStatus());
        task.setApprovedBy(dto.getApprovedBy());

        Task updated = taskRepository.save(task);
        return mapper.map(updated, TaskDTO.class);
    }

    @Override
    public TaskDTO getTaskById(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
        return mapper.map(task, TaskDTO.class);
    }

    @Override
    public List<TaskDTO> getTasksByProject(Long projectId) {
        return taskRepository.findByProjectId(projectId)
                .stream()
                .map(task -> mapper.map(task, TaskDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
