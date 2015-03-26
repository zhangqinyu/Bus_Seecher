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
		private Statement stmt1 = null,stmt2= null;
		private ResultSet rs1 = null,rs2 = null;
		private String s1,s2;
		private boolean bl=true;//判断使用哪种方法； 
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
					Testbus_search_single_line();
					new Test();
				}     
				if (e.getSource()==b2)
				{   
					Testbus_search_two_line();
					
				}
				if (e.getSource()==b3)
					{
					Testbus_search_three_line();
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
		
        public void Testbus_search_single_line(){
        	
        		ArrayList<String> list2 = new ArrayList<String>();// 创建取结果的列表，之所以使用列表，不用数组，因为现在还不知道结果有多少，不能确定数组长度，所有先用list接收，然后转为数组
        		ArrayList<String> list3 = new ArrayList<String>();
        		Vector<Integer> list1 = new Vector<Integer>();
        		Vector<Integer> list4 = new Vector<Integer>();
        		
        		try {
        			Class.forName("com.mysql.jdbc.Driver");
    				conn = DriverManager
    						.getConnection("jdbc:mysql://localhost/mydata?"
    								+ "user=root&password=root");
    				stmt1 = conn.createStatement();
    			
    				rs1 = stmt1.executeQuery("select * from bustest ");
        			
        			while (rs1.next()) {// 如果有数据，取第二列添加如list
        				list2.add(rs1.getString(2));
        				list3.add(rs1.getString(3));
        				
        				list1.add(rs1.getInt(1));
        				list4.add(rs1.getInt(4));
        			}
        		}catch (ClassNotFoundException e) {
    				e.printStackTrace();
    			} catch (SQLException ex) {
    				System.out.println("SQLException: " + ex.getMessage());
    				System.out.println("SQLState: " + ex.getSQLState());
    				System.out.println("VendorError: " + ex.getErrorCode());
    			} finally {
    				try {
    					if (rs1 != null) {
    						rs1.close();
    						rs1 = null;
    					}
    					if (stmt1 != null) {
    						stmt1.close();
    						stmt1 = null;
    					}
    					if (conn != null) {
    						conn.close();
    						conn = null;
    					}
    				} catch (SQLException e) {
    					e.printStackTrace();
    				}
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
        					System.out.println("h");
        					jt1.setText("请乘坐         "+String.valueOf(arr1[i])+"      号线路"+
        					",共需         "+String.valueOf(arr4[i])+"      站路") ;	
        					
        					}
  
        			}
        			
        		}
        		
        	}
        public void Testbus_search_two_line(){
        	try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager
						.getConnection("jdbc:mysql://localhost/mydata?"
								+ "user=root&password=root");
				stmt2 = conn.createStatement();

        		rs2 = stmt2.executeQuery("SELECT x.`乘坐路线`as 起始公交,x.`起点`as 出发站, x.`终点`as 中转站,x.`票价`,x.`站点数`,"
        				+ "y.`乘坐路线`as 换乘公交,y.`终点`as 终点站,y.`票价`,y.`站点数`,	"
        				+ "(x.`站点数`+y.`站点数`)as 总站数,(x.`票价`+y.`票价`)as 总票价"
        				+ " FROM `bustest` x,`bustest` y "
        				+ "where x.起点='"+(String) jc1.getSelectedItem()+"'"
        						+ "and x.终点=y.起点 "
        						+ "and y.终点='"+(String) jc2.getSelectedItem()+"'"
        								+ "and x.`乘坐路线`!=y.`乘坐路线`"
										);
        		//下面是最短最便宜的算法；
        		//rs2 = stmt2.executeQuery("SELECT *,(x.`站点数`+y.`站点数`)as su  FROM `bustest` x,`bustest` y"
//						+ " where x.起点='"+(String) jc1.getSelectedItem()+"'"
//								+ "and x.终点=y.起点 and y.终点='"+(String) jc2.getSelectedItem()+"' "
//										+ "and (x.`站点数`+y.`站点数`)<=all(SELECT (x.`站点数`+y.`站点数`)  as su FROM `bustest` x,`bustest` y where x.起点='"+(String) jc1.getSelectedItem()+"'and x.终点=y.起点 and y.终点='"+(String) jc2.getSelectedItem()+"')");
				while(rs2.next())
				{
					
					System.out.println(rs2.getString(1)+" "+
							        rs2.getString(2)+" "+
									rs2.getString(3)+" "+
									rs2.getString(4)+" "+
									rs2.getString(5)+" "+
									rs2.getString(6)+" "+
									rs2.getString(7)+" "+
									rs2.getString(8)+" "+
									rs2.getString(9)+" "+
									rs2.getString(10)+" "+
									rs2.getString(11));
					
//					jt1.setText(rs2.getString("乘坐路线1"));
//					jt1.setText(rs2.getString(2));
//					jt1.setText(rs2.getString(3));
//					jt1.setText(rs2.getString(4));
//					jt1.setText(rs2.getString(5));
//					jt1.setText(rs2.getString(6));
//					jt1.setText(rs2.getString(7));
//					jt1.setText(rs2.getString(8));
//					jt1.setText(rs2.getString(9));
//					jt1.setText(rs2.getString(10));
//					jt1.setText(rs2.getString(11));
					
				}
			
			}	
				catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException ex) {
				System.out.println("SQLException: " + ex.getMessage());
				System.out.println("SQLState: " + ex.getSQLState());
				System.out.println("VendorError: " + ex.getErrorCode());
			} finally {
				try {
					if (rs2 != null) {
						rs2.close();
						rs2 = null;
					}
					if (stmt2 != null) {
						stmt2.close();
						stmt2 = null;
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
        public void Testbus_search_three_line(){
        	try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager
						.getConnection("jdbc:mysql://localhost/mydata?"
								+ "user=root&password=root");
				stmt2 = conn.createStatement();
			
				rs2 = stmt2.executeQuery("SELECT * FROM `bustest` x,`bustest` y,`bustest` z"
						+ " where x.起点='"+(String) jc1.getSelectedItem()+"'"
								+ "and x.终点=y.起点 "
								+ "and y.终点=z.起点"
								+ " and z.终点='"+(String) jc1.getSelectedItem()+"';");
				while(rs2.next())
				{
					System.out.println(rs2.getString(1)+" "+
							        rs2.getString(2)+" "+
									rs2.getString(3)+" "+
									rs2.getString(4)+" "+
									rs2.getString(5)+" "+
									rs2.getString(6)+" "+
									rs2.getString(7)+" "+
									rs2.getString(8)+" "+
									rs2.getString(9)+" "+
									rs2.getString(10)+" "+
									rs2.getString(11)+" "+
									rs2.getString(12));
				}
			
			}	
				catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException ex) {
				System.out.println("SQLException: " + ex.getMessage());
				System.out.println("SQLState: " + ex.getSQLState());
				System.out.println("VendorError: " + ex.getErrorCode());
			} finally {
				try {
					if (rs2 != null) {
						rs2.close();
						rs2 = null;
					}
					if (stmt2 != null) {
						stmt2.close();
						stmt2 = null;
					}
					if (conn != null) {
						conn.close();
						conn = null;
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
        }}}
	
