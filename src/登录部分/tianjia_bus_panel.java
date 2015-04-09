package ��¼����;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class tianjia_bus_panel extends JPanel {
	private JButton b1, b2, b3, b4;
	private JRadioButton jrb1, jrb2, jrb3, jrb4, jrb5, jrb6, jrb7, jrb8, jrb9, jrb10, jrb11;
	private JTextField jt1, jt2, jt3, jt4, jt5, jt6, jt7, jt8, jt9;
	private JTextArea ja1, ja2, ja3;
	private JLabel jl1, jl2, jl3, jl4, jl5, jl6, jl7;
 
	private Connection conn = null;
	private Statement stmt = null;
	private ResultSet rs = null;
  
	public tianjia_bus_panel() {
		setLayout(null);
		jl1 = new JLabel(
				"       ����                              Ʊ��                                 IC��                             ѧ����                               ���꿨");
		jl1.setBounds(0, 1, 600, 15);

		jt1 = new JTextField(10);
		jt2 = new JTextField(10);
		jt3 = new JTextField(10);
		jt4 = new JTextField(10);
		jt5 = new JTextField(10);

		jt1.setBounds(10, 17, 50, 30);
		jt2.setBounds(125, 17, 50, 30);
		jt3.setBounds(250, 17, 50, 30);
		jt4.setBounds(367, 17, 50, 30);
		jt5.setBounds(500, 17, 50, 30);

		jl2 = new JLabel("������������ʱ��");
		jl2.setBounds(10, 80, 150, 15);
		jt6 = new JTextField(10);
		jt6.setBounds(120, 80, 50, 30);
		jl3 = new JLabel("�ճ�ʱ��");
		jl3.setBounds(180, 80, 100, 15);
		
		jt7 = new JTextField(10);
		jt7.setBounds(250, 80, 50, 30);

		jl4 = new JLabel("������������ʱ��");
		jl4.setBounds(10, 120, 150, 15);
		jt8 = new JTextField(10);
		jt8.setBounds(120, 120, 50, 30);
		jl5 = new JLabel("�ճ�ʱ��");
		jl5.setBounds(180, 120, 100, 15);
		
		jt9 = new JTextField(10);
		jt9.setBounds(250, 120, 50, 30);

		b1 = new JButton("�ύ");
		b2 = new JButton("�ָ�");
		b3 = new JButton("����");
		b4 = new JButton("�˳�");

		b1.setBounds(20, 500, 85, 40);
		b2.setBounds(140, 500, 85, 40);
		b3.setBounds(260, 500, 85, 40);
		b4.setBounds(380, 500, 85, 40);

		b1.addActionListener(new ButtonListener());
		b2.addActionListener(new ButtonListener());
		b3.addActionListener(new ButtonListener());
		b4.addActionListener(new ButtonListener());

		ja1 = new JTextArea(
				"��ʾ��һ��������������Ӣ�ģ����ô�д������IC����ѧ���������꿨���ã�1��ʾ���ã�0��ʾ�����ã�"
						+ "�������ճ���ʹ��'6:10'�ĸ�ʽ���ģ���дվ��ʱ����ͬ��վ��֮���á���������;�壬���O���Կ�����ն�Ӧ��");
		ja1.setBounds(320, 70, 260, 100);
		ja1.setLineWrap(true);// �����Զ����У�
		ja1.setEditable(false);//���е�ֵ���ɸ�
		ja1.setBorder (BorderFactory.createLineBorder(Color.gray,1));
		
		ja2 = new JTextArea();
		ja2.setBounds(50, 180, 500, 130);
		ja2.setLineWrap(true);// �����Զ����У�
		ja2.setBorder (BorderFactory.createLineBorder(Color.gray,1));
		
		ja3 = new JTextArea();
		ja3.setBounds(50, 340, 500, 130);
		ja3.setLineWrap(true);// �����Զ����У�
		ja3.setBorder (BorderFactory.createLineBorder(Color.gray,1));
		
		jl6 = new JLabel("������");
		jl6.setBounds(10, 180, 80, 100);

		jl7 = new JLabel("������");
		jl7.setBounds(10, 340, 80, 100);

		jrb1=new JRadioButton("");
		jrb1.setBounds(60, 23, 16, 16);
		jrb2=new JRadioButton("");
		jrb2.setBounds(175, 23, 16, 16);
		jrb3=new JRadioButton("");
		jrb3.setBounds(298, 23, 16, 16);
		jrb4=new JRadioButton("");
		jrb4.setBounds(416, 23, 16, 16);
		jrb5=new JRadioButton("");
		jrb5.setBounds(550, 23, 16, 16);
		jrb6=new JRadioButton("");
		jrb6.setBounds(170, 95, 16, 16);
		jrb7=new JRadioButton("");
		jrb7.setBounds(300, 95, 16, 16);
		jrb8=new JRadioButton("");
		jrb8.setBounds(170, 132, 16, 16);
		jrb9=new JRadioButton("");
		jrb9.setBounds(300,132, 16, 16);
		jrb10=new JRadioButton("");
		jrb10.setBounds(20, 290, 16, 16);
		jrb11=new JRadioButton("");
		jrb11.setBounds(20, 450, 16, 16);
		
		jrb1.addActionListener(new RadioButtonListener());
		jrb2.addActionListener(new RadioButtonListener());
		jrb3.addActionListener(new RadioButtonListener());
		jrb4.addActionListener(new RadioButtonListener());
		jrb5.addActionListener(new RadioButtonListener());
		jrb6.addActionListener(new RadioButtonListener());
		jrb7.addActionListener(new RadioButtonListener());
		jrb8.addActionListener(new RadioButtonListener());
		jrb9.addActionListener(new RadioButtonListener());
		jrb10.addActionListener(new RadioButtonListener());
		jrb11.addActionListener(new RadioButtonListener());
		add(jrb1);add(jrb2);add(jrb3);add(jrb4);add(jrb5);
		add(jrb6);add(jrb7);add(jrb8);add(jrb9);add(jrb10);add(jrb11);
		
		add(jl1);add(jl2);add(jl3);add(jl4);add(jl5);add(jl6);add(jl7);
		
		add(jt1);add(jt2);add(jt3);add(jt4);add(jt5);add(jt6);add(jt7);add(jt8);add(jt9);
		
		add(b1);add(b2);add(b3);add(b4);

		add(ja1);add(ja2);add(ja3);
		
		setBounds(0, 0, 600, 600);
	}
	private class RadioButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
            if(e.getSource()==jrb1)
            	jt1.setText("");
            if(e.getSource()==jrb2)
            	jt2.setText("");
            if(e.getSource()==jrb3)
            	jt3.setText("");
            if(e.getSource()==jrb4)
            	jt4.setText("");
            if(e.getSource()==jrb5)
            	jt5.setText("");
            if(e.getSource()==jrb6)
            	jt6.setText("");
            if(e.getSource()==jrb7)
            	jt7.setText("");
            if(e.getSource()==jrb8)
            	jt8.setText("");
            if(e.getSource()==jrb9)
            	jt9.setText("");
            if(e.getSource()==jrb10)
            	ja2.setText("");
            if(e.getSource()==jrb11)
            	ja3.setText("");
            	
			
		}
		
	}
	private class ButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == b1) {
				checi_beifen();
				new insertTxtFile(ja2.getText(), ja2);
				new insertTxtFile(ja3.getText(), ja3);
			}
			if (e.getSource() == b2) {
				new recover_frame();
			}
			if (e.getSource() == b3) {
				
			}
			if (e.getSource() == b4) {
				System.exit(0);
			}

		}
	}
	private  void checi_beifen(){
		try {
			String time=null;//������ʾ��ǰʱ�䣻
			time = new time_xianshi(time).time();
			
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager
					.getConnection("jdbc:mysql://localhost/mydata?"
							+ "user=root&password=root");
			stmt = conn.createStatement();
			String beifen = "INSERT INTO ����еĳ��μ�¼ " + "VALUES ('"+jt1.getText() +"','"+time +"')";
			stmt.executeUpdate(beifen);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Exception e) {
			System.out.println("��ȡ�ļ����ݳ���");
			e.printStackTrace();
		}
	}
