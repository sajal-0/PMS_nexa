package com.project.ProjectManagement.Service;

import java.util.List;

import com.project.ProjectManagement.DTOs.ProjectDTO;

public interface ProjectService {
    ProjectDTO addProject(ProjectDTO dto);
    ProjectDTO updateProject(Long id, ProjectDTO dto);
    List<ProjectDTO> getProjectsByClient(Long clientId);
    ProjectDTO getProjectById(Long id);
    void deleteProject(Long id);
}