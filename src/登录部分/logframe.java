package ��¼����;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
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
	// stmt.executeUpdate("insert into shiyan values('"+s1+"')");
	// ���Ǵӿ���ֱ̨�Ӵ������ݿ�string�����ã�'"+s1+"'����int������"+s1+"
	// String sql="INSERT INTO customer " +
	// "VALUES ('"+name+"','"+account+"',"+code+")";
	// stmt.executeUpdate(sql);
	// while (rs.next()) {
	// System.out.println(rs.getString("����"));
	//
	// }
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
		private JTextField jt1;
		private JPasswordField jt2;//ʹ����Ӱ�أ���
		private JLabel jl1, jl2, jl3;
		private JPanel jp1, jp2;
		private Connection conn = null;
		private Statement stmt = null;
		private ResultSet rs = null;
		private String account;
		private int code;
		private int count=0;//�����ж��Ƿ������д���������
		private JLabel image_label;//ͼƬ
		public panel() {
			setLayout(null);
			setOpaque(false); // ����Ϊ͸��������
			b1 = new JButton("��½");
			b2 = new JButton("ע��");
			b3 = new JButton("�˳�");

			b1.setBounds(13, 203, 81, 41);
			b2.setBounds(123, 203, 81, 41);
			b3.setBounds(263, 203, 81, 41);

			b1.addActionListener(new ButtonListener());
			b2.addActionListener(new ButtonListener());
			b3.addActionListener(new ButtonListener());

			jt1 = new JTextField(10);
			jt2 = new JPasswordField(10);

			jt1.setBounds(125, 42, 140, 41);
			jt2.setBounds(125, 111, 140, 41);
	
	        
			jl1 = new JLabel("��                     ӭ                     ʹ                     ��                     ��                     ��");
			jl2 = new JLabel("�˺�");
			jl3 = new JLabel("����");

			jl1.setBounds(0, 0, 400, 35);
			jl2.setBounds(13, 41, 64, 29);
			jl3.setBounds(13, 111, 64, 29);

			
			image_label=new JLabel();
			image_label.setIcon(new change_image_size ("C:\\Users\\18580_000\\Downloads\\delete_image.jpg",400, 300).getImageIcon());
			image_label.setBounds(0, 0, 400, 300);;
			
			
			add(b1);
			add(b2);
			add(b3);
			add(jt1);
			add(jt2);
			add(jl1);
			add(jl2);
			add(jl3);
			add(image_label);
			setPreferredSize(new Dimension(400, 300));
		}
		
	private class ButtonListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {

				if (e.getSource() == b1) {
					account = jt1.getText();
					code = Integer.parseInt(jt2.getText());
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
			
				rs = stmt.executeQuery("select * from  customer");
				log_succes_or_again();
			
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

	
public void log_succes_or_again(){
	ArrayList<String> list1 = new ArrayList<String>();// ����ȡ������б�֮����ʹ���б��������飬��Ϊ���ڻ���֪������ж��٣�����ȷ�����鳤�ȣ���������list���գ�Ȼ��תΪ����
	//ArrayList<int[]> list2 = new ArrayList<int[]>();
	Vector<Integer> list2 = new Vector<Integer>();
	try {
		while (rs.next()) {// ��������ݣ�ȡ�ڶ��������list
			list1.add(rs.getString(2));
			list2.add(rs.getInt(3));
			//System.out.println("haha");
			//System.out.println(rs.getString(2));
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	

	if (list1 != null && list1.size() > 0&&list2 != null && list2.size() > 0) {// ���list�д��������ݣ�ת��Ϊ����
		String[] arr1 = new String[list1.size()];// ����һ����list����һ��������
		int[] arr2=new int[list2.size()];
		for (int i = 0; i < list1.size(); i++) {
			arr1[i] = list1.get(i);// ���鸳ֵ�ˡ�
			
		}
		for (int i = 0; i < list2.size(); i++){
			arr2[i] = Integer.parseInt(list2.get(i).toString());
			
		}
	
		for (int i = 0; i < arr1.length; i++) {
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
}
}