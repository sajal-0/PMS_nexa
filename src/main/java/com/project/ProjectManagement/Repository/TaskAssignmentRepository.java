package com.project.ProjectManagement.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.ProjectManagement.Entity.TaskAssignment;

@Repository
public interface TaskAssignmentRepository extends JpaRepository<TaskAssignment, Long> {

    // ✅ Get all assignments for a specific employee
    List<TaskAssignment> findByEmployeeId(Long employeeId);

    // ✅ Get all employees assigned to a task
    List<TaskAssignment> findByTaskId(Long taskId);

    // ✅ Get all employees assigned to a subtask
    List<TaskAssignment> findBySubtaskId(Long subtaskId);
}
