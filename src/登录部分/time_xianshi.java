package ��¼����;

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
SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//���Է�����޸����ڸ�ʽ
time = dateFormat.format( now ); 
System.out.println(time); 
return time;
} 
}
