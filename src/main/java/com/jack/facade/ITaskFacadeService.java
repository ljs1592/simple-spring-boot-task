package com.jack.facade;

import com.jack.task.bean.TaskInfoBean;

public interface ITaskFacadeService {
	
	/**
	 * 执行任务
	 * @param taskInfoBean
	 */
	public void excuteJob(TaskInfoBean taskInfoBean);
	
	/**
	 * 添加任务
	 * @param taskInfoBean
	 */
	public void addJob(TaskInfoBean taskInfoBean);
	
	/**
	 * 停止任务
	 * @param taskInfoBean
	 */
	public void stopJob(TaskInfoBean taskInfoBean);

}
