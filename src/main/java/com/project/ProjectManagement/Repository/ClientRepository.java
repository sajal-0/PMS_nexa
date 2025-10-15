package com.project.ProjectManagement.Repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.ProjectManagement.Entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {}
