package com.project.ProjectManagement.Service;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ProjectManagement.DTOs.EmployeeDTO;
import com.project.ProjectManagement.Entity.Employee;
import com.project.ProjectManagement.Enums.Status;
import com.project.ProjectManagement.Repository.EmployeeRepository;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepo;

    private EmployeeDTO toDTO(Employee e) {
        EmployeeDTO dto = new EmployeeDTO();
        dto.setId(e.getId());
        dto.setName(e.getName());
        dto.setEmail(e.getEmail());
        dto.setDepartment(e.getDepartment());
        dto.setRole(e.getRole());
        dto.setSkills(e.getSkills());
        dto.setDateOfJoining(e.getDateOfJoining());
        dto.setStatus(e.getStatus().name());
        return dto;
    }

    private Employee toEntity(EmployeeDTO dto) {
        Employee e = new Employee();
        e.setId(dto.getId());
        e.setName(dto.getName());
        e.setEmail(dto.getEmail());
        e.setDepartment(dto.getDepartment());
        e.setRole(dto.getRole());
        e.setSkills(dto.getSkills());
        e.setDateOfJoining(dto.getDateOfJoining());
        if (dto.getStatus() != null) {
            e.setStatus(Status.valueOf(dto.getStatus().toUpperCase()));
        }
        return e;
    }

    @Override
    public EmployeeDTO addEmployee(EmployeeDTO dto) {
        Employee saved = employeeRepo.save(toEntity(dto));
        return toDTO(saved);
    }

    @Override
    public EmployeeDTO updateEmployee(Long id, EmployeeDTO dto) {
        Employee existing = employeeRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        existing.setName(dto.getName());
        existing.setEmail(dto.getEmail());
        existing.setDepartment(dto.getDepartment());
        existing.setRole(dto.getRole());
        existing.setSkills(dto.getSkills());
        existing.setDateOfJoining(dto.getDateOfJoining());

        if (dto.getStatus() != null) {
            existing.setStatus(Status.valueOf(dto.getStatus().toUpperCase()));
        }

        return toDTO(employeeRepo.save(existing));
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        return employeeRepo.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO getEmployeeById(Long id) {
        Employee e = employeeRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        return toDTO(e);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepo.deleteById(id);
    }
}