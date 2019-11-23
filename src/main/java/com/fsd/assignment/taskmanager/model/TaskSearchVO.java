package com.fsd.assignment.taskmanager.model;

import java.util.Date;
import java.util.List;

import com.fsd.assignment.taskmanager.entity.TaskEntity;

public class TaskSearchVO {
	
	private String taskName;
	
	private Integer taskMinPriority;
	
	private Integer taskMaxPriority;
	
	private String parentTask;
	
	private Date taskStartDate;
	
	private Date taskEndDate;
	
	private String errorMsg;
	
	private List<TaskEntity> taskEntityList;

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public Integer getTaskMinPriority() {
		return taskMinPriority;
	}

	public void setTaskMinPriority(Integer taskMinPriority) {
		this.taskMinPriority = taskMinPriority;
	}

	public Integer getTaskMaxPriority() {
		return taskMaxPriority;
	}

	public void setTaskMaxPriority(Integer taskMaxPriority) {
		this.taskMaxPriority = taskMaxPriority;
	}

	public String getParentTask() {
		return parentTask;
	}

	public void setParentTask(String parentTask) {
		this.parentTask = parentTask;
	}

	public Date getTaskStartDate() {
		return taskStartDate;
	}

	public void setTaskStartDate(Date taskStartDate) {
		this.taskStartDate = taskStartDate;
	}

	public Date getTaskEndDate() {
		return taskEndDate;
	}

	public void setTaskEndDate(Date taskEndDate) {
		this.taskEndDate = taskEndDate;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public List<TaskEntity> getTaskEntityList() {
		return taskEntityList;
	}

	public void setTaskEntityList(List<TaskEntity> taskEntityList) {
		this.taskEntityList = taskEntityList;
	}

}