public class insertTxtFile {
	public insertTxtFile(String st, JTextArea jt) {
		BufferedWriter bfw;
		String[] names;
		try {
			// bfw = new BufferedWriter(new
			// FileWriter("C://Users//18580_000//Desktop//Student.txt",true));
			bfw = new BufferedWriter(new FileWriter(
					"C://Users//18580_000//Desktop//����ʵ��.txt"));
			// ��true��Ϊ�˲�����ԭ����ֵ��
			// bfw.newLine() ; //д��һ�����з�
			// string value = "192.168.128.33";
			 names = st.split("\\��"); // �ָ��ַ������еġ���������Ϊ����״̬�µģ�������;�м�
			for (int i = 0; i < names.length; i++) {
				bfw.write(names[i]); // д��
				bfw.newLine();
			}
			bfw.flush();
			bfw.close();
			if (jt == ja2)
				new readTxtFile("C://Users//18580_000//Desktop//����ʵ��.txt",
						0);
			if (jt == ja3)
				new readTxtFile("C://Users//18580_000//Desktop//����ʵ��.txt",
						1);
		} catch (IOException e) {
		
			e.printStackTrace();
		}

	}
}

public class readTxtFile {
	public readTxtFile(String filePath, int fangxiang) {
		try {
			// fangxiang����������������������0��ʾ��������1��ʾ������
			// filePath="C://Users//18580_000//Desktop//Student.txt";
			//biaoji=jt1.getText();//Ϊ�ָ������׼��
			
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager
					.getConnection("jdbc:mysql://localhost/mydata?"
							+ "user=root&password=root");
			stmt = conn.createStatement();
			//String sql = "INSERT INTO ����ʵ�� " + "VALUES ('"jt1.getText() +'")"; 
			//String beifen = "INSERT INTO ����еĳ��μ�¼ " + "VALUES ('"+jt1.getText() +"')";
			String encoding = "GBK"; 
			File file = new File(filePath);// filePath =
											// "C://Users//18580_000//Desktop//Student.txt";
			if (file.isFile() && file.exists()) { // �ж��ļ��Ƿ����
				InputStreamReader read = new InputStreamReader(
						new FileInputStream(file), encoding);// ���ǵ������ʽ
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt = null;
				int count = 1;
				
				if (fangxiang == 0) {
					while ((lineTxt = bufferedReader.readLine()) != null) {
						String sql = "INSERT INTO ����ʵ�� " + "VALUES ('"
								+ jt1.getText() + "'," + "'" + lineTxt
								+ "'," + "" + count + "," + "" + fangxiang
								+ "," + "'" + jt6.getText() + "'," + "'"
								+ jt7.getText() + "'," + "'"
								+ jt2.getText() + "',"+Integer.parseInt(jt3.getText())+","+Integer.parseInt(jt4.getText())+","+Integer.parseInt(jt5.getText())+")";
						stmt.executeUpdate(sql);
						count++;
						System.out.println(lineTxt);
					}
					count = 1;
				}
				if (fangxiang == 1) {
					while ((lineTxt = bufferedReader.readLine()) != null) {
						String sql = "INSERT INTO ����ʵ�� " + "VALUES ('"
								+ jt1.getText() + "'," + "'" + lineTxt
								+ "'," + "" + count + "," + "" + fangxiang
								+ "," + "'" + jt6.getText() + "'," + "'"
								+ jt7.getText() + "'," + "'"
								+ jt2.getText() + "',"+Integer.parseInt(jt3.getText())+","+Integer.parseInt(jt4.getText())+","+Integer.parseInt(jt5.getText())+")";
						stmt.executeUpdate(sql);
						count++;
						System.out.println(lineTxt);
					}
					count = 1;
				}
				read.close();
			} else {
				System.out.println("�Ҳ���ָ�����ļ�");
			}
		} catch (Exception e) {
			System.out.println("��ȡ�ļ����ݳ���");
			e.printStackTrace();
		}
	}
}

