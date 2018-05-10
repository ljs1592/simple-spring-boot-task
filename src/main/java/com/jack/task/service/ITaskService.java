package com.jack.task.service;

/**
 * 定时任务服务接口：
 * 定时任务的服务的实现方法都要实现该接口
 * @author Administrator
 *
 */
public interface ITaskService {
	
	/**
	 * 开始执行任务
	 */
	public void startJob();
	

}
