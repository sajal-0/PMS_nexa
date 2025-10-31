package com.project.ProjectManagement.Security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.project.ProjectManagement.Entity.Employee;
import com.project.ProjectManagement.Entity.Role;
import com.project.ProjectManagement.Enums.Status;
import com.project.ProjectManagement.Repository.EmployeeRepository;
import com.project.ProjectManagement.Repository.RoleRepository;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {

        // ✅ Create base roles if not exist
        createRoleIfNotExists("ADMIN", "Full access to all modules");
        createRoleIfNotExists("MANAGER", "Can approve and manage projects");
        createRoleIfNotExists("EMPLOYEE", "Can log time and view assigned tasks");

        // ✅ Create default admin user if none exists
        if (employeeRepository.findByEmail("admin@example.com").isEmpty()) {
            Employee admin = new Employee();
            admin.setName("System Admin");
            admin.setEmail("admin@example.com");
            admin.setPassword(passwordEncoder.encode("Admin@123"));
            admin.setRole(roleRepository.findByName("ADMIN").get());
            admin.setStatus(Status.ACTIVE);
            employeeRepository.save(admin);
            System.out.println("✅ Default admin created: admin@example.com / Admin@123");
        }
    }

    private void createRoleIfNotExists(String name, String description) {
        roleRepository.findByName(name).orElseGet(() -> {
            Role role = new Role();
            role.setName(name);
            role.setDescription(description);
            return roleRepository.save(role);
        });
    }
}
