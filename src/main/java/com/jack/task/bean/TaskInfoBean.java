package com.jack.task.bean;

import java.util.Date;
import java.util.UUID;

/**
 * 定时任务基本信息实体
 * @author Administrator
 *
 */
public class TaskInfoBean {

	private String taskId;
	
	private String taskName;
	
	private String serviceName;
	
//	private String serviceMethod;
	
	private Date nextStartTime;
	
	private String cronExpression;
	
	
	
	public TaskInfoBean() {
		this.taskId = generateID();
	}
	
	/**
	 * 
	 * @param taskName 任务名称
	 * @param serviceName 任务服务名
	 * @param serviceMethod 任务服务执行方法名
	 * @param cronExprssion corn表达式
	 */
	public TaskInfoBean(String taskName,String serviceName,String cronExpression) {
		this.taskId = generateID();
		this.taskName = taskName;
		this.serviceName = serviceName;
		this.cronExpression = cronExpression;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

//	public String getServiceMethod() {
//		return serviceMethod;
//	}
//
//	public void setServiceMethod(String serviceMethod) {
//		this.serviceMethod = serviceMethod;
//	}

	public Date getNextStartTime() {
		return nextStartTime;
	}

	public void setNextStartTime(Date nextStartTime) {
		this.nextStartTime = nextStartTime;
	}

	public String getCronExpression() {
		return cronExpression;
	}

	public void setCronExpression(String cronExpression) {
		this.cronExpression = cronExpression;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	
	/**
	 * 生成主键（32位）
	 * 
	 * @return
	 */
	public static String generateID() {
		return generateID(System.currentTimeMillis());
	}
	
	/**
	 * 根据指定时间生成主键
	 * 
	 * @param time
	 * @return
	 */
	public static String generateID(long time) {
		String rtnVal = Long.toHexString(time);
		rtnVal += UUID.randomUUID();
		rtnVal = rtnVal.replaceAll("-", "");
		return rtnVal.substring(0, 32);
	}
}
