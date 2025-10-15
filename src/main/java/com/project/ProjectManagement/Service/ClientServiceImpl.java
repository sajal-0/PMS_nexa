package com.project.ProjectManagement.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ProjectManagement.DTOs.ClientDTO;
import com.project.ProjectManagement.Entity.Client;
import com.project.ProjectManagement.Enums.Status;
import com.project.ProjectManagement.Repository.ClientRepository;
@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepo;

    private ClientDTO toDTO(Client c) {
        ClientDTO dto = new ClientDTO();
        dto.setId(c.getId());
        dto.setName(c.getName());
        dto.setCompany(c.getCompany());
        dto.setEmail(c.getEmail());
        dto.setAddress(c.getAddress());
        dto.setStatus(c.getStatus().name());
        return dto;
    }

    private Client toEntity(ClientDTO dto) {
        Client c = new Client();
        c.setId(dto.getId());
        c.setName(dto.getName());
        c.setCompany(dto.getCompany());
        c.setEmail(dto.getEmail());
        c.setAddress(dto.getAddress());
        if (dto.getStatus() != null) {
        	c.setStatus(Status.valueOf(dto.getStatus().toUpperCase()));	
        }
        return c;
    }

    @Override
    public ClientDTO addClient(ClientDTO dto) {
        Client saved = clientRepo.save(toEntity(dto));
        return toDTO(saved);
    }

    @Override
    public ClientDTO updateClient(Long id, ClientDTO dto) {
        Client existing = clientRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found"));
        existing.setName(dto.getName());
        existing.setCompany(dto.getCompany());
        existing.setEmail(dto.getEmail());
        existing.setAddress(dto.getAddress());
        if (dto.getStatus() != null) {
            existing.setStatus(Status.valueOf(dto.getStatus().toUpperCase()));
        }
        return toDTO(clientRepo.save(existing));
    }

    @Override
    public List<ClientDTO> getAllClients() {
        return clientRepo.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public ClientDTO getClientById(Long id) {
        return clientRepo.findById(id).map(this::toDTO)
                .orElseThrow(() -> new RuntimeException("Client not found"));
    }

    @Override
    public void deleteClient(Long id) {
        clientRepo.deleteById(id);
    }
}