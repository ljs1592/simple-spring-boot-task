# simple-spring-boot-task
A simple timed task application base on spring boot

一个简单的基于spring boot的定时任务工程。

定时任务编写：

		1.编写定时任务服务：实现com.jack.task.service.ITaskService接口，编写定时任务实现。注意：必须自定义@service的value值。
		
		2.定义定时任务信息：在com.jack.task.dao.TaskInfoBeanDao.initTaskInfoBeanList()添加自己定义的定时的任务，项目启动时会将这些任务加入定时任务时间表。（住：在实际项目应用时当然应该从持久化仓库里获取已定义的定时任务）
											
		3.定时任务线程池配置：定时任务都是异步执行，其异步的线程池配置在src/main/resource/application.yml里。配置如下：
		
			spring:
				task:
					pool:
						corePoolSize: 10
						maxPoolSize: 20
						queueCapacity: 600
						keepAliveSeconds: 1000
		
maven引用该工程：
	
	依赖如下：
	
			<dependency>
				<groupId>com.jack</groupId>
				<artifactId>simple-spring-boot-task</artifactId>
				<version>0.0.1-SNAPSHOT</version>
			</dependency>
			
	调用该工程方法：

		为与其它工程解耦，调用时仅能通过com.jack.facade.ITaskFacadeService该门面接口调用该工程（门面模式）。