private class recover_frame {
	private JFrame jframe;
	public recover_frame(){
		jframe = new JFrame();
		jframe.setLayout(null);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int width = 600;
		int height = 600;
		jframe.setBounds((d.width - width) / 2, (d.height - height) / 2, width,
				height);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		recover_panel re=new recover_panel();
		
		re.setBounds(300, 0, 300, 300);
		
		show_checi show=new show_checi();
		show.setBounds(0, 0, 300, 300);
		jframe.getContentPane().add(re);
		jframe.getContentPane().add(show);
		
		jframe.pack();
		jframe.setSize(600,300);
		jframe.setVisible(true);
	}
	private class recover_panel extends JPanel {
		private JLabel jl;
		private JTextField jt;
		private JButton jb1,jb2;
		public recover_panel(){
			setLayout(null);
			jl=new JLabel("  ��     ɾ      ��     ��    �� :");
			jl.setBounds(0,0, 200, 30);
			
			jt=new JTextField(10);
			jt.setBounds(150, 8,120, 20);
			
			jb1=new JButton("ȷ��");
			jb2=new JButton("����");
			
			jb1.setBounds(10, 60, 80, 30);
			jb2.setBounds(180, 60, 80, 30);
			
			jb1.addActionListener(new ButtonListener());
			jb2.addActionListener(new ButtonListener());
			add(jl);
			add(jt);
			add(jb1);
			add(jb2);
		}
		private void recover(){
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost/mydata?"
									+ "user=root&password=root");
				stmt = conn.createStatement();
				String sql = "delete FROM `����ʵ��`where ����='"+jt.getText()+"'";
				stmt.executeUpdate(sql);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		private class ButtonListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==jb1)
					recover();//ɾ��֮ǰ��ӵ�·�ߣ�
				if(e.getSource()==jb2)
					jframe.dispose();
				    
			}
			
		}
		
	}
	
	class show_checi extends JScrollPane{
		private JTableHeader jth;
		private JTable tabDemo;
		private DefaultTableModel tableModel;
		public show_checi(){
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = DriverManager
						.getConnection("jdbc:mysql://localhost/mydata?"
								+ "user=root&password=root");

				String sql = "SELECT ����,ʱ��  FROM `����еĳ��μ�¼";
				PreparedStatement pstm1 = conn.prepareStatement(sql);
				ResultSet rs = pstm1.executeQuery();
				int count = 0;
				while (rs.next()) {
					count++;
				}
				rs = pstm1.executeQuery();
				// ����ѯ��õļ�¼���ݣ�ת�����ʺ�����JTable��������ʽ
				Object[][] info = new Object[count][2];
				count = 0;

				while (rs.next()) {

					info[count][0] = rs.getString("����");
					info[count][1] = rs.getString("ʱ��");
					count++;
				}
				// �����ͷ
				String[] title = { "�����ӳ�����Ϣ","���ʱ��"};
				// ����JTable
				tabDemo = new JTable(info, title) {
					public boolean isCellEditable(int row, int column) {
						return false;
					}
				};
				tabDemo.getTableHeader().setReorderingAllowed(false);
				tabDemo.getTableHeader().setResizingAllowed(false);

				this.jth = this.tabDemo.getTableHeader();
				this.getViewport().add(tabDemo);
			} 
			catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}}


}
