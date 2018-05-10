package com.jack.job;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class TaskNotifier implements ApplicationListener<TaskEvent>{

	
	
	
//	@Async
	@Override
	public void onApplicationEvent(TaskEvent taskEvent) {
		
//		System.err.println("======任务notify");
//		System.err.println(Thread.currentThread().getName());
		
		String excuteType = taskEvent.getExcuteType();
		
		switch (excuteType) {
		case TaskEvent.add_task:
			
			break;

		default:
			break;
		}
		
		
		
	}

}
