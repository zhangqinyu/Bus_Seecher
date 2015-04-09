package 登录部分;

import java.util.Date; 
import java.util.Calendar; 
import java.text.SimpleDateFormat; 
public class time_xianshi{ 
	private String time;
public time_xianshi(String time){ 
	this.time=time;
}
public String time(){
Date now = new Date(); 
SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//可以方便地修改日期格式
time = dateFormat.format( now ); 
System.out.println(time); 
return time;
} 
}
