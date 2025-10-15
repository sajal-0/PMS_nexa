package com.project.ProjectManagement.Service;

import java.util.List;

import com.project.ProjectManagement.DTOs.EmployeeDTO;

public interface EmployeeService {
    EmployeeDTO addEmployee(EmployeeDTO dto);
    EmployeeDTO updateEmployee(Long id, EmployeeDTO dto);
    List<EmployeeDTO> getAllEmployees();
    EmployeeDTO getEmployeeById(Long id);
    void deleteEmployee(Long id);
}