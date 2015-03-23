
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import ��¼����.log_succes_frame;

public class TestMysqlConnect {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/mydata?"
					+ "user=root&password=root");
			stmt = conn.createStatement();
			// String sql="INSERT INTO dept " +
			// "VALUES (14, 'a', 'a')";
			// stmt.executeUpdate(sql);
			String as="as";
			rs = stmt.executeQuery("select * from  customer");
			List<String> list = new ArrayList<String>();// ����ȡ������б�֮����ʹ���б��������飬��Ϊ���ڻ���֪������ж��٣�����ȷ�����鳤�ȣ���������list���գ�Ȼ��תΪ����
			while (rs.next()) {// ��������ݣ�ȡ��һ�������list
				list.add(rs.getString(2));
			}
			if (list != null && list.size() > 0) {// ���list�д��������ݣ�ת��Ϊ����
				String[] arr = new String[list.size()];// ����һ����list����һ��������
				for (int i = 0; i < list.size(); i++) {
					arr[i] = list.get(i);// ���鸳ֵ�ˡ�
				}
				// �������
				for (int i = 0; i < arr.length; i++) {
					System.out.println(arr[i]);
					if(arr[i].equals(as))
						new log_succes_frame();
				}
			}
			// while (rs.next()) {
			// System.out.println(rs.getString(""));
			// }
		} catch (ClassNotFoundException e) {
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
