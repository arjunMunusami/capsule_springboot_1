package com.fsd.assignment.taskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.fsd.assignment.taskmanager.entity.TaskEntity;

@EnableJpaRepositories
public interface TaskManagerDAO extends JpaRepository<TaskEntity, Integer> , CustomTaskManagerDAO {
	
	
	public TaskEntity findByTaskName(String taskName);
	
	
	
	

}
