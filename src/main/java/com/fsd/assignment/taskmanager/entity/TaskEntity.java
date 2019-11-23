package com.fsd.assignment.taskmanager.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="TASK")
public class TaskEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1094820529356437361L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer taskId;
	
	@Column(name="TASK")
	private String taskName;
	
	@Column(name="PRIORITY")
	private Integer taskPriority;
	
	@Column(name="START_END")
	private Date taskStartDt;
	
	@Column(name="END_DATE")
	private Date taskEndDt;
	
	@ManyToOne
	@JoinColumn(name="PARENT_ID", referencedColumnName="TASK_ID")
	private TaskEntity parentTask;

	public Integer getTaskId() {
		return taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public Integer getTaskPriority() {
		return taskPriority;
	}

	public void setTaskPriority(Integer taskPriority) {
		this.taskPriority = taskPriority;
	}

	public Date getTaskStartDt() {
		return taskStartDt;
	}

	public void setTaskStartDt(Date taskStartDt) {
		this.taskStartDt = taskStartDt;
	}

	public Date getTaskEndDt() {
		return taskEndDt;
	}

	public void setTaskEndDt(Date taskEndDt) {
		this.taskEndDt = taskEndDt;
	}

	public TaskEntity getParentTask() {
		return parentTask;
	}

	public void setParentTask(TaskEntity parentTask) {
		this.parentTask = parentTask;
	}

}
