package com.project.ProjectManagement.Repository;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.ProjectManagement.Entity.Task;
import com.project.ProjectManagement.Enums.ApprovalStatus;
import com.project.ProjectManagement.Enums.ProjectStatus;


@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
	 // ✅ Find all tasks under a specific project
    List<Task> findByProjectId(Long projectId);

    // ✅ Find all tasks by project and status (useful for filtering)
    List<Task> findByProjectIdAndProjectStatus(Long projectId, ProjectStatus projectStatus);

    // ✅ Find tasks by approval status
    List<Task> findByApprovalStatus(ApprovalStatus approvalStatus);
}
