package com.project.ProjectManagement.Service;



import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ProjectManagement.DTOs.SubtaskDTO;
import com.project.ProjectManagement.Entity.Subtask;
import com.project.ProjectManagement.Entity.Task;
import com.project.ProjectManagement.Enums.ApprovalStatus;
import com.project.ProjectManagement.Enums.ProjectStatus;
import com.project.ProjectManagement.Repository.SubtaskRepository;
import com.project.ProjectManagement.Repository.TaskRepository;


@Service
public class SubtaskServiceImpl implements SubtaskService {

    @Autowired
    private SubtaskRepository subtaskRepository;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public SubtaskDTO createSubtask(SubtaskDTO dto) {
        Task task = taskRepository.findById(dto.getTaskId())
                .orElseThrow(() -> new RuntimeException("Task not found"));

        Subtask subtask = mapper.map(dto, Subtask.class);
        subtask.setTask(task);
        subtask.setProjectStatus(dto.getProjectStatus() != null ? dto.getProjectStatus() : ProjectStatus.NOT_STARTED);
        subtask.setApprovalStatus(dto.getApprovalStatus() != null ? dto.getApprovalStatus() : ApprovalStatus.PENDING);

        Subtask saved = subtaskRepository.save(subtask);
        return mapper.map(saved, SubtaskDTO.class);
    }
    
    @Override
    public List<SubtaskDTO> createSubtasksMulti(List<SubtaskDTO> dtoList) {
        List<Subtask> subtasks = dtoList.stream().map(dto -> {
            Task task = taskRepository.findById(dto.getTaskId())
                    .orElseThrow(() -> new RuntimeException("Task not found for ID: " + dto.getTaskId()));

            Subtask subtask = mapper.map(dto, Subtask.class);
            subtask.setTask(task);
            subtask.setProjectStatus(dto.getProjectStatus() != null ? dto.getProjectStatus() : ProjectStatus.NOT_STARTED);
            subtask.setApprovalStatus(dto.getApprovalStatus() != null ? dto.getApprovalStatus() : ApprovalStatus.PENDING);

            return subtask;
        }).collect(Collectors.toList());

        List<Subtask> savedSubtasks = subtaskRepository.saveAll(subtasks);

        return savedSubtasks.stream()
                .map(subtask -> mapper.map(subtask, SubtaskDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public SubtaskDTO updateSubtask(Long id, SubtaskDTO dto) {
        Subtask subtask = subtaskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Subtask not found"));

        subtask.setTitle(dto.getTitle());
        subtask.setProjectStatus(dto.getProjectStatus());
        subtask.setApprovalStatus(dto.getApprovalStatus());
        subtask.setApprovedBy(dto.getApprovedBy());
        subtask.setDeadline(dto.getDeadline());

        Subtask updated = subtaskRepository.save(subtask);
        return mapper.map(updated, SubtaskDTO.class);
    }

    @Override
    public List<SubtaskDTO> getSubtasksByTask(Long taskId) {
        return subtaskRepository.findByTaskId(taskId)
                .stream()
                .map(sub -> mapper.map(sub, SubtaskDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteSubtask(Long id) {
        subtaskRepository.deleteById(id);
    }
}
