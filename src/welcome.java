
import java.awt.*;

import javax.swing.*;
public class welcome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		   JFrame frame=new JFrame("he frame");
		   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		   
		   welpanel p=new welpanel();
		   
		   frame.getContentPane().add(p);
		   frame.pack();
		   frame.setVisible(true);
	}

}
//public void Testbus_search_single_line(){
//
//	ArrayList<String> list2 = new ArrayList<String>();// ����ȡ������б�֮����ʹ���б��������飬��Ϊ���ڻ���֪������ж��٣�����ȷ�����鳤�ȣ���������list���գ�Ȼ��תΪ����
//	ArrayList<String> list3 = new ArrayList<String>();
//	Vector<Integer> list1 = new Vector<Integer>();
//	Vector<Integer> list4 = new Vector<Integer>();
//	
//	try {
//		Class.forName("com.mysql.jdbc.Driver");
//		conn = DriverManager
//				.getConnection("jdbc:mysql://localhost/mydata?"
//						+ "user=root&password=root");
//		stmt1 = conn.createStatement();
//	
//		rs1 = stmt1.executeQuery("select * from bustest ");
//		
//		while (rs1.next()) {// ��������ݣ�ȡ�ڶ��������list
//			list2.add(rs1.getString(2));
//			list3.add(rs1.getString(3));
//			
//			list1.add(rs1.getInt(1));
//			list4.add(rs1.getInt(4));
//		}
//	}catch (ClassNotFoundException e) {
//		e.printStackTrace();
//	} catch (SQLException ex) {
//		System.out.println("SQLException: " + ex.getMessage());
//		System.out.println("SQLState: " + ex.getSQLState());
//		System.out.println("VendorError: " + ex.getErrorCode());
//	} finally {
//		try {
//			if (rs1 != null) {
//				rs1.close();
//				rs1 = null;
//			}
//			if (stmt1 != null) {
//				stmt1.close();
//				stmt1 = null;
//			}
//			if (conn != null) {
//				conn.close();
//				conn = null;
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//
//	
//
//	if (list1 != null && list1.size() > 0&&list2 != null && list2.size() > 0&&list3 != null && list3.size() > 0&&list4 != null && list4.size() > 0) {// ���list�д��������ݣ�ת��Ϊ����
//		String[] arr2 = new String[list2.size()];// ����һ����list����һ��������
//		String[] arr3= new String[list3.size()];
//		int[] arr1=new int[list1.size()];
//		int[] arr4=new int[list4.size()];
//		for (int i = 0; i < list1.size(); i++) {
//			arr2[i] = list2.get(i);// ���鸳ֵ�ˡ�
//			arr1[i] = Integer.parseInt(list1.get(i).toString());
//			arr3[i] = list3.get(i);// ���鸳ֵ�ˡ�
//			arr4[i] = Integer.parseInt(list4.get(i).toString());
//						
//		}
//	
//		for (int i = 0; i < arr1.length; i++) {
//			
//			if(arr2[i].equals((String) jc1.getSelectedItem())&&arr3[i].equals((String) jc2.getSelectedItem()))
//				{
//				System.out.println("h");
//				jt1.setText("�����         "+String.valueOf(arr1[i])+"      ����·"+
//				",����         "+String.valueOf(arr4[i])+"      վ·") ;	
//				
//				}
//
//		}
//		
//	}
//	
//}
//
//public void Testbus_search_two_line(){
//try {
//	Class.forName("com.mysql.jdbc.Driver");
//	conn = DriverManager
//			.getConnection("jdbc:mysql://localhost/mydata?"
//					+ "user=root&password=root");
//	stmt2 = conn.createStatement();
//
//	rs2 = stmt2.executeQuery("SELECT x.`����·��`as ��ʼ����,x.`���`as ����վ, x.`�յ�`as ��תվ,x.`Ʊ��`,x.`վ����`,"
//			+ "y.`����·��`as ���˹���,y.`�յ�`as �յ�վ,y.`Ʊ��`,y.`վ����`,	"
//			+ "(x.`վ����`+y.`վ����`)as ��վ��,(x.`Ʊ��`+y.`Ʊ��`)as ��Ʊ��"
//			+ " FROM `bustest` x,`bustest` y "
//			+ "where x.���='"+(String) jc1.getSelectedItem()+"'"
//					+ "and x.�յ�=y.��� "
//					+ "and y.�յ�='"+(String) jc2.getSelectedItem()+"'"
//							+ "and x.`����·��`!=y.`����·��`"
//							);
//	//�������������˵��㷨��
//	//rs2 = stmt2.executeQuery("SELECT *,(x.`վ����`+y.`վ����`)as su  FROM `bustest` x,`bustest` y"
////			+ " where x.���='"+(String) jc1.getSelectedItem()+"'"
////					+ "and x.�յ�=y.��� and y.�յ�='"+(String) jc2.getSelectedItem()+"' "
////							+ "and (x.`վ����`+y.`վ����`)<=all(SELECT (x.`վ����`+y.`վ����`)  as su FROM `bustest` x,`bustest` y where x.���='"+(String) jc1.getSelectedItem()+"'and x.�յ�=y.��� and y.�յ�='"+(String) jc2.getSelectedItem()+"')");
//	while(rs2.next())
//	{
//		
//		System.out.println(rs2.getString(1)+" "+
//				        rs2.getString(2)+" "+
//						rs2.getString(3)+" "+
//						rs2.getString(4)+" "+
//						rs2.getString(5)+" "+
//						rs2.getString(6)+" "+
//						rs2.getString(7)+" "+
//						rs2.getString(8)+" "+
//						rs2.getString(9)+" "+
//						rs2.getString(10)+" "+
//						rs2.getString(11));
//		
////		jt1.setText(rs2.getString("����·��1"));
////		jt1.setText(rs2.getString(2));
////		jt1.setText(rs2.getString(3));
////		jt1.setText(rs2.getString(4));
////		jt1.setText(rs2.getString(5));
////		jt1.setText(rs2.getString(6));
////		jt1.setText(rs2.getString(7));
////		jt1.setText(rs2.getString(8));
////		jt1.setText(rs2.getString(9));
////		jt1.setText(rs2.getString(10));
////		jt1.setText(rs2.getString(11));
//		
//	}
//
//}	
//	catch (ClassNotFoundException e) {
//	e.printStackTrace();
//} catch (SQLException ex) {
//	System.out.println("SQLException: " + ex.getMessage());
//	System.out.println("SQLState: " + ex.getSQLState());
//	System.out.println("VendorError: " + ex.getErrorCode());
//} finally {
//	try {
//		if (rs2 != null) {
//			rs2.close();
//			rs2 = null;
//		}
//		if (stmt2 != null) {
//			stmt2.close();
//			stmt2 = null;
//		}
//		if (conn != null) {
//			conn.close();
//			conn = null;
//		}
//	} catch (SQLException e) {
//		e.printStackTrace();
//	}
//}
//
//}
//public void Testbus_search_three_line(){
//try {
//	Class.forName("com.mysql.jdbc.Driver");
//	conn = DriverManager
//			.getConnection("jdbc:mysql://localhost/mydata?"
//					+ "user=root&password=root");
//	stmt2 = conn.createStatement();
//
//	rs2 = stmt2.executeQuery("SELECT * FROM `bustest` x,`bustest` y,`bustest` z"
//			+ " where x.���='"+(String) jc1.getSelectedItem()+"'"
//					+ "and x.�յ�=y.��� "
//					+ "and y.�յ�=z.���"
//					+ " and z.�յ�='"+(String) jc1.getSelectedItem()+"';");
//	while(rs2.next())
//	{
//		System.out.println(rs2.getString(1)+" "+
//				        rs2.getString(2)+" "+
//						rs2.getString(3)+" "+
//						rs2.getString(4)+" "+
//						rs2.getString(5)+" "+
//						rs2.getString(6)+" "+
//						rs2.getString(7)+" "+
//						rs2.getString(8)+" "+
//						rs2.getString(9)+" "+
//						rs2.getString(10)+" "+
//						rs2.getString(11)+" "+
//						rs2.getString(12));
//	}
//
//}	
//	catch (ClassNotFoundException e) {
//	e.printStackTrace();
//} catch (SQLException ex) {
//	System.out.println("SQLException: " + ex.getMessage());
//	System.out.println("SQLState: " + ex.getSQLState());
//	System.out.println("VendorError: " + ex.getErrorCode());
//} finally {
//	try {
//		if (rs2 != null) {
//			rs2.close();
//			rs2 = null;
//		}
//		if (stmt2 != null) {
//			stmt2.close();
//			stmt2 = null;
//		}
//		if (conn != null) {
//			conn.close();
//			conn = null;
//		}
//	} catch (SQLException e) {
//		e.printStackTrace();
//	}
//}
//}}}
