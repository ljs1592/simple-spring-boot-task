package com.jack.facade.impl;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.jack.facade.ITaskFacadeService;
import com.jack.job.TaskEvent;
import com.jack.task.bean.TaskInfoBean;

@Async
@Service
public class TaskFacadeServiceImpl implements ITaskFacadeService,ApplicationContextAware{
	
	private ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	private void publishEvent(TaskEvent event) {
		applicationContext.publishEvent(event);
		System.err.println(Thread.currentThread().getName());
	}

	@Override
	public void excuteJob(TaskInfoBean taskInfoBean) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addJob(TaskInfoBean taskInfoBean) {
		TaskEvent event = new TaskEvent(taskInfoBean, "add");
		this.publishEvent(event);
	}

	@Override
	public void stopJob(TaskInfoBean taskInfoBean) {
		// TODO Auto-generated method stub
		
	}

	
	
	
}
