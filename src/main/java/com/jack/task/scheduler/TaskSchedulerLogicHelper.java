package com.jack.task.scheduler;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Component;

import com.jack.task.bean.TaskInfoBean;
import com.jack.task.dao.TaskInfoBeanDao;
import com.jack.task.excutor.TaskExcutor;

@Component
public class TaskSchedulerLogicHelper implements ApplicationContextAware,InitializingBean{
	
	
	private static ConcurrentHashMap<String, TaskInfoBean> taskMap = new ConcurrentHashMap<>();
	
	private ApplicationContext applicationContext;
	
	private TaskInfoBeanDao taskInfoBeanDao;
	
	/**
	 * 安排定时任务
	 * @param taskInfoBean
	 */
	public void scheduleTask(TaskInfoBean taskInfoBean) {
		
		ThreadPoolTaskScheduler scheduler = TaskSchedulerFactory.getThreadPoolTaskScheduler();
		boolean isInScheduler = checkIsInScheduler(taskInfoBean);
		if (!isInScheduler) {
			TaskExcutor taskExcutor = new TaskExcutor(taskInfoBean,applicationContext);
			scheduler.schedule(taskExcutor, taskExcutor.getCronTrigger());
			taskMap.put(taskInfoBean.getTaskId(), taskInfoBean);
		}else {
			// TODO 
		}
		
	}
	
	/**
	 * 安排所有已有任务
	 */
	public void scheduleAllTask() {
		
		List<TaskInfoBean> taskList = taskInfoBeanDao.getAllTaskInfo();
		
		for (TaskInfoBean taskInfoBean : taskList) {
			this.scheduleTask(taskInfoBean);
		}
		
	}
	
	
	/**
	 * 检查是否在任务列表内
	 * @param taskInfoBean
	 * @return
	 */
	private static boolean checkIsInScheduler(TaskInfoBean taskInfoBean) {
		
		if (taskMap.containsKey(taskInfoBean.getTaskId())) {
			return true;
		}
		
		return false;
	}


	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
		this.taskInfoBeanDao = applicationContext.getBean(TaskInfoBeanDao.class);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		this.scheduleAllTask();
	}
	

}
