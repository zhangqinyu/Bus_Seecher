package ����Ա����;
/*���������Ҫ�ǽ�վ����վ��֮�����Ϣ�������ݿ�*/
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class insert_zhan_to_zhan_information {

	public insert_zhan_to_zhan_information() {
		// TODO Auto-generated method stub
		System.out.println("�ɹ���");
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql;
		ArrayList<String> st=new ArrayList<String>();
		int count=0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/mydata?"
					+ "user=root&password=root");
			stmt = conn.createStatement();
			sql="select * from tianjia_bus_information";
			rs = stmt.executeQuery( sql);
			List<String> list1 = new ArrayList<String>();// ����ȡ������б�֮����ʹ���б��������飬��Ϊ���ڻ���֪������ж��٣�����ȷ�����鳤�ȣ���������list���գ�Ȼ��תΪ����
			List<String> list2 = new ArrayList<String>();
			Vector<Integer> list3 = new Vector<Integer>();//����վλ�����վ��
			Vector<Integer> list4= new Vector<Integer>();//����Ʊ��
			while (rs.next()) {// ��������ݣ�ȡ��һ�������list
				list1.add(rs.getString("����"));
				list2.add(rs.getString("վ��"));
				list3.add(rs.getInt("վ��"));
				list4.add(rs.getInt("Ʊ��"));
				
			}
					//for(int i=0;i<list2.size();i++)
				//System.out.println(list2.get(i));
			for(int i=0;i<list2.size();i++)
			{	count++;
				for(int a=count;a<list2.size();a++)
				{
					sql="INSERT INTO zhan_zhan_shiyan " +
							 "VALUES ('"+list1.get(a)+"','"+list2.get(i)+"','"+list2.get(a)+"',"+(list3.get(a)-list3.get(i))+","+list4.get(a)+")";
					stmt.executeUpdate(sql);
				}
			
			
			}
			//���վ��վ��Ϣ�󣬽�tianjia_bus_information����գ�Ϊ�´δ�������׼����
			sql="DELETE FROM `tianjia_bus_information`;";
			stmt.executeUpdate(sql);
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException ex) {
			// handle any errors
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
