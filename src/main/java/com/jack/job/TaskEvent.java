package com.jack.job;

import org.springframework.context.ApplicationEvent;

import com.jack.task.bean.TaskInfoBean;

/**
 * 任务事件实体
 * @author Administrator
 *
 */
public class TaskEvent extends ApplicationEvent{

	/**
	 * 
	 */
	private static final long serialVersionUID = 154798074612011291L;
	
	public static final String add_task = "add";
	public static final String excute_task = "excute";
	public static final String stop_task = "stop";
	
	private TaskInfoBean taskInfoBean;
	
	private String excuteType;
	
	public TaskEvent(TaskInfoBean taskInfoBean,String excuteType) {
		super(taskInfoBean);
		this.taskInfoBean = taskInfoBean;
		this.excuteType = excuteType;
	}
	

	public TaskInfoBean getTaskInfoBean() {
		return taskInfoBean;
	}

	public void setTaskInfoBean(TaskInfoBean taskInfoBean) {
		this.taskInfoBean = taskInfoBean;
	}

	public String getExcuteType() {
		return excuteType;
	}

	public void setExcuteType(String excuteType) {
		this.excuteType = excuteType;
	}
	
	

}
