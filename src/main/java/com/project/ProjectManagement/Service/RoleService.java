package com.project.ProjectManagement.Service;

import java.util.List;

import com.project.ProjectManagement.Entity.Role;

public interface RoleService {
    Role createRole(Role role);
    Role updateRole(Long id, Role role);
    void deleteRole(Long id);
    List<Role> getAllRoles();
    Role getRoleByName(String name);
}
