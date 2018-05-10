package com.jack.task.bean;

import java.util.UUID;

/**
 * 定时任务基本信息实体
 * @author Administrator
 *
 */
public class TaskInfoBean {

	private String taskId;
	
	/**
	 * 定时任务名称
	 */
	private String taskName;
	
	/**
	 * 定时任务调用服务名
	 */
	private String serviceName;
	
	/**
	 * 定时任务触发cron表达式
	 */
	//第一位,表示秒,取值0-59
	//第二位,表示分,取值0-59
    //第三位,表示小时,取值0-23
	//第四位,日期天/日,取值1-31
	//第五位,日期月份,取值1-12
	//第六位,星期,取值1-7,星期一,星期二...
	//另外:1表示星期天,2表示星期一
	//第7为,年份,可以留空,取值1970-2099
	//(*)星号:可以理解为每的意思,每秒,每分,每天,每月,每年...
	//(?)问号:问号只能出现在日期和星期这两个位置,表示这个位置的值不确定,每天3点执行,所以第六位星期的位置,
	//我们是不需要关注的,就是不确定的值,同时:日期和星期是两个相互排斥的元素,通过问号来表明不指定值,比如,1月10日,比如是星期1,
	//如果在星期的位置是另指定星期二,就前后冲突矛盾了
	//(-)减号：表达一个范围，如在小时字段中使用“10-12”，则表示从10到12点，即10,11,12
	//(,)逗号:表达一个列表值，如在星期字段中使用“1,2,4”,则表示星期一,星期二,星期四
	//(/)斜杠:如：x/y,x是开始值,y是步长,比如在第一位(秒) 0/15就是,从0秒开始,每15秒,最后就是0,15,30,45,60    
	//另：*/y,等同于0/y
	//举个例子： 0/5 * * * * ?  即为从第0秒开始，每5秒运行一次。
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
