

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import 实验.logframe;
import 实验.zuce_again_frame;
import 实验.zuce_succes_frame;
public class zucepanel extends JPanel {
	private String name,account;
	private  int code;
	private JButton b1,b2,b3;
	private JTextField t1, t2, t3;
	private JLabel jl1,jl2,jl3;
	private Connection conn =null;
	private Statement stmt =null;
	private  ResultSet rs =null;
	private boolean isOldCustomer=false;
	public zucepanel(){
		setLayout(null);
		
		b1=new JButton("注册");
		b2=new JButton("返回");
		b3=new JButton("退出");
		
		b1.setBounds(16, 237, 90,28);
		b2.setBounds(130, 237, 90,28);
		b3.setBounds(244, 237, 90,28);
		
		t1=new JTextField(5);
		t2=new JTextField(5);
		t3=new JTextField(5);
		
		t1.setBounds(149, 68,138,30);
		t2.setBounds(149, 118,138,30);
		t3.setBounds(149, 173,138,30);
		
		jl1=new JLabel("姓名");
		jl2=new JLabel("账号(必须唯一)");
		jl3=new JLabel("密码");
		
		jl1.setBounds(10, 68, 73,35);
		jl2.setBounds(10, 114, 73,35);
		jl3.setBounds(10, 175, 73,35);
		
		b1.addActionListener(new ButtonListener());
		b2.addActionListener(new ButtonListener());
		b3.addActionListener(new ButtonListener());
		
		
		add(b1);add(b2);add(b3);
		add(t1);add(t2);add(t3);
		add(jl1);add(jl2);add(jl3);
		
		setPreferredSize(new Dimension(400, 300));
	}
	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
//			if(e.getSource()==b2)
//				System.exit(0);
//			if(e.getSource()==b1)
//				new welcome();
			
			
			if(e.getSource()==b1)
			{	name=t1.getText();
			    account=t2.getText();
			    code=Integer.parseInt(t3.getText());
			    TestMysqlConnect();
			}
			if(e.getSource()==b2)
				new logframe();		    		    
		    if(e.getSource()==b3)
		   {
		    System.exit(0);
		  }
	 
	}
	public void TestMysqlConnect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/mydata?"
					+ "user=root&password=root");
			stmt = conn.createStatement();
			//stmt.executeUpdate("insert into shiyan values('"+s1+"')");
			//这是从控制台直接存入数据库string类型用（'"+s1+"'），int类型用"+s1+"
		
			String sql="INSERT INTO customer " +
                   "VALUES ('"+name+"','"+account+"',"+code+")";
	      	stmt.executeUpdate(sql);
			rs = stmt.executeQuery("select * from  customer");
			
			
				
			if(!isOld())
				new zuce_succes_frame();
//			while (rs.next()) {
//			System.out.println(rs.getString("名字"));
//			
//			}
			
			System.out.println(isOld());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException ex) {
			//
			new zuce_again_frame();
			System.out.println("hehi");//逼不得已才将方法放在此处，以后回来修改；
			
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
	
	
	
	public boolean isOld() {
		  try {
			if(rs.next())
			  {
				  if(rs.getString(2).equals(name))
				  {  
					  isOldCustomer=true;
					  
				  }   else
					  isOldCustomer=false;
			  }
		} catch (SQLException e) {
			 
			e.printStackTrace();
		}
	return isOldCustomer;
 }
}


}
