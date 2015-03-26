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
	// 构造方法
	public Test() {
		// 窗体的相关属性的定义
		super("JTable数据绑定示例");
		this.setSize(600,600);
		this.setLayout(null);
		this.setLocation(100, 50);
		// 创建组件
		this.scpDemo = new JScrollPane();
		this.scpDemo.setBounds(0, 0,590, 600);
		
		// 给按钮注册监听
		show_luxian();
		// 将组件加入到窗体中
		add(this.scpDemo);

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
			String sql ="SELECT x.`乘坐路线`as 起始公交,x.`起点`as 出发站, x.`终点`as 中转站1,x.`票价`as 票价1,x.`站点数`as 站数1,y.`乘坐路线`as 换乘公交1,y.`终点`as 中转站2,y.`票价`as 票价2,y.`站点数`as 站数2, z.`乘坐路线`as 换乘公交2,z.`终点`as 终点站,z.`票价`as 票价3,z.`站点数`as 站数3,(x.`站点数`+y.`站点数`+z.`站点数`) as 总站数,(x.`票价`+y.`票价`+z.`票价`) as 总票价 FROM `bustest` x,`bustest` y,`bustest` z where x.起点='s1'and x.终点=y.起点 and y.终点=z.起点and z.终点='s12'and x.`乘坐路线`!=y.`乘坐路线`and y.`乘坐路线`!=z.`乘坐路线`";
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
			Object[][] info = new Object[count][115];
			count = 0;
			while (rs.next()) {
				info[count][0] = Integer.valueOf(rs.getInt("起始公交"));
				info[count][1] = rs.getString("出发站");
				info[count][2] = rs.getString("中转站1");
				info[count][3] = Integer.valueOf(rs.getInt("票价1"));
				info[count][4] = Integer.valueOf(rs.getInt("站点数1"));
				info[count][5] = Integer.valueOf(rs.getInt("换乘公交1"));
				info[count][6] = rs.getString("中转站2");
				info[count][7] = Integer.valueOf(rs.getInt("票价2"));
				info[count][8] = Integer.valueOf(rs.getInt("站点数2"));
				info[count][9] = Integer.valueOf(rs.getInt("换乘公交2"));
				info[count][10] = rs.getString("终点站");
				info[count][11] = Integer.valueOf(rs.getInt("票价3"));
				info[count][12] = Integer.valueOf(rs.getInt("站点数3"));
				info[count][12] = Integer.valueOf(rs.getInt("总站数"));
				info[count][14] = Integer.valueOf(rs.getInt("总票价"));
				count++;
			}
			// 定义表头
			String[] title = { "起始公交", "出发站","中转站1" ,"票价1","站点数1","换乘公交1","中转站2","票价2","站点数2","换乘公交2","终点站","票价3","站点数3","总站数","总票价"};
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