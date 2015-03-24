package 查询部分;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import javax.swing.*;

import 登录部分.log_again_frame;
import 登录部分.log_succes_frame;
public class welcome {

	public welcome() {
		
		JFrame frame=new JFrame("he frame");
		   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		   
		   welpanel p=new welpanel();
		   frame.getContentPane().add(p);
		   frame.pack();
		   frame.setVisible(true);
	}

	class welpanel extends JPanel{

		private JButton b1,b2,b3,b4,b5;
		private JComboBox jc1 ,jc2 ;
		private JTextField jt1;
		private JLabel jl1,jl2,jl3;
		private Connection conn = null;
		private Statement stmt = null;
		private ResultSet rs = null;
		private String s1,s2;
		public welpanel(){
			setLayout(null);
			
			String []st={"s1","s2","s3","s4","s5","s6","s7","s8","s9","s10","s11","s12","s13",""};
			this.jc1 = new JComboBox(st);
			this.jc2 = new JComboBox(st);
			 jc1.setBounds(40, 20, 150, 30);
			 jc2.setBounds(300, 20, 150, 30);
			 
			jt1=new JTextField(100);
		    jt1.setBounds(0,300, 600, 300);
			 
			b1 = new JButton("最便宜的路线");
			b2 = new JButton("最短的路线");
			b3 = new JButton("最省时间的路线");
			b4 = new JButton("清屏");
			b5 = new JButton("退出");
			
			b1.setBounds(20, 100, 85, 40);
			b2.setBounds(122, 100, 85, 40);
			b3.setBounds(230, 100, 85, 40);
			b4.setBounds(350, 100, 85, 40); 
			b5.setBounds(459, 100, 85, 40);
			
			b1.addActionListener(new ButtonListener());
			b2.addActionListener(new ButtonListener());
			b3.addActionListener(new ButtonListener());
			b4.addActionListener(new ButtonListener());
			
			jl1=new JLabel("从");
			jl2=new JLabel("到");
	    	jl1.setBounds(10,  20,30, 30);
	    	jl2.setBounds(245,  20,30, 30);
	
			add(jl1);
			add(jl2);
			
			add(b1);
			add(b2);
			add(b3);
			add(b4);
			add(b5);
		
			add(jc1);
			add(jc2);
			
		    add(jt1);

			setPreferredSize(new Dimension(600, 600));
		}
		private class ButtonListener implements ActionListener {

			
			public void actionPerformed(ActionEvent e) {
				s1 = (String) jc1.getSelectedItem();//取得当前值；
				s2 = (String) jc2.getSelectedItem();//取得当前值；
				if (e.getSource()==b1)
				{	
				    TestMysqlConnect();
				}     
				if (e.getSource()==b2)
				{
					jt1.setText(" b");
				}
				if (e.getSource()==b3)
					{
					jt1.setText("c");
					}
				if (e.getSource()==b4)
					{
					jc1.setSelectedItem("");
					
				    jc2.setSelectedItem("");
				    jt1.setText("  ");
			}
			}
		}
		public void TestMysqlConnect() {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager
						.getConnection("jdbc:mysql://localhost/mydata?"
								+ "user=root&password=root");
				stmt = conn.createStatement();
			
				rs = stmt.executeQuery("select * from bus_shiyan");
				Testbus_search_single_line();
			
			}	
				catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException ex) {
				System.out.println("SQLException: " + ex.getMessage());
				System.out.println("SQLState: " + ex.getSQLState());
				System.out.println("VendorError: " + ex.getErrorCode());
			} finally {
				try {
					if (rs != null) {
						rs.close();
						rs = null;
					}
					if (stmt != null) {
						stmt.close();
						stmt = null;
					}
					if (conn != null) {
						conn.close();
						conn = null;
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}
//	public void insert_JComboBox(){
//			
//			ArrayList<String> list1 = new ArrayList<String>();// 创建取结果的列表，之所以使用列表，不用数组，因为现在还不知道结果有多少，不能确定数组长度，所有先用list接收，然后转为数组
//    		ArrayList<String> list2 = new ArrayList<String>();
//    		String[] arr1 ;
//		    String[] arr2;
//    		try {
//				while (rs.next()){
//					list1.add(rs.getString(2));
//    				list2.add(rs.getString(3));
//    			
//				}
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//    		if (list1 != null && list1.size() > 0&&list2 != null && list2.size() > 0)
//    		{	 arr1 = new String[list1.size()];// 创建一个和list长度一样的数组
//			      arr2= new String[list2.size()];
//			      int count=0;
//			      for (int i = 0; i < list1.size(); i++) {
//		    			arr1[i] = list1.get(i);
//		    			arr2[i] = list2.get(i);
//						count++;
//			      }	
//			      this.jc1 = new JComboBox(arr1);// 下拉列表
//				  this.jc2 = new JComboBox(arr2);
//				  }
//    		
//    		
    		//}
        public void Testbus_search_single_line(){
        	
        		ArrayList<String> list2 = new ArrayList<String>();// 创建取结果的列表，之所以使用列表，不用数组，因为现在还不知道结果有多少，不能确定数组长度，所有先用list接收，然后转为数组
        		ArrayList<String> list3 = new ArrayList<String>();
        		Vector<Integer> list1 = new Vector<Integer>();
        		Vector<Integer> list4 = new Vector<Integer>();
        		
        		try {
        			
        			while (rs.next()) {// 如果有数据，取第二列添加如list
        				list2.add(rs.getString(2));
        				list3.add(rs.getString(3));
        				
        				list1.add(rs.getInt(1));
        				list4.add(rs.getInt(4));
        			}
        		} catch (SQLException e) {
        			
        			e.printStackTrace();
        		}
        		

        		if (list1 != null && list1.size() > 0&&list2 != null && list2.size() > 0&&list3 != null && list3.size() > 0&&list4 != null && list4.size() > 0) {// 如果list中存入了数据，转化为数组
        			String[] arr2 = new String[list2.size()];// 创建一个和list长度一样的数组
        			String[] arr3= new String[list3.size()];
        			int[] arr1=new int[list1.size()];
        			int[] arr4=new int[list4.size()];
        			for (int i = 0; i < list1.size(); i++) {
        				arr2[i] = list2.get(i);// 数组赋值了。
        				arr1[i] = Integer.parseInt(list1.get(i).toString());
        				arr3[i] = list3.get(i);// 数组赋值了。
        				arr4[i] = Integer.parseInt(list4.get(i).toString());
        				
        			}
        		
        			for (int i = 0; i < arr1.length; i++) {
        				
        				if(arr2[i].equals((String) jc1.getSelectedItem())&&arr3[i].equals((String) jc2.getSelectedItem()))
        					{
        					jt1.setText("请乘坐         "+String.valueOf(arr1[i])+"      号线路"+
        					",共需         "+String.valueOf(arr4[i])+"      站路");
        					System.out.println(arr1[i]);
        					
        					}	
        				if(arr3[i].equals((String) jc1.getSelectedItem())&&arr2[i].equals((String) jc2.getSelectedItem()))
    					{
        					jt1.setText("请乘坐         "+String.valueOf(arr1[i])+"      号线路"+
                					",共需         "+String.valueOf(arr4[i])+"      站路");
    					}
        			}
        			
        		}
        		
        	}
        public void Testbus_search_some_line(){
        	
        }
        }
}
