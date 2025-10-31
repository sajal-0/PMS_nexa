package com.project.ProjectManagement.Security.service;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.project.ProjectManagement.Entity.Employee;
import com.project.ProjectManagement.Enums.Status;

public class CustomUserDetails implements UserDetails {

    private final Employee employee;

    public CustomUserDetails(Employee employee) {
        this.employee = employee;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (employee.getRole() != null && employee.getRole().getName() != null) {
            return List.of(new SimpleGrantedAuthority("ROLE_" + employee.getRole().getName().toUpperCase()));
        }
        return List.of(); // no roles assigned
    }

    @Override
    public String getPassword() {
    	return employee.getPassword();
    }

    @Override
    public String getUsername() {
        return employee.getEmail();
    }

    @Override
    public boolean isEnabled() {
        return employee.getStatus() == Status.ACTIVE;
    }

    @Override
    public boolean isAccountNonExpired() { return true; }

    @Override
    public boolean isAccountNonLocked() { return true; }

    @Override
    public boolean isCredentialsNonExpired() { return true; }
}