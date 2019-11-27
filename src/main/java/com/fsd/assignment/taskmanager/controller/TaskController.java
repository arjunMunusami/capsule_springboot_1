package com.fsd.assignment.taskmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fsd.assignment.taskmanager.entity.TaskEntity;
import com.fsd.assignment.taskmanager.exception.BusinessException;
import com.fsd.assignment.taskmanager.model.TaskResultVO;
import com.fsd.assignment.taskmanager.model.TaskSearchVO;
import com.fsd.assignment.taskmanager.service.TaskManagerServiceImpl;

@RestController
@RequestMapping(value = "/task/")
public class TaskController {
	
	@Autowired
	private TaskManagerServiceImpl service;
	
	@RequestMapping(value = {"/addTask","/updateTask"}, method = {RequestMethod.POST})
	public TaskResultVO addTask(Model model,@RequestBody TaskEntity taskData) {
		TaskResultVO taskResult = new TaskResultVO();
		try {
			taskData = service.saveTaskDetails(taskData);
			taskResult.setTaskEntity(taskData);
		} catch (BusinessException e) {
			taskResult.setTaskEntity(taskData);
			taskResult.setErrMsg(e.getMessage());
		}
		return taskResult;
	}
	
	@RequestMapping(value = "/searchTask", method = {RequestMethod.POST})
	public TaskResultVO searchTask(Model model,@RequestBody TaskSearchVO taskSearch) {
		TaskResultVO resultVO = new TaskResultVO();
		
		try {
			List<TaskEntity> taskDetails = service.fetchTaskDetails(taskSearch);
			resultVO.setTaskList(taskDetails);
		} catch (RuntimeException e) {
			resultVO.setErrMsg(e.getMessage());
		}
		return resultVO;
	}
	
	@RequestMapping(value = "/loadTask", method = {RequestMethod.GET})
	public TaskResultVO loadTask(Model model,@RequestParam("taskId") Integer taskId) {
		TaskResultVO resultVO = new TaskResultVO();
		try {
			TaskEntity taskDetail = service.fetchTaskEntity(taskId);
			resultVO.setTaskEntity(taskDetail);
		} catch (RuntimeException e) {
			resultVO.setErrMsg(e.getMessage());
		}
		return resultVO;
	}
	
	@RequestMapping(value = "/endTask/{id}", method = {RequestMethod.GET})
	public TaskResultVO endTask(Model model,@PathVariable("id") Integer taskId) {
		TaskResultVO resultVO = new TaskResultVO();
		try {
			service.endTask(taskId);
		} catch (RuntimeException e) {
			resultVO.setErrMsg(e.getMessage());
		}
		return resultVO;
	}
	
}
