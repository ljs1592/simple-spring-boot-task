package com.jack.task.excutor.base;

import java.util.Date;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.support.CronTrigger;

import com.jack.task.bean.TaskInfoBean;

/**
 * 任务执行器抽象类
 * @author Administrator
 *
 */
public abstract class AbstractTaskExcutor implements ITaskExcutorBase,Runnable{

	
	/**
	 * 定时任务信息bean
	 */
	protected TaskInfoBean taskInfoBean;

	/**
	 * Spring上下文
	 */
	protected ApplicationContext applicationContext;
	

	/**
	 * 
	 * @param taskInfoBean 任务信息实体
	 * @param applicationContext spring上下文
	 */
	public AbstractTaskExcutor(TaskInfoBean taskInfoBean,ApplicationContext applicationContext) {
		this.taskInfoBean = taskInfoBean;
		this.applicationContext = applicationContext;
	}
	
	
	public TaskInfoBean getTaskInfoBean() {
		return taskInfoBean;
	}

	public void setTaskInfoBean(TaskInfoBean taskInfoBean) {
		this.taskInfoBean = taskInfoBean;
	}

	
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
	
	/**
	 * 
	 * @return 时间表触发器
	 */
	public Trigger getCronTrigger() {
		String cron = taskInfoBean.getCronExpression();
		TaskTrigger trigger = new TaskTrigger(cron);
		return trigger;
	}
	
	@Override
	public void run() {
		this.excuteJob();
	}
	
	public abstract void excuteJob();
	
}

/**
 * 任务触发器
 * @author Administrator
 *
 */
class TaskTrigger implements Trigger{
	
	private String cron="";
	
	public TaskTrigger(String cron) {
		this.cron = cron;
	}

	@Override
	public Date nextExecutionTime(TriggerContext triggerContext) {
		CronTrigger trigger = new CronTrigger(this.cron);
		Date nextExecDate = trigger.nextExecutionTime(triggerContext);
		
		return nextExecDate;
	}
	
}