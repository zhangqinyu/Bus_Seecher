package ��ѯ����;

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

import ��¼����.log_again_frame;
import ��¼����.log_succes_frame;
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
		private JPanel jp1,jp2;
		private Connection conn = null;
		private Statement stmt = null;
		private ResultSet rs = null;
		private String s1,s2;
		public welpanel(){
			setLayout(new GridLayout(2, 1));
			
			//TestMysqlConnect();
			String []st={"s1","s2","s3","s4","s5","s6","s7","s8","s9","s10","s11","s12","s13",""};
			this.jc1 = new JComboBox(st);
			this.jc2 = new JComboBox(st);
			 jc1.setBounds(40, 20, 150, 30);
			 jc2.setBounds(300, 20, 150, 30);
			 
			b1 = new JButton("����˵�·��");
			b2 = new JButton("��̵�·��");
			b3 = new JButton("��ʡʱ���·��");
			b4 = new JButton("����");
			b5 = new JButton("�˳�");
			
			b1.setBounds(20, 100, 85, 40);
			b2.setBounds(122, 100, 85, 40);
			b3.setBounds(230, 100, 85, 40);
			b4.setBounds(350, 100, 85, 40); 
			b5.setBounds(459, 100, 85, 40);
			
			b1.addActionListener(new ButtonListener());
			b4.addActionListener(new ButtonListener());
			jl1=new JLabel("��");
			jl2=new JLabel("��");
	    	jl1.setBounds(10,  20,30, 30);
	    	jl2.setBounds(245,  20,30, 30);
			
			jp1=new JPanel();
			jp2=new JPanel();
	        
			
			jt1=new JTextField(100);
			jt1.setBounds(0, 0, 600, 300);
			
			jp1.setLayout(null);
			jp2.setLayout(null);
			
			jp1.add(jl1);
			jp1.add(jl2);
			jp1.add(b1);
			jp1.add(b2);
			jp1.add(b3);
			jp1.add(b4);
			jp1.add(b5);
		
			jp1.add(jc1);
			jp1.add(jc2);
		    
			jp2.add(jt1);
			
			add(jp1);
			add(jp2);
			
			
			
			setPreferredSize(new Dimension(600, 600));
		}
		private class ButtonListener implements ActionListener {

			
			public void actionPerformed(ActionEvent e) {
				s1 = (String) jc1.getSelectedItem();//ȡ�õ�ǰֵ��
				s2 = (String) jc2.getSelectedItem();//ȡ�õ�ǰֵ��
				if (e.getSource() == b1)
                    TestMysqlConnect(); 
				if(e.getSource()==b4)
					jc1.setSelectedItem("");
				    jc2.setSelectedItem("");
				    jt1.setText("");
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
				Testbus_search();
				
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
//			ArrayList<String> list1 = new ArrayList<String>();// ����ȡ������б�֮����ʹ���б��������飬��Ϊ���ڻ���֪������ж��٣�����ȷ�����鳤�ȣ���������list���գ�Ȼ��תΪ����
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
//    		{	 arr1 = new String[list1.size()];// ����һ����list����һ��������
//			      arr2= new String[list2.size()];
//			      int count=0;
//			      for (int i = 0; i < list1.size(); i++) {
//		    			arr1[i] = list1.get(i);
//		    			arr2[i] = list2.get(i);
//						count++;
//			      }	
//			      this.jc1 = new JComboBox(arr1);// �����б�
//				  this.jc2 = new JComboBox(arr2);
//				  }
//    		
//    		
    		//}
        public void Testbus_search(){
        	
        		ArrayList<String> list2 = new ArrayList<String>();// ����ȡ������б�֮����ʹ���б��������飬��Ϊ���ڻ���֪������ж��٣�����ȷ�����鳤�ȣ���������list���գ�Ȼ��תΪ����
        		ArrayList<String> list3 = new ArrayList<String>();
        		Vector<Integer> list1 = new Vector<Integer>();
        		Vector<Integer> list4 = new Vector<Integer>();
        		
        		try {
        			
        			while (rs.next()) {// ��������ݣ�ȡ�ڶ��������list
        				list2.add(rs.getString(2));
        				list3.add(rs.getString(3));
        				
        				list1.add(rs.getInt(1));
        				list4.add(rs.getInt(4));
        			}
        		} catch (SQLException e) {
        			// TODO Auto-generated catch block
        			e.printStackTrace();
        		}
        		

        		if (list1 != null && list1.size() > 0&&list2 != null && list2.size() > 0&&list3 != null && list3.size() > 0&&list4 != null && list4.size() > 0) {// ���list�д��������ݣ�ת��Ϊ����
        			String[] arr2 = new String[list2.size()];// ����һ����list����һ��������
        			String[] arr3= new String[list3.size()];
        			int[] arr1=new int[list1.size()];
        			int[] arr4=new int[list4.size()];
        			for (int i = 0; i < list1.size(); i++) {
        				arr2[i] = list2.get(i);// ���鸳ֵ�ˡ�
        				arr1[i] = Integer.parseInt(list1.get(i).toString());
        				arr3[i] = list3.get(i);// ���鸳ֵ�ˡ�
        				arr4[i] = Integer.parseInt(list4.get(i).toString());
        				
        			}
        		
        			for (int i = 0; i < arr1.length; i++) {
        				
        				if(arr2[i].equals((String) jc1.getSelectedItem())&&arr3[i].equals((String) jc2.getSelectedItem()))
        					{//System.out.println("haha")
        					//jt1.setText(String.valueOf(arr1[i]));
        					System.out.println(arr1[i]);
        					}
        				
        				
        			}
        			
        		}
        		
        	}
        
        }
}
