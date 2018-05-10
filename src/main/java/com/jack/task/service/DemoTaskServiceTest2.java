package com.jack.task.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;


@Service(value="demoService2")
public class DemoTaskServiceTest2 implements ITaskService{

	
	@Override
	@Async(value="quartzJob")
	public void startJob() {
		System.err.println("任务线程[]执行定时任务===================>>>>>>>>>>");
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINESE);
		
		String date = format.format(new Date(System.currentTimeMillis())); 
		
		System.out.println("当前线程："+Thread.currentThread().getName()+",当前时间=========>>>>>>>>>"+date);
	}
	
}
