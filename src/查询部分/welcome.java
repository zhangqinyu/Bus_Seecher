package 查询部分;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import javax.swing.*;
import javax.swing.table.JTableHeader;

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
					new Testbus_search_single_line();
					
				}     
				if (e.getSource()==b2)
				{   
					new Testbus_search_two_line();
					
				}
				if (e.getSource()==b3)
					{
					new Testbus_search_three_line();
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
		
	 class Testbus_search_single_line extends JFrame {
			// 定义组件
			private JScrollPane scpDemo;
			private JTableHeader jth;
			private JTable tabDemo;
			// 构造方法
			public Testbus_search_single_line() {
				// 窗体的相关属性的定义
				super("JTable数据绑定示例");
				this.setSize(600,600);
				this.setLayout(null);
				this.setLocation(100, 50);
				// 创建组件
				this.scpDemo = new JScrollPane();
				this.scpDemo.setBounds(0, 0,590, 600);
				
				// 给按钮注册监听
				show_luxian();
				// 将组件加入到窗体中
				add(this.scpDemo);

				// 显示窗体
				this.setVisible(true);
			}

			// 点击按钮时的事件处理
			public void show_luxian() {
				// 以下是连接数据源和显示数据的具体处理方法，请注意下
				try {
					// 获得连接
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn = DriverManager.getConnection(
							"jdbc:mysql://localhost/mydata?"
									+ "user=root&password=root");
					// 建立查询条件
					String sql = "SELECT 乘坐路线 ,起点 ,终点,站点数,票价 from bustest2 where 起点='"+(String) jc1.getSelectedItem()+"' and 终点='"+(String) jc2.getSelectedItem()+"'";
					PreparedStatement pstm = conn.prepareStatement(sql);
					// 执行查询
					ResultSet rs = pstm.executeQuery();
					// 计算有多少条记录
					int count = 0;
					while (rs.next()) {
						count++;
					}
					rs = pstm.executeQuery();
					// 将查询获得的记录数据，转换成适合生成JTable的数据形式
					Object[][] info = new Object[count][5];
					count = 0;
					while (rs.next()) {
						info[count][0] = Integer.valueOf(rs.getInt("乘坐路线"));
						info[count][1] = rs.getString("起点");
						info[count][2] = rs.getString("终点");
						info[count][3] = Integer.valueOf(rs.getInt("站点数"));
						info[count][4] = Integer.valueOf(rs.getInt("票价"));
						count++;
					}
					// 定义表头
					String[] title = { "乘坐路线", "起点","终点" ,"站点数","票价"};
					// 创建JTable
					this.tabDemo = new JTable(info, title);
					// 显示表头
					this.jth = this.tabDemo.getTableHeader();
					// 将JTable加入到带滚动条的面板中
					this.scpDemo.getViewport().add(tabDemo);
				} catch (ClassNotFoundException cnfe) {
					JOptionPane.showMessageDialog(null, "数据源错误", "错误",
							JOptionPane.ERROR_MESSAGE);
				} catch (SQLException sqle) {
					JOptionPane.showMessageDialog(null, "数据操作错误", "错误",
							JOptionPane.ERROR_MESSAGE);
				}
			}

			
		}
	 class Testbus_search_two_line extends JFrame {
			// 定义组件
			private JScrollPane scpDemo;
			private JTableHeader jth;
			private JTable tabDemo;
			// 构造方法
			public Testbus_search_two_line() {
				// 窗体的相关属性的定义
				//super("JTable数据绑定示例");
				super("JTable数据绑定示例");
				this.setSize(600,600);
				this.setLayout(null);
				this.setLocation(100, 50);
				// 创建组件
				this.scpDemo = new JScrollPane();
				this.scpDemo.setBounds(0, 0,590, 600);
				
				// 给按钮注册监听
				show_luxian();
				// 将组件加入到窗体中
				add(this.scpDemo);

				// 显示窗体
				this.setVisible(true);
			}

			// 点击按钮时的事件处理
			public void show_luxian() {
				// 以下是连接数据源和显示数据的具体处理方法，请注意下
				try {
					// 获得连接
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn = DriverManager.getConnection(
							"jdbc:mysql://localhost/mydata?"
									+ "user=root&password=root");
					// 建立查询条件
					String sql = "SELECT x.`乘坐路线`as 起始公交,x.`起点`as 出发站, x.`终点`as 中转站,x.`票价`as 票价1,x.`站点数`as 站点数1,"
		    				+ "y.`乘坐路线`as 换乘公交,y.`终点`as 终点站,y.`票价`as 票价2,y.`站点数`as 站点数2,	"
		    				+ "(x.`站点数`+y.`站点数`)as 总站数,(x.`票价`+y.`票价`)as 总票价"
		    				+ " FROM `bustest` x,`bustest` y "
		    				+ "where x.起点='"+(String) jc1.getSelectedItem()+"'"
		    						+ "and x.终点=y.起点 "
		    						+ "and y.终点='"+(String) jc2.getSelectedItem()+"'"
		    								+ "and x.`乘坐路线`!=y.`乘坐路线`";
					PreparedStatement pstm = conn.prepareStatement(sql);
					// 执行查询
					ResultSet rs = pstm.executeQuery();
					// 计算有多少条记录
					int count = 0;
					while (rs.next()) {
						count++;
					}
					rs = pstm.executeQuery();
					// 将查询获得的记录数据，转换成适合生成JTable的数据形式
					Object[][] info = new Object[count][11];
					count = 0;
					while (rs.next()) {
						info[count][0] = Integer.valueOf(rs.getInt("起始公交"));
						info[count][1] = rs.getString("出发站");
						info[count][2] = rs.getString("中转站");
						info[count][3] = Integer.valueOf(rs.getInt("票价1"));
						info[count][4] = Integer.valueOf(rs.getInt("站点数1"));
						info[count][5] = Integer.valueOf(rs.getInt("换乘公交"));
						info[count][6] = rs.getString("终点站");
						info[count][7] = Integer.valueOf(rs.getInt("票价2"));
						info[count][8] = Integer.valueOf(rs.getInt("站点数2"));
						info[count][9] = Integer.valueOf(rs.getInt("总站数"));
						info[count][10] = Integer.valueOf(rs.getInt("总票价"));
						count++;
					}
					// 定义表头
					String[] title = { "起始公交", "出发站","中转站" ,"票价1","站点数1","换乘公交","终点站","票价2","站点数2","总站数","总票价"};
					// 创建JTable
					this.tabDemo = new JTable(info, title);
					// 显示表头
					this.jth = this.tabDemo.getTableHeader();
					// 将JTable加入到带滚动条的面板中
					this.scpDemo.getViewport().add(tabDemo);
				} catch (ClassNotFoundException cnfe) {
					JOptionPane.showMessageDialog(null, "数据源错误", "错误",
							JOptionPane.ERROR_MESSAGE);
				} catch (SQLException sqle) {
					JOptionPane.showMessageDialog(null, "数据操作错误", "错误",
							JOptionPane.ERROR_MESSAGE);
				}
			}
	 }
	 class Testbus_search_three_line extends JFrame {
			// 定义组件
			private JScrollPane scpDemo;
			private JTableHeader jth;
			private JTable tabDemo;
			// 构造方法
			public Testbus_search_three_line() {
				// 窗体的相关属性的定义
				super("JTable数据绑定示例");
				this.setSize(600,600);
				this.setLayout(null);
				this.setLocation(100, 50);
				// 创建组件
				this.scpDemo = new JScrollPane();
				this.scpDemo.setBounds(0, 0,590, 600);
				
				// 给按钮注册监听
				show_luxian();
				// 将组件加入到窗体中
				add(this.scpDemo);

				// 显示窗体
				this.setVisible(true);
			}

			// 点击按钮时的事件处理
			public void show_luxian() {
				// 以下是连接数据源和显示数据的具体处理方法，请注意下
				try {
					// 获得连接
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn = DriverManager.getConnection(
							"jdbc:mysql://localhost/mydata?"
									+ "user=root&password=root");
					// 建立查询条件
					//String sql ="SELECT x.`乘坐路线`as 起始公交,x.`起点`as 出发站, x.`终点`as 中转站1,x.`票价`as 票价1,x.`站点数`as 站数1,y.`乘坐路线`as 换乘公交1,y.`终点`as 中转站2,y.`票价`as 票价2,y.`站点数`as 站数2, z.`乘坐路线`as 换乘公交2,z.`终点`as 终点站,z.`票价`as 票价3,z.`站点数`as 站数3,(x.`站点数`+y.`站点数`+z.`站点数`) as 总站数,(x.`票价`+y.`票价`+z.`票价`) as 总票价 FROM `bustest` x,`bustest` y,`bustest` z where x.起点='s1' and x.终点=y.起点 and y.终点=z.起点 and z.终点='s12' and x.`乘坐路线` !=y.`乘坐路线` and y.`乘坐路线` !=z.`乘坐路线`";
					String sql ="SELECT x.`乘坐路线`as 起始公交,x.`起点`as 出发站,x.`终点`as 中转站1,x.`票价`as 票价1,x.`站点数`as 站数1,y.`乘坐路线`as 换乘公交1,y.`终点`as 中转站2,y.`票价`as 票价2,y.`站点数`as 站数2, z.`乘坐路线`as 换乘公交2,z.`终点`as 终点站,z.`票价`as 票价3,z.`站点数`as 站数3,(x.`站点数`+y.`站点数`+z.`站点数`) as 总站数,(x.`票价`+y.`票价`+z.`票价`) as 总票价 FROM `bustest` x,`bustest` y,`bustest` z where x.起点='s1' and x.终点=y.起点 and y.终点=z.起点 and z.终点='s12' and x.`乘坐路线` !=y.`乘坐路线` and y.`乘坐路线`!=z.`乘坐路线`";
					PreparedStatement pstm = conn.prepareStatement(sql);
					// 执行查询
					ResultSet rs = pstm.executeQuery();
					// 计算有多少条记录
					int count = 0;
					while (rs.next()) {
						count++;
					}
					rs = pstm.executeQuery();
					// 将查询获得的记录数据，转换成适合生成JTable的数据形式
					Object[][] info = new Object[count][15];
					count = 0;
					while (rs.next()) {
						info[count][0] = Integer.valueOf(rs.getInt("起始公交"));
						info[count][1] = rs.getString("出发站");
						info[count][2] = rs.getString("中转站1");
						info[count][3] = Integer.valueOf(rs.getInt("票价1"));
						info[count][4] = Integer.valueOf(rs.getInt("站点数1"));
						info[count][5] = Integer.valueOf(rs.getInt("换乘公交1"));
						info[count][6] = rs.getString("中转站2");
						info[count][7] = Integer.valueOf(rs.getInt("票价2"));
						info[count][8] = Integer.valueOf(rs.getInt("站点数2"));
						info[count][9] = Integer.valueOf(rs.getInt("换乘公交2"));
						info[count][10] = rs.getString("终点站");
						info[count][11] = Integer.valueOf(rs.getInt("票价3"));
						info[count][12] = Integer.valueOf(rs.getInt("站点数3"));
						info[count][13] = Integer.valueOf(rs.getInt("总站数"));
						info[count][14] = Integer.valueOf(rs.getInt("总票价"));
						count++;
					}
					// 定义表头
					String[] title = { "起始公交", "出发站","中转站1" ,"票价1","站点数1","换乘公交1","中转站2","票价2","站点数2","换乘公交2","终点站","票价3","站点数3","总站数","总票价"};
					// 创建JTable
					this.tabDemo = new JTable(info, title);
					// 显示表头
					this.jth = this.tabDemo.getTableHeader();
					// 将JTable加入到带滚动条的面板中
					this.scpDemo.getViewport().add(tabDemo);
				} catch (ClassNotFoundException cnfe) {
					JOptionPane.showMessageDialog(null, "数据源错误", "错误",
							JOptionPane.ERROR_MESSAGE);
				} catch (SQLException sqle) {
					JOptionPane.showMessageDialog(null, "数据操作错误", "错误",
							JOptionPane.ERROR_MESSAGE);
				}
			}

			
		}
//        public void Testbus_search_single_line(){
//        	
//        		ArrayList<String> list2 = new ArrayList<String>();// 创建取结果的列表，之所以使用列表，不用数组，因为现在还不知道结果有多少，不能确定数组长度，所有先用list接收，然后转为数组
//        		ArrayList<String> list3 = new ArrayList<String>();
//        		Vector<Integer> list1 = new Vector<Integer>();
//        		Vector<Integer> list4 = new Vector<Integer>();
//        		
//        		try {
//        			Class.forName("com.mysql.jdbc.Driver");
//    				conn = DriverManager
//    						.getConnection("jdbc:mysql://localhost/mydata?"
//    								+ "user=root&password=root");
//    				stmt1 = conn.createStatement();
//    			
//    				rs1 = stmt1.executeQuery("select * from bustest ");
//        			
//        			while (rs1.next()) {// 如果有数据，取第二列添加如list
//        				list2.add(rs1.getString(2));
//        				list3.add(rs1.getString(3));
//        				
//        				list1.add(rs1.getInt(1));
//        				list4.add(rs1.getInt(4));
//        			}
//        		}catch (ClassNotFoundException e) {
//    				e.printStackTrace();
//    			} catch (SQLException ex) {
//    				System.out.println("SQLException: " + ex.getMessage());
//    				System.out.println("SQLState: " + ex.getSQLState());
//    				System.out.println("VendorError: " + ex.getErrorCode());
//    			} finally {
//    				try {
//    					if (rs1 != null) {
//    						rs1.close();
//    						rs1 = null;
//    					}
//    					if (stmt1 != null) {
//    						stmt1.close();
//    						stmt1 = null;
//    					}
//    					if (conn != null) {
//    						conn.close();
//    						conn = null;
//    					}
//    				} catch (SQLException e) {
//    					e.printStackTrace();
//    				}
//    			}
//
//        		
//
//        		if (list1 != null && list1.size() > 0&&list2 != null && list2.size() > 0&&list3 != null && list3.size() > 0&&list4 != null && list4.size() > 0) {// 如果list中存入了数据，转化为数组
//        			String[] arr2 = new String[list2.size()];// 创建一个和list长度一样的数组
//        			String[] arr3= new String[list3.size()];
//        			int[] arr1=new int[list1.size()];
//        			int[] arr4=new int[list4.size()];
//        			for (int i = 0; i < list1.size(); i++) {
//        				arr2[i] = list2.get(i);// 数组赋值了。
//        				arr1[i] = Integer.parseInt(list1.get(i).toString());
//        				arr3[i] = list3.get(i);// 数组赋值了。
//        				arr4[i] = Integer.parseInt(list4.get(i).toString());
//        							
//        			}
//        		
//        			for (int i = 0; i < arr1.length; i++) {
//        				
//        				if(arr2[i].equals((String) jc1.getSelectedItem())&&arr3[i].equals((String) jc2.getSelectedItem()))
//        					{
//        					System.out.println("h");
//        					jt1.setText("请乘坐         "+String.valueOf(arr1[i])+"      号线路"+
//        					",共需         "+String.valueOf(arr4[i])+"      站路") ;	
//        					
//        					}
//  
//        			}
//        			
//        		}
//        		
//        	}
//      
//        public void Testbus_search_two_line(){
//        	try {
//				Class.forName("com.mysql.jdbc.Driver");
//				conn = DriverManager
//						.getConnection("jdbc:mysql://localhost/mydata?"
//								+ "user=root&password=root");
//				stmt2 = conn.createStatement();
//
//        		rs2 = stmt2.executeQuery("SELECT x.`乘坐路线`as 起始公交,x.`起点`as 出发站, x.`终点`as 中转站,x.`票价`,x.`站点数`,"
//        				+ "y.`乘坐路线`as 换乘公交,y.`终点`as 终点站,y.`票价`,y.`站点数`,	"
//        				+ "(x.`站点数`+y.`站点数`)as 总站数,(x.`票价`+y.`票价`)as 总票价"
//        				+ " FROM `bustest` x,`bustest` y "
//        				+ "where x.起点='"+(String) jc1.getSelectedItem()+"'"
//        						+ "and x.终点=y.起点 "
//        						+ "and y.终点='"+(String) jc2.getSelectedItem()+"'"
//        								+ "and x.`乘坐路线`!=y.`乘坐路线`"
//										);
//        		//下面是最短最便宜的算法；
//        		//rs2 = stmt2.executeQuery("SELECT *,(x.`站点数`+y.`站点数`)as su  FROM `bustest` x,`bustest` y"
////						+ " where x.起点='"+(String) jc1.getSelectedItem()+"'"
////								+ "and x.终点=y.起点 and y.终点='"+(String) jc2.getSelectedItem()+"' "
////										+ "and (x.`站点数`+y.`站点数`)<=all(SELECT (x.`站点数`+y.`站点数`)  as su FROM `bustest` x,`bustest` y where x.起点='"+(String) jc1.getSelectedItem()+"'and x.终点=y.起点 and y.终点='"+(String) jc2.getSelectedItem()+"')");
//				while(rs2.next())
//				{
//					
//					System.out.println(rs2.getString(1)+" "+
//							        rs2.getString(2)+" "+
//									rs2.getString(3)+" "+
//									rs2.getString(4)+" "+
//									rs2.getString(5)+" "+
//									rs2.getString(6)+" "+
//									rs2.getString(7)+" "+
//									rs2.getString(8)+" "+
//									rs2.getString(9)+" "+
//									rs2.getString(10)+" "+
//									rs2.getString(11));
//					
////					jt1.setText(rs2.getString("乘坐路线1"));
////					jt1.setText(rs2.getString(2));
////					jt1.setText(rs2.getString(3));
////					jt1.setText(rs2.getString(4));
////					jt1.setText(rs2.getString(5));
////					jt1.setText(rs2.getString(6));
////					jt1.setText(rs2.getString(7));
////					jt1.setText(rs2.getString(8));
////					jt1.setText(rs2.getString(9));
////					jt1.setText(rs2.getString(10));
////					jt1.setText(rs2.getString(11));
//					
//				}
//			
//			}	
//				catch (ClassNotFoundException e) {
//				e.printStackTrace();
//			} catch (SQLException ex) {
//				System.out.println("SQLException: " + ex.getMessage());
//				System.out.println("SQLState: " + ex.getSQLState());
//				System.out.println("VendorError: " + ex.getErrorCode());
//			} finally {
//				try {
//					if (rs2 != null) {
//						rs2.close();
//						rs2 = null;
//					}
//					if (stmt2 != null) {
//						stmt2.close();
//						stmt2 = null;
//					}
//					if (conn != null) {
//						conn.close();
//						conn = null;
//					}
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//
//        }
//        public void Testbus_search_three_line(){
//        	try {
//				Class.forName("com.mysql.jdbc.Driver");
//				conn = DriverManager
//						.getConnection("jdbc:mysql://localhost/mydata?"
//								+ "user=root&password=root");
//				stmt2 = conn.createStatement();
//			
//				rs2 = stmt2.executeQuery("SELECT * FROM `bustest` x,`bustest` y,`bustest` z"
//						+ " where x.起点='"+(String) jc1.getSelectedItem()+"'"
//								+ "and x.终点=y.起点 "
//								+ "and y.终点=z.起点"
//								+ " and z.终点='"+(String) jc1.getSelectedItem()+"';");
//				while(rs2.next())
//				{
//					System.out.println(rs2.getString(1)+" "+
//							        rs2.getString(2)+" "+
//									rs2.getString(3)+" "+
//									rs2.getString(4)+" "+
//									rs2.getString(5)+" "+
//									rs2.getString(6)+" "+
//									rs2.getString(7)+" "+
//									rs2.getString(8)+" "+
//									rs2.getString(9)+" "+
//									rs2.getString(10)+" "+
//									rs2.getString(11)+" "+
//									rs2.getString(12));
//				}
//			
//			}	
//				catch (ClassNotFoundException e) {
//				e.printStackTrace();
//			} catch (SQLException ex) {
//				System.out.println("SQLException: " + ex.getMessage());
//				System.out.println("SQLState: " + ex.getSQLState());
//				System.out.println("VendorError: " + ex.getErrorCode());
//			} finally {
//				try {
//					if (rs2 != null) {
//						rs2.close();
//						rs2 = null;
//					}
//					if (stmt2 != null) {
//						stmt2.close();
//						stmt2 = null;
//					}
//					if (conn != null) {
//						conn.close();
//						conn = null;
//					}
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//        }}}


	
}}
