package com.project.ProjectManagement.Service;

import java.util.List;

import com.project.ProjectManagement.DTOs.ClientDTO;

public interface ClientService {
    ClientDTO addClient(ClientDTO dto);
    ClientDTO updateClient(Long id, ClientDTO dto);
    List<ClientDTO> getAllClients();
    ClientDTO getClientById(Long id);
    void deleteClient(Long id);
}