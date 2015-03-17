package 实验;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.*;

public class logframe {
	JFrame logframe;

	public logframe() {
		logframe = new JFrame("he frame");
		logframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int width = 500;
		int height = 500;
		logframe.setBounds((d.width - width) / 2, (d.height - height) / 2,
				width, height);
		panel p = new panel();

		logframe.getContentPane().add(p);
		logframe.pack();
		logframe.setVisible(true);
	}

	class panel extends JPanel {
		private JButton b1, b2, b3;
		private JTextField t1, t2, t3;
		private JLabel jl1, jl2, jl3;
		private JPanel jp1, jp2;
		private Connection conn = null;
		private Statement stmt = null;
		private ResultSet rs = null;
		private String account;
		private int code;
		private int count=0;//用于判断是否输入有错！！！！！

		public panel() {
			setLayout(null);
			b1 = new JButton("登陆");
			b2 = new JButton("注册");
			b3 = new JButton("退出");

			b1.setBounds(13, 203, 81, 41);
			b2.setBounds(123, 203, 81, 41);
			b3.setBounds(263, 203, 81, 41);

			b1.addActionListener(new ButtonListener());
			b2.addActionListener(new ButtonListener());
			b3.addActionListener(new ButtonListener());

			t1 = new JTextField(5);
			t2 = new JTextField(5);

			t1.setBounds(125, 42, 140, 41);
			t2.setBounds(125, 111, 140, 41);

			jl1 = new JLabel("欢迎");
			jl2 = new JLabel("账号");
			jl3 = new JLabel("密码");

			jl1.setBounds(0, 0, 400, 35);
			jl2.setBounds(13, 41, 64, 29);
			jl3.setBounds(13, 111, 64, 29);

			add(b1);
			add(b2);
			add(b3);
			add(t1);
			add(t2);
			add(jl1);
			add(jl2);
			add(jl3);

			setPreferredSize(new Dimension(400, 300));
		}

		private class ButtonListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {

				if (e.getSource() == b1) {
					account = t1.getText();
					code = Integer.parseInt(t2.getText());
					TestMysqlConnect();
					logframe.dispose();
				}
				if (e.getSource() == b2)
					new zuceframe();
				logframe.dispose();
				if (e.getSource() == b3)
					System.exit(0);
			}

		}

		public void TestMysqlConnect() {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager
						.getConnection("jdbc:mysql://localhost/mydata?"
								+ "user=root&password=root");
				stmt = conn.createStatement();
				// stmt.executeUpdate("insert into shiyan values('"+s1+"')");
				// 这是从控制台直接存入数据库string类型用（'"+s1+"'），int类型用"+s1+"
				// String sql="INSERT INTO customer " +
				// "VALUES ('"+name+"','"+account+"',"+code+")";
				// stmt.executeUpdate(sql);
				// while (rs.next()) {
				// System.out.println(rs.getString("名字"));
				//
				// }
				rs = stmt.executeQuery("select * from  customer");
				//System.out.println(rs.getString(2));
				ArrayList<String> list1 = new ArrayList<String>();// 创建取结果的列表，之所以使用列表，不用数组，因为现在还不知道结果有多少，不能确定数组长度，所有先用list接收，然后转为数组
				//ArrayList<int[]> list2 = new ArrayList<int[]>();
				Vector<Integer> list2 = new Vector<Integer>();
				//System.out.println("1");
				while (rs.next()) {// 如果有数据，取第二列添加如list
					list1.add(rs.getString(2));
					list2.add(rs.getInt(3));
					//System.out.println("haha");
					//System.out.println(rs.getString(2));
				}
				
			
				if (list1 != null && list1.size() > 0&&list2 != null && list2.size() > 0) {// 如果list中存入了数据，转化为数组
					String[] arr1 = new String[list1.size()];// 创建一个和list长度一样的数组
					int[] arr2=new int[list2.size()];
					for (int i = 0; i < list1.size(); i++) {
						arr1[i] = list1.get(i);// 数组赋值了。
						
					}
					for (int i = 0; i < list2.size(); i++){
						arr2[i] = Integer.parseInt(list2.get(i).toString());
						//System.out.println(arr2[i]);
					}
					
					// 输出数组
					for (int i = 0; i < arr1.length; i++) {
						//System.out.println(arr1[i]);
						count++;
						if(arr1[i].equals(account)&&arr2[i]==code)
							{new log_succes_frame();
						    count--;
							}
						if(count==arr1.length)
							new log_again_frame();
					}
					
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

	}

}
