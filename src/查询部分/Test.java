package 查询部分;

import javax.swing.*;
import javax.swing.table.JTableHeader;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Test extends JFrame {
	// 定义组件
	private JScrollPane scpDemo;
	private JTableHeader jth;
	private JTable tabDemo;
	private JButton btnShow;

	// 构造方法
	public Test() {
		// 窗体的相关属性的定义
		super("JTable数据绑定示例");
		this.setSize(330, 400);
		this.setLayout(null);
		this.setLocation(100, 50);
		// 创建组件
		this.scpDemo = new JScrollPane();
		this.scpDemo.setBounds(10, 50, 300, 270);
		this.btnShow = new JButton("显示数据");
		this.btnShow.setBounds(10, 10, 300, 30);
		// 给按钮注册监听
		show_luxian();
		// 将组件加入到窗体中
		add(this.scpDemo);
		add(this.btnShow);
		// 显示窗体
		this.setVisible(true);
	}

	// 点击按钮时的事件处理
	public void show_luxian() {
		// 以下是连接数据源和显示数据的具体处理方法，请注意下
		try {
			// 获得连接
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost/mydata?"
							+ "user=root&password=root");
			// 建立查询条件
			String sql = "select * from bustest ";
			PreparedStatement pstm = conn.prepareStatement(sql);
			// 执行查询
			ResultSet rs = pstm.executeQuery();
			// 计算有多少条记录
			int count = 0;
			while (rs.next()) {
				count++;
			}
			rs = pstm.executeQuery();
			// 将查询获得的记录数据，转换成适合生成JTable的数据形式
			Object[][] info = new Object[count][5];
			count = 0;
			while (rs.next()) {
				info[count][0] = Integer.valueOf(rs.getInt("乘坐路线"));
				info[count][1] = rs.getString("起点");
				info[count][2] = rs.getString("终点");
				info[count][3] = Integer.valueOf(rs.getInt("站点数"));
				info[count][4] = Integer.valueOf(rs.getInt("票价"));
				count++;
			}
			// 定义表头
			String[] title = { "乘坐路线", "起点", "终点", "站点数","票价" };
			// 创建JTable
			this.tabDemo = new JTable(info, title);
			// 显示表头
			this.jth = this.tabDemo.getTableHeader();
			// 将JTable加入到带滚动条的面板中
			this.scpDemo.getViewport().add(tabDemo);
		} catch (ClassNotFoundException cnfe) {
			JOptionPane.showMessageDialog(null, "数据源错误", "错误",
					JOptionPane.ERROR_MESSAGE);
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "数据操作错误", "错误",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	
}