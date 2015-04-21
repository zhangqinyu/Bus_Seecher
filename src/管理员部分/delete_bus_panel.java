package ����Ա����;

import javax.swing.*;

import java.awt.*;
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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class delete_bus_panel extends JPanel {
	private JRadioButton jr1, jr2, jr3,jr4;
	private JLabel jl1, jl2, jl3, jl4,jl5,jl6,jl7,jl8;
	private JTextField jt1, jt2, jt3, jt4, jt5, jt6, jt7, jt8, jt9;
	private JTextField jt10, jt11, jt12, jt13,jt14,jt15,jt16,jt17;

	private JTextArea ja1, ja2, ja3;
	private JButton jb1, jb2, jb3, jb4, jb5, jb6,jb7;
	private int count = 0;// �����ж������Щ���֣�

	private Connection conn = null;
	private Statement stmt = null;
	private ResultSet rs = null;

	private JLabel image_label;//ͼƬ
	private ImageIcon image1;
	public delete_bus_panel() {
		setLayout(null);
		//setOpaque(false); //����Ϊ͸��������
		jr1 = new JRadioButton("ɾ������", true);
		jr1.setBounds(0, 0, 100, 50);
		jr2 = new JRadioButton("ɾ��վ��");
		jr2.setBounds(0, 40, 100, 50);
		jr3 = new JRadioButton("�޸���Ϣ");
		jr3.setBounds(0, 80, 100, 50);
		jr4=new JRadioButton("���վ��");
		jr4.setBounds(120, 0, 100, 50);

		jr1.addActionListener(new RadioButtonListener());
		jr2.addActionListener(new RadioButtonListener());
		jr3.addActionListener(new RadioButtonListener());
		jr4.addActionListener(new RadioButtonListener());
     
		image_label=new JLabel();
		image_label.setIcon(getImageIcon("C:\\Users\\18580_000\\Downloads\\delete_image.jpg",120, 130));
		image_label.setBounds(450, 0, 120, 130);;
		add(image_label);
		
		ButtonGroup group = new ButtonGroup();
		group.add(jr1);
		group.add(jr2);
		group.add(jr3);// �����Ŀ����Ϊ��ֻ��ѡһ����
		group.add(jr4);
		add(jr1);
		add(jr2);
		add(jr3);
		add(jr4);
		setBounds(0, 0, 600, 600);
	}
	 private ImageIcon getImageIcon(String path, int width, int height) {
   	  if (width == 0 || height == 0) {
   	   return new ImageIcon(this.getClass().getResource(path));
   	  }
   	  ImageIcon icon = new ImageIcon(path);
   	  icon.setImage(icon.getImage().getScaledInstance(width, height,
   	    Image.SCALE_DEFAULT));
   	  return icon;
   	 }
	private void delete_zujian(int count) {

		switch (count) {
		case 1:
			remove(jl1);
			remove(jt1);
			remove(jb1);
			break;
		case 2:
			remove(jl1);
			remove(jl2);
			remove(jl3);
			remove(jl4);
			remove(jl5);
			remove(jl6);
			remove(jt1);
			remove(jt2);
			remove(jt3);
			remove(jt4);
			remove(ja1);
			remove(ja2);
			remove(jb2);
			remove(jb4);
			break;
		case 3:
			remove(jl1);
			remove(jl2);
			remove(jl3);
			remove(jl4);
			remove(jl5);
			remove(jl6);
			remove(jl7);
			remove(jl8);
			remove(jt1);
			remove(jt2);
			remove(jt3);
			remove(jt4);
			remove(jt5);
			remove(jt6);
			remove(jt7);
			remove(jt8);
			remove(jt9);
			remove(jt10);
			remove(jt11);
			remove(jt12);
			remove(jt13);
			remove(jt14);
			remove(jt15);
			remove(jt16);
		    remove(jt17);
			
			remove(jb3);
			remove(jb5);
			break;
		case 4:
			remove(jl1);
			remove(jl2);
			remove(jl3);
			remove(jl4);
			remove(jl5);
			remove(jl6);
			remove(jl7);
			remove(jt1);
			remove(jt2);
			remove(jt3);
			remove(jt4);
			remove(jt5);
			remove(ja1);
			remove(ja2);
			remove(jb6);
			remove(jb7);
			break;
		default:
			System.out.println("no");
			break;
		}
	}

	private void delete_checi_panel() {

		jl1 = new JLabel("��������ɾ���ĳ��κţ�");
		jl1.setBounds(10, 130, 150, 30);
		jt1 = new JTextField();
		jt1.setBounds(150, 135, 100, 20);
		jb1 = new JButton("ȷ��");
		jb1.setBounds(260, 130, 60, 30);
		jb1.addActionListener(new ButtonListener());
		add(jl1);
		add(jt1);
		add(jb1);
		this.repaint();
	}

	private void delete_checi() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/mydata?"
					+ "user=root&password=root");
			stmt = conn.createStatement();
			String sql = "delete from ����ʵ�� where ����='" + jt1.getText() + "'";
			stmt.executeUpdate(sql);
			// rs = stmt.executeQuery("select * from  customer ");
		} catch (ClassNotFoundException e) {
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

	private void delete_zhandian_panel() {

		jl1 = new JLabel("��������ɾ����վ��ĳ��κţ�");
		jl1.setBounds(10, 130, 190, 30);
		jt1 = new JTextField();
		jt1.setBounds(190, 135, 130, 20);

		jb2 = new JButton("��ʾ");
		jb2.setBounds(350, 125, 60, 30);
		jb2.addActionListener(new ButtonListener());

		jb4 = new JButton("ȷ��");
		jb4.setBounds(350, 190, 60, 30);
		jb4.addActionListener(new ButtonListener());

		jl2 = new JLabel("��������ɾ����վ�㣺");
		jl2.setBounds(10, 160, 190, 30);
		jt2 = new JTextField();
		jt2.setBounds(190, 165, 130, 20);
		
		jl3 = new JLabel("����");
		jl3.setBounds(350, 160, 190, 30);
		jt3 = new JTextField();
		jt3.setBounds(390, 165, 50, 20);
		
		jl4 = new JLabel("���������һվ��");
		jl4.setBounds(10, 190, 190, 30);
		jt4 = new JTextField();
		jt4.setBounds(190, 195, 130, 20);
		

		ja1 = new JTextArea();
		ja1.setBounds(50, 240, 500, 130);
		ja1.setLineWrap(true);// �����Զ����У�
		ja1.setEditable(false);
		ja1.setBorder (BorderFactory.createLineBorder(Color.gray,1));
		
		ja2 = new JTextArea();
		ja2.setBounds(50, 400, 500, 130);
		ja2.setLineWrap(true);// �����Զ����У�
		ja2.setEditable(false);
		ja2.setBorder (BorderFactory.createLineBorder(Color.gray,1));
		
		jl5 = new JLabel("������");
		jl5.setBounds(10, 220, 80, 100);

		jl6 = new JLabel("������");
		jl6.setBounds(10, 380, 80, 100);

		add(jl1);
		add(jt1);
		add(jl2);
		add(jt2);
		add(ja1);
		add(ja2);
		add(jl3);
		add(jl4);
		add(jl5);
		add(jt3);
		add(jl6);
		add(jt4);
		add(jb2);
		add(jb4);
		this.repaint();
	}

	private void delete_xianshi_zhandian() {
		ArrayList<String> list = new ArrayList<>();
		ja1.setText("");
		ja2.setText("");// ��ֹ�ظ���ʾ�Լ��任����
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/mydata?"
					+ "user=root&password=root");
			stmt = conn.createStatement();
			String sql = "SELECT վ��  FROM `����ʵ��`where ����='" + jt1.getText()+ "'and ����=0 order by վ��";
			rs = stmt.executeQuery(sql);
			while (rs.next())
				list.add(rs.getString(1));
			for (int i = 0; i < list.size(); i++) {
				// ja1.append("->");
				ja1.append(list.get(i));// append()����������֮ǰ��ֵ����settext����Ҫ����
				if (i != list.size() - 1)
					ja1.append("-->");
			}
			list.clear();
			sql = "SELECT վ��  FROM `����ʵ��`where ����='" + jt1.getText()+ "'and ����=1 order by վ��";
			rs = stmt.executeQuery(sql);
			while (rs.next())
				list.add(rs.getString(1));
			for (int i = 0; i < list.size(); i++) {
				// ja1.append("->");
				ja2.append(list.get(i));// append()����������֮ǰ��ֵ����settext����Ҫ����
				if (i != list.size() - 1)
					ja2.append("-->");
			}
		} catch (ClassNotFoundException e) {
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

	private void delete_zhandian() {
		String sql;
		int[]zhandian_zhanci=new int[2];//���ڱ���վ��;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/mydata?"
					+ "user=root&password=root");
			stmt = conn.createStatement();
			//ȡ��Ҫɾ����վ���վ�Σ�
			sql="select վ��  from `����ʵ��` where ����='" + jt1.getText()+ "'and վ��='" + jt2.getText() + "'"
					+ "and ����="+jt3.getText()+"";
			rs=stmt.executeQuery(sql);
			while(rs.next())
				zhandian_zhanci[0]=Integer.parseInt(rs.getString("վ��"));
			//ȡ�����վ���վ��;
			sql="select վ��  from `����ʵ��` where ����='" + jt1.getText()+ "'and վ��='" + jt4.getText() + "'"
					+ "and ����="+jt3.getText()+"";
			rs=stmt.executeQuery(sql);
			while(rs.next())
				zhandian_zhanci[1]=Integer.parseInt(rs.getString("վ��"));
			//�������վ���վ��һ����ǰ��һλ��
			int zhanci=zhandian_zhanci[0];//��������Ҫɾ��վ�����վ���վ����
			for(int i=0;i<zhandian_zhanci[1]-zhandian_zhanci[0];i++)
			{
				System.out.println("hello");
				sql="update ����ʵ��  set վ��="+(zhanci)+" "
						+ "where ����='" + jt1.getText() + "' "
								+ "and ����="+jt3.getText()+" "
										+ "and վ��="+(zhanci+1)+"";
				stmt.executeUpdate(sql);
				zhanci++;
			}
			//ɾ��վ��
			sql= "delete FROM `����ʵ��` where ����='" + jt1.getText()
					+ "'and վ��='" + jt2.getText() + "'"
							+ " and ����="+jt3.getText()+"";
			stmt.executeUpdate(sql);
			

		} catch (ClassNotFoundException e) {
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

	private void xiugai_panel() {

		jl1 = new JLabel("���������޸���Ϣ�ĳ��κţ�");
		jl1.setBounds(10, 130, 190, 30);
		jt1 = new JTextField();
		jt1.setBounds(190, 135, 130, 20);

		jb3 = new JButton("��ʾ");
		jb3.setBounds(350, 130, 60, 30);
		jb3.addActionListener(new ButtonListener());

		jb5 = new JButton("�ύ");
		jb5.setBounds(50, 480, 60, 30);
		jb5.addActionListener(new ButtonListener());

		jl2 = new JLabel(
				"   IC��                 ѧ����                  ���꿨                  Ʊ��");
		jl2.setBounds(80, 160, 300, 40);
		jl3 = new JLabel("Ŀǰ");
		jl3.setBounds(15, 200, 30, 20);

		jt2 = new JTextField();
		jt2.setBounds(75, 200, 50, 20);

		jt3 = new JTextField();
		jt3.setBounds(160, 200, 50, 20);

		jt4 = new JTextField();
		jt4.setBounds(250, 200, 50, 20);

		jt5 = new JTextField();
		jt5.setBounds(340, 200, 50, 20);

		jl4 = new JLabel("��Ϊ");
		jl4.setBounds(15, 240, 30, 20);

		jt6 = new JTextField();
		jt6.setBounds(75, 240, 50, 20);

		jt7 = new JTextField();
		jt7.setBounds(160, 240, 50, 20);

		jt8 = new JTextField();
		jt8.setBounds(250, 240, 50, 20);

		jt9 = new JTextField();
		jt9.setBounds(340, 240, 50, 20);
		
		jl5=new JLabel("������                                                                               ������");
		jl5.setBounds(140, 260,400,30);
		
		jl6=new JLabel("����ʱ��                         �ճ�ʱ��                                  ����ʱ��                         �ճ�ʱ��");
		jl6.setBounds(70, 290, 500, 30);
		
		jl7=new JLabel("Ŀǰ");
		jl7.setBounds(15,330,30,20);
		jl8=new JLabel("��Ϊ");
		jl8.setBounds(15,370,30,20);
		
		jt10=new JTextField();//����ʱ�䣨�ϣ�
		jt10.setBounds(68, 330,50, 20);
		jt11=new JTextField();//�ճ�ʱ�䣨�ϣ�
		jt11.setBounds(196, 330, 50, 20);
		jt12=new JTextField();//����ʱ�䣨�£�
		jt12.setBounds(350, 330, 50, 20);
		jt13=new JTextField();//�ճ�ʱ�䣨�£�
		jt13.setBounds(478, 330, 50, 20);
		
		jt14=new JTextField();//����ʱ�䣨�ϣ�
		jt14.setBounds(68, 370,50, 20);
		jt15=new JTextField();//�ճ�ʱ�䣨�ϣ�
		jt15.setBounds(196, 370, 50, 20);
		jt16=new JTextField();//����ʱ�䣨�£�
		jt16.setBounds(350, 370, 50, 20);
		jt17=new JTextField();//�ճ�ʱ�䣨�£�
		jt17.setBounds(478, 370, 50, 20);
		add(jl1);add(jt1);add(jb3);add(jb5);
		add(jl2);add(jl3);add(jt2);add(jt3);add(jt4);add(jt5);add(jl4);add(jt6);add(jt7);add(jt8);add(jt9);
		add(jl5);add(jl6);add(jl7);add(jl8);add(jt10);add(jt11);add(jt12);add(jt13);add(jt14);add(jt15);add(jt16);add(jt17);
		this.repaint();
	}

	private void xiugai_xianshi(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/mydata?"
					+ "user=root&password=root");
			stmt = conn.createStatement();
			String sql = "SELECT DISTINCT IC��,ѧ����,���꿨,Ʊ��" + " FROM `����ʵ��`"
					+ "where ����='" + jt1.getText() + "'";
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				jt2.setText(rs.getString(1));
				jt3.setText(rs.getString(2));
				jt4.setText(rs.getString(3));
				jt5.setText(rs.getString(4));
			}
			sql="SELECT DISTINCT ����,�ճ� FROM `����ʵ��`where ����='" + jt1.getText() + "' and ����=0";
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				jt10.setText(rs.getString(1));
				jt11.setText(rs.getString(2));
			}
			sql="SELECT DISTINCT ����,�ճ� FROM `����ʵ��`where ����='" + jt1.getText() + "' and ����=1";
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				jt12.setText(rs.getString(1));
				jt13.setText(rs.getString(2));
			}
		} catch (ClassNotFoundException e) {
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

	private void xiugai() {
		try {
			String sql;
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/mydata?"
					+ "user=root&password=root");
			stmt = conn.createStatement();
			if(!jt6.getText().trim().equals(""))//�ж��Ƿ�Ϊ��
			{	sql="update `����ʵ��` set  IC��=" + jt6.getText() + " where ����='" + jt1.getText() + "'";
			    stmt.executeUpdate(sql);
			}
			if(!jt7.getText().trim().equals(""))
			{	sql="update `����ʵ��` set ѧ����=" + jt7.getText() + " where ����='" + jt1.getText() + "'";
			    stmt.executeUpdate(sql);
			}
			if(!jt8.getText().trim().equals(""))
			{	sql="update `����ʵ��` set  ���꿨=" + jt8.getText() + " where ����='" + jt1.getText() + "'";
			    stmt.executeUpdate(sql);
			}
			if(!jt9.getText().trim().equals(""))
			{	sql="update `����ʵ��` set  Ʊ��=" + jt9.getText() + " where ����='" + jt1.getText() + "'";
			    stmt.executeUpdate(sql);
			}
			if(!jt14.getText().trim().equals(""))
			{	sql="update `����ʵ��` set ����='"+jt14.getText()+"' where ����='" + jt1.getText() + "'and ����=0";
			    stmt.executeUpdate(sql);
			}
			if(!jt15.getText().trim().equals(""))
			{	sql="update `����ʵ��` set �ճ�='"+jt15.getText()+"' where ����='" + jt1.getText() + "'and ����=0";
			    stmt.executeUpdate(sql);
			}
			if(!jt16.getText().trim().equals(""))
			{	sql="update `����ʵ��` set ����='"+jt16.getText()+"' where ����='" + jt1.getText() + "'and ����=1";
			    stmt.executeUpdate(sql);
			}
			if(!jt17.getText().trim().equals(""))
			{	sql="update `����ʵ��` set �ճ�='"+jt17.getText()+"' where ����='" + jt1.getText() + "'and ����=1";
			    stmt.executeUpdate(sql);
			}
		} catch (ClassNotFoundException e) {
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

	private void tianjia_zhandian_panel(){
		jl1 = new JLabel("�����������վ��ĳ��κţ�");
		jl1.setBounds(10, 130, 190, 30);
		jt1 = new JTextField();
		jt1.setBounds(190, 135, 130, 20);

		jb6 = new JButton("��ʾ");
		jb6.setBounds(350, 125, 60, 30);
		jb6.addActionListener(new ButtonListener());

		jb7 = new JButton("ȷ��");
		jb7.setBounds(460, 160, 60, 30);
		jb7.addActionListener(new ButtonListener());

		jl2 = new JLabel("���վ������");
		jl2.setBounds(10, 160, 190, 30);
		jt2 = new JTextField();
		jt2.setBounds(90, 165, 100, 20);
        
		jl3 = new JLabel("ǰվ������");
		jl3.setBounds(230, 160, 190, 30);
		jt3 = new JTextField();
		jt3.setBounds(315, 165, 100, 20);

		jl4 = new JLabel("��ĩվ������");
		jl4.setBounds(10, 190, 190, 30);
		jt4 = new JTextField();
		jt4.setBounds(85, 195, 100, 20);
		
		jl5 = new JLabel("����");
		jl5.setBounds(200, 190, 190, 30);
		jt5 = new JTextField();
		jt5.setBounds(240, 195, 40, 20); 
		
		ja1 = new JTextArea();
		ja1.setBounds(50, 250, 500, 130);
		ja1.setLineWrap(true);// �����Զ����У�
		ja1.setEditable(false);
		ja1.setBorder (BorderFactory.createLineBorder(Color.gray,1));
		
		ja2 = new JTextArea();
		ja2.setBounds(50, 400, 500, 130);
		ja2.setLineWrap(true);// �����Զ����У�
		ja2.setEditable(false);
		ja2.setBorder (BorderFactory.createLineBorder(Color.gray,1));
		
		jl6 = new JLabel("������");
		jl6.setBounds(10, 220, 80, 100);

		jl7 = new JLabel("������");
		jl7.setBounds(10, 380, 80, 100);

		add(jl1);
		add(jt1);
		add(jl2);
		add(jt2);
		add(jl3);
		add(jt3);
		add(jl6);
		add(jt4);
		add(jl7);
		add(jt5);
		add(ja1);
		add(ja2);
		add(jl3);
		add(jl4);
		add(jl5);
		add(jb6);
		add(jb7);
		this.repaint();
	}
	//���������վ��ķ���
	private void tianjia_zhandian(){
		int []zhandian_zhanci=new int[2];
		String sql;
		String [] time=new String[2];//���ڱ��淢�����ճ�ʱ��
		int [] checi_xinxi=new int[4];//���ڱ������꿨�ȵ���Ϣ��
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/mydata?"
					+ "user=root&password=root");
			stmt = conn.createStatement();
			//���������ճ�ʱ��ȵ���Ϣ���������������Ժ����
			sql = "SELECT distinct  ����,�ճ�,Ʊ��,IC��,ѧ����,���꿨 FROM `����ʵ��`"
					+ " where ����='" + jt1.getText() + "'"
							+ "and ����="+jt5.getText()+"";
			//stmt.executeUpdate(sql);
			rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				time[0]=rs.getString("����");
				time[1]=rs.getString("�ճ�");
				checi_xinxi[0]=Integer.parseInt(rs.getString("Ʊ��"));
				checi_xinxi[1]=Integer.parseInt(rs.getString("IC��"));
				checi_xinxi[2]=Integer.parseInt(rs.getString("ѧ����"));
			    checi_xinxi[3]=Integer.parseInt(rs.getString("���꿨"));
			}
			
			
			sql = "select վ��  from ����ʵ�� where ����='" + jt1.getText() + "'"
					+ "and վ��='"+jt3.getText()+"'"
							+ "and ����="+jt5.getText()+"";
			//stmt.executeUpdate(sql);
			rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				zhandian_zhanci[0]=Integer.parseInt(rs.getString("վ��"));
			}
			sql = "select վ��  from ����ʵ�� where ����='" + jt1.getText() + "'"
					+ "and վ��='"+jt4.getText()+"'"
							+ "and ����="+jt5.getText()+"";
			//stmt.executeUpdate(sql);
			rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				zhandian_zhanci[1]=Integer.parseInt(rs.getString("վ��"));
			}
			int zhanci=zhandian_zhanci[1];//��������Ҫ���վ�����վ���վ����
			for(int i=0;i<zhandian_zhanci[1]-zhandian_zhanci[0];i++)
			{
				System.out.println("hello");
				sql="update ����ʵ��  set վ��="+(zhanci+1)+" "
						+ "where ����='" + jt1.getText() + "' "
								+ "and ����="+jt5.getText()+" "
										+ "and վ��="+zhanci+"";
				stmt.executeUpdate(sql);
				zhanci--;
			}
			sql ="INSERT INTO ����ʵ�� " + "VALUES ('"+jt1.getText() +"',"
					+ "'"+jt2.getText()+"',"
							+ ""+(zhandian_zhanci[0]+1)+","
									+ ""+jt5.getText()+","
											+ "'"+time[0]+"',"
													+ "'"+time[1]+"',"
															+ ""+checi_xinxi[0]+","
																	+ ""+checi_xinxi[1]+","
																			+ ""+checi_xinxi[2]+","
																					+ ""+checi_xinxi[3]+")";
			stmt.executeUpdate(sql);
		} catch (ClassNotFoundException e) {
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
	private class RadioButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == jr1) {
				delete_zujian(count);
				delete_checi_panel();
				count = 1;
				System.out.println("hello");
			}
			if (e.getSource() == jr2) {
				delete_zujian(count);
				delete_zhandian_panel();
				count = 2;
				System.out.println("ho");
			}
			if (e.getSource() == jr3) {
				delete_zujian(count);
				xiugai_panel();
				count = 3;
				System.out.println("he");
			}
			if (e.getSource() == jr4) {
				delete_zujian(count);
				tianjia_zhandian_panel();
				count = 4;
			}
			
		}
	}
	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == jb1) {
				delete_checi();
			}
			if (e.getSource() == jb2) {
				delete_xianshi_zhandian();
			}
			if (e.getSource() == jb3) {
				xiugai_xianshi();
			}
			if (e.getSource() == jb4) {
				delete_zhandian();
			}
			if (e.getSource() == jb5) {
				xiugai();
			}
			if (e.getSource() == jb6) {
				delete_xianshi_zhandian();//������ʾվ�㣬ʹ�õ���ɾ��վ�������һ������
			}
			if (e.getSource() == jb7) {
				tianjia_zhandian();
			}
		}
	}
}
