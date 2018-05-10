package com.jack.task.scheduler;

import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

public class TaskSchedulerFactory {
	
	private static ThreadPoolTaskScheduler threadPoolTaskScheduler;
	
	public static synchronized ThreadPoolTaskScheduler getThreadPoolTaskScheduler() {
		if (threadPoolTaskScheduler == null) {
			synchronized(ThreadPoolTaskScheduler.class) {
				if (threadPoolTaskScheduler == null) {
					threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
					threadPoolTaskScheduler.initialize();
				}
			}
		}
		
		return threadPoolTaskScheduler;
	}

}
