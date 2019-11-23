package com.fsd.assignment.taskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fsd.assignment.taskmanager.entity.TaskEntity;

@Repository
public interface TaskManagerDAO extends JpaRepository<TaskEntity, Integer> , CustomTaskManagerDAO {
	
	
	public TaskEntity fetchByTaskName(String taskName);
	
	
	
	

}
