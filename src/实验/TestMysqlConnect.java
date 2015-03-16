package สตั้;
import java.sql.*;

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
//			String sql="INSERT INTO dept " +
//	                   "VALUES (14, 'a', 'a')";
//			stmt.executeUpdate(sql);
			rs = stmt.executeQuery("select * from  customer");
			while (rs.next()) {
				System.out.println(rs.getString("name"));
			}
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
