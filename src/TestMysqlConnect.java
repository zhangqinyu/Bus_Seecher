
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import 登录部分.log_succes_frame;

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
			List<String> list = new ArrayList<String>();// 创建取结果的列表，之所以使用列表，不用数组，因为现在还不知道结果有多少，不能确定数组长度，所有先用list接收，然后转为数组
			while (rs.next()) {// 如果有数据，取第一列添加如list
				list.add(rs.getString(2));
			}
			if (list != null && list.size() > 0) {// 如果list中存入了数据，转化为数组
				String[] arr = new String[list.size()];// 创建一个和list长度一样的数组
				for (int i = 0; i < list.size(); i++) {
					arr[i] = list.get(i);// 数组赋值了。
				}
				// 输出数组
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
