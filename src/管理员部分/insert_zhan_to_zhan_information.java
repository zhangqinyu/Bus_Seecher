package 管理员部分;
/*这个方法主要是将站点与站点之间的信息存入数据库*/
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class insert_zhan_to_zhan_information {

	public insert_zhan_to_zhan_information() {
		// TODO Auto-generated method stub
		System.out.println("成功了");
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
			List<String> list1 = new ArrayList<String>();// 创建取结果的列表，之所以使用列表，不用数组，因为现在还不知道结果有多少，不能确定数组长度，所有先用list接收，然后转为数组
			List<String> list2 = new ArrayList<String>();
			Vector<Integer> list3 = new Vector<Integer>();//存入站位，求得站数
			Vector<Integer> list4= new Vector<Integer>();//存入票价
			while (rs.next()) {// 如果有数据，取第一列添加如list
				list1.add(rs.getString("车次"));
				list2.add(rs.getString("站名"));
				list3.add(rs.getInt("站次"));
				list4.add(rs.getInt("票价"));
				
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
			//存好站与站信息后，将tianjia_bus_information表清空，为下次存入做好准备；
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
