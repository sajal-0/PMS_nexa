package com.project.ProjectManagement.Service;

import java.util.List;

import com.project.ProjectManagement.DTOs.SubtaskDTO;

public interface SubtaskService {
    SubtaskDTO createSubtask(SubtaskDTO dto);
    List<SubtaskDTO> createSubtasksMulti(List<SubtaskDTO> dtoList);
    SubtaskDTO updateSubtask(Long id, SubtaskDTO dto);
    List<SubtaskDTO> getSubtasksByTask(Long taskId);
    void deleteSubtask(Long id);
}