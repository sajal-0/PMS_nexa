package com.project.ProjectManagement.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ProjectManagement.DTOs.ProjectDTO;
import com.project.ProjectManagement.Entity.Client;
import com.project.ProjectManagement.Entity.Project;
import com.project.ProjectManagement.Repository.ClientRepository;
import com.project.ProjectManagement.Repository.ProjectRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepo;

    @Autowired
    private ClientRepository clientRepo;

    private ProjectDTO toDTO(Project p) {
        ProjectDTO dto = new ProjectDTO();
        dto.setId(p.getId());
        dto.setName(p.getName());
        dto.setDescription(p.getDescription());
        dto.setBudget(p.getBudget());
        dto.setStartDate(p.getStartDate());
        dto.setEndDate(p.getEndDate());
        dto.setClientId(p.getClient().getId());
        return dto;
    }

    private Project toEntity(ProjectDTO dto, Client client) {
        Project p = new Project();
        p.setId(dto.getId());
        p.setName(dto.getName());
        p.setDescription(dto.getDescription());
        p.setBudget(dto.getBudget());
        p.setStartDate(dto.getStartDate());
        p.setEndDate(dto.getEndDate());
        p.setClient(client);
        return p;
    }

    @Override
    public ProjectDTO addProject(ProjectDTO dto) {
        Client client = clientRepo.findById(dto.getClientId())
                .orElseThrow(() -> new RuntimeException("Client not found"));
        Project saved = projectRepo.save(toEntity(dto, client));
        return toDTO(saved);
    }

    @Override
    public ProjectDTO updateProject(Long id, ProjectDTO dto) {
        Project existing = projectRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Project not found"));
        existing.setName(dto.getName());
        existing.setDescription(dto.getDescription());
        existing.setBudget(dto.getBudget());
        existing.setStartDate(dto.getStartDate());
        existing.setEndDate(dto.getEndDate());
        if (dto.getClientId() != null) {
            Client client = clientRepo.findById(dto.getClientId())
                    .orElseThrow(() -> new RuntimeException("Client not found"));
            existing.setClient(client);
        }
        return toDTO(projectRepo.save(existing));
    }

    @Override
    public List<ProjectDTO> getProjectsByClient(Long clientId) {
        return projectRepo.findByClientId(clientId).stream()
                .map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public ProjectDTO getProjectById(Long id) {
        return projectRepo.findById(id).map(this::toDTO)
                .orElseThrow(() -> new RuntimeException("Project not found"));
    }

    @Override
    public void deleteProject(Long id) {
        projectRepo.deleteById(id);
    }
}
