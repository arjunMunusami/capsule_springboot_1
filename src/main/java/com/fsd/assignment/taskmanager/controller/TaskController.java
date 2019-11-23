package com.fsd.assignment.taskmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fsd.assignment.taskmanager.entity.TaskEntity;
import com.fsd.assignment.taskmanager.exception.BusinessException;
import com.fsd.assignment.taskmanager.model.TaskSearchVO;
import com.fsd.assignment.taskmanager.service.TaskManagerServiceImpl;

@RestController
@RequestMapping(value = "/task/")
public class TaskController {
	
	@Autowired
	private TaskManagerServiceImpl service;
	
	@RequestMapping(value = {"/addTask","/updateTask"}, method = {RequestMethod.POST})
	public String addTask(Model model,@ModelAttribute TaskEntity taskData) {
		String msg = null;
		try {
			taskData = service.saveTaskDetails(taskData);
		} catch (BusinessException e) {
			msg = e.getMessage();
		}
		return msg;
	}
	
	@RequestMapping(value = "/searchTask", method = {RequestMethod.POST})
	public TaskSearchVO searchTask(Model model,@ModelAttribute TaskSearchVO taskSearch) {
		List<TaskEntity> taskDetails;
		try {
			taskDetails = service.fetchTaskDetails(taskSearch);
			taskSearch.setTaskEntityList(taskDetails);
		} catch (RuntimeException e) {
			taskSearch.setErrorMsg(e.getMessage());
		}
		return taskSearch;
	}
	
}
