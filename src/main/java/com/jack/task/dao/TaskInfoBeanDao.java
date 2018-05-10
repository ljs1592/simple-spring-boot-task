package com.jack.task.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.jack.task.bean.TaskInfoBean;

@Repository
public class TaskInfoBeanDao {
	
	public final static List<TaskInfoBean> initTaskList = new ArrayList<>();
	
	/**
	 * 初始化定时任务信息列表（模拟持久化数据）
	 */
	public void initTaskInfoBeanList() {
		
		TaskInfoBean demoTask1 = new TaskInfoBean("Demo1", "demoService1", "0/10 * * * * ?");
		TaskInfoBean demoTask2 = new TaskInfoBean("Demo2", "demoService2", "3/10 * * * * ?");
		TaskInfoBean demoTask3 = new TaskInfoBean("Demo3", "demoService3", "5/10 * * * * ?");
		initTaskList.add(demoTask1);
		initTaskList.add(demoTask2);
		initTaskList.add(demoTask3);
	}
	
	/**
	 * 获取所有定时任务信息
	 * @return
	 */
	public List<TaskInfoBean> getAllTaskInfo() {
		
		if (initTaskList.size()==0) {
			this.initTaskInfoBeanList();
		}
		
		return initTaskList;
	}

}
