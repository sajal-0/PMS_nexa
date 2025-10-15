package com.project.ProjectManagement.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.ProjectManagement.Entity.Subtask;
import com.project.ProjectManagement.Enums.ApprovalStatus;
import com.project.ProjectManagement.Enums.ProjectStatus;


@Repository
public interface SubtaskRepository extends JpaRepository<Subtask, Long> {
	 // ✅ Find all subtasks for a given task
    List<Subtask> findByTaskId(Long taskId);

    // ✅ Filter subtasks by task and status
    List<Subtask> findByTaskIdAndProjectStatus(Long taskId, ProjectStatus projectStatus);

    // ✅ Find subtasks by approval status
    List<Subtask> findByApprovalStatus(ApprovalStatus approvalStatus);
}
