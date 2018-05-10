package com.jack.task.excutor;

import org.springframework.context.ApplicationContext;

import com.jack.task.bean.TaskInfoBean;
import com.jack.task.excutor.base.AbstractTaskExcutor;
import com.jack.task.service.ITaskService;

/**
 * 任务执行器：
 * 用于给ThreadPoolTaskScheduler提供实现了runnable接口的任务。
 * @author Administrator
 *
 */
public class TaskExcutor extends AbstractTaskExcutor{

	
	/**
	 * 
	 * @param taskInfoBean 任务信息实体
	 * @param applicationContext spring上下文
	 */
	public TaskExcutor(TaskInfoBean taskInfoBean,ApplicationContext applicationContext) {
		super(taskInfoBean, applicationContext);
	}
	
	@Override
	public void excuteJob() {
		// 查找bean
		if (!applicationContext.containsBean(taskInfoBean.getServiceName())) {
			System.err.println("无法找到bean：" + taskInfoBean.getServiceName() + "，定时任务（"
					+ taskInfoBean.getTaskName() + "）运行失败！");
			return;
		}
		try {
			Object service = applicationContext.getBean(taskInfoBean.getServiceName());
			if (service instanceof ITaskService) {
				service = (ITaskService)service;
				((ITaskService) service).startJob();
			}else {
				throw new Exception("当前服务["+taskInfoBean.getServiceName()+"]不是定时任务，终止执行！");
			}
		
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("服务：" + taskInfoBean.getServiceName()
					+ "定时任务（"
					+ taskInfoBean.getTaskName() + "）执行出现异常，执行失败！");
		}
	}
	
	/*
	 * 需要自定义定时任务服务的运行方法（method）
	 * 通过反射来执行任务的运行方法
	 */
//	@Override
//	public void excuteJob() {
//		// 查找bean
//		if (!applicationContext.containsBean(taskInfoBean.getServiceName())) {
//			System.err.println("无法找到bean：" + taskInfoBean.getServiceName() + "，定时任务（"
//					+ taskInfoBean.getTaskName() + "）运行失败！");
//			return;
//		}
//		Object service = applicationContext.getBean(taskInfoBean.getServiceName());
//		Method method = null;
//		try {
//			method = service.getClass().getMethod(taskInfoBean.getServiceMethod());
//			method.invoke(service);
//		
//		} catch (Exception e) {
//			e.printStackTrace();
//			System.err.println("无法找到方法：" + taskInfoBean.getServiceName() + "."
//					+ taskInfoBean.getServiceMethod()
//					+ "定时任务（"
//					+ taskInfoBean.getTaskName() + "）执行失败！");
//		}
//	}
	

}
