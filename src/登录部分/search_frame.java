package 登录部分;
import java.awt.*;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class search_frame {
	JFrame jframe;
	public search_frame() {
		jframe = new JFrame();
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int width = 600;
		int height = 600;
		jframe.setBounds((d.width - width) / 2, (d.height - height) / 2, width,
				height);
		jframe.setLayout(null);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		welpanel p = new welpanel();
		p.setBounds(0, 0, 700, 600);

		jframe.getContentPane().add(p);
		jframe.pack();
		jframe.setSize(700, 600);

		jframe.setVisible(true);
        
	}

	class welpanel extends JPanel {

		private JButton b1, b2, b3, b4, b5, b6,b7;
		private JComboBox jc1, jc2;
		private JTextField jt1, jt2, jt3, jt4;
		private JTextField jt5;// 用来给出备选答案；
		private JLabel jl1, jl2, jl3, jl4, jl5;
		private int a = 0;
		private boolean bl = true;// 判断使用哪种方法；

		private JLabel image_label;

		private static final long serialVersionUID = 1L;
		private static final String TIP = "QQ号码/手机/邮箱";

		public welpanel() {

			jt1 = new JTextField(100);
			jt2 = new JTextField(100);
			jt3 = new JTextField(100);
			jt4 = new JTextField(100);

			jt1.setBounds(40, 20, 150, 30);
			jt2.setBounds(300, 20, 150, 30);
			jt3.setBounds(40, 80, 150, 30);
			jt4.setBounds(40, 140, 150, 30);
			jt1.setForeground (Color.gray);
			jt2.setForeground (Color.gray);
			jt3.setForeground (Color.gray);
			jt4.setForeground (Color.gray);
			jt1.setText("请输入您的位置");
			jt2.setText("请输入您想去的地方");
			jt3.setText("请输入您想查询的车号");
			jt4.setText("请输入您想查询的站点");
            jt1.addFocusListener(new FocusHandler());
            jt2.addFocusListener(new FocusHandler());
            jt3.addFocusListener(new FocusHandler());
            jt4.addFocusListener(new FocusHandler());
            
			b1 = new JButton("查询1");
			b2 = new JButton("查询2");
			b3 = new JButton("查询3");
			b4 = new JButton("清屏");
			b5 = new JButton("返回");
			b6 = new JButton("退出");

			b1.setBounds(500, 20, 85, 40);
			b2.setBounds(500, 80, 85, 40);
			b3.setBounds(500, 140, 85, 40);
			b4.setBounds(40, 200, 85, 40);
			b5.setBounds(270, 200, 85, 40);
			b6.setBounds(500, 200, 85, 40);

			b1.addActionListener(new ButtonListener());
			b2.addActionListener(new ButtonListener());
			b3.addActionListener(new ButtonListener());
			b4.addActionListener(new ButtonListener());
			b5.addActionListener(new ButtonListener());
			b6.addActionListener(new ButtonListener());
			jl1 = new JLabel("从");
			jl2 = new JLabel("==>");
			jl1.setBounds(10, 20, 30, 30);
			jl2.setBounds(245, 20, 30, 30);

			jl3 = new JLabel("车次");
			jl4 = new JLabel("站点");
			jl3.setBounds(10, 80, 30, 30);
			;
			jl4.setBounds(10, 140, 30, 30);

			image_label = new JLabel();
			image_label.setIcon(new change_image_size (
					"C:\\Users\\18580_000\\Downloads\\search_image.jpg", 700,
					600).getImageIcon());
			image_label.setSize(700, 600);

			add(jl1);
			add(jl2);
			add(jl3);
			add(jl4);

			add(b1);
			add(b2);
			add(b3);
			add(b4);
			add(b5);
			add(b6);

			add(jt1);
			add(jt2);
			add(jt3);
			add(jt4);

			add(image_label);

			setLayout(null);
			setOpaque(false); // 设置为透明！！！
			
			try {

				new tishi(jt1, "select DISTINCT 站名 from bus_information ");
				new tishi(jt2, "select DISTINCT 站名 from bus_information ");
				new tishi(jt3, "select DISTINCT 车次 from bus_information");
				new tishi(jt4, "select DISTINCT 站名 from  bus_information "); // 将信息放入下拉框中；
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		private class FocusHandler extends FocusAdapter{
			public void focusGained(FocusEvent e){
				if(e.getSource()==jt1){
					if("请输入您的位置".equals(jt1.getText()))
						jt1.setText("");
			}
				if(e.getSource()==jt2){
					if("请输入您想去的地方".equals(jt2.getText()))
						jt2.setText("");
			}
				if(e.getSource()==jt3){
					if("请输入您想查询的车号".equals(jt3.getText()))
						jt3.setText("");
			}
				if(e.getSource()==jt4){
					if("请输入您想查询的站点".equals(jt4.getText()))
						jt4.setText("");
			}
				}
			
			public void focusLost(FocusEvent e){
				if(e.getSource()==jt1){
					if("".equals(jt1.getText())){
						jt1.setText("请输入您的位置");
					}
				}
				if(e.getSource()==jt2){
					if("".equals(jt2.getText())){
						jt2.setText("请输入您想去的地方");
					}
				}
				if(e.getSource()==jt3){
					if("".equals(jt3.getText())){
						jt3.setText("请输入您想查询的车号");
					}
				}
				if(e.getSource()==jt4){
					if("".equals(jt4.getText())){
						jt4.setText("请输入您想查询的站点");
					}
				}
			}
		}
		class line_JFrame extends JFrame {

			public line_JFrame() {

				super("line_JFrame");
				this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				this.setLayout(null);
				Testbus_search_single_line t1 = new Testbus_search_single_line();
				Testbus_search_two_line t2 = new Testbus_search_two_line();
				Testbus_search_three_line t3 = new Testbus_search_three_line();
				t1.setBounds(0, 0, 900, 150);
				t2.setBounds(0, 200, 900, 150);
				t3.setBounds(0, 400, 900, 150);
				this.getContentPane().add(t1);
				this.getContentPane().add(t2);
				this.getContentPane().add(t3);
				this.pack();
				this.setSize(1000, 800);
				this.setVisible(true);
			}

			class Testbus_search_single_line extends JScrollPane {
				private JTableHeader jth;
				private JTable tabDemo;

				public Testbus_search_single_line() {
					this.setBounds(0, 0, 900, 150);
					show_luxian();
				}

				// 点击按钮时的事件处理
				public void show_luxian() {
					// 以下是连接数据源和显示数据的具体处理方法，请注意下
					try {
						// 获得连接
						Class.forName("com.mysql.jdbc.Driver");
						Connection conn = DriverManager
								.getConnection("jdbc:mysql://localhost/mydata?"
										+ "user=root&password=root");
						String sql = "SELECT 乘坐路线 ,起点 ,终点,站点数,票价 from shiyan "
								+ "where 起点='" + (String) jt1.getText() + "' "
								+ "and 终点='" + (String) jt2.getText() + "'";
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
							info[count][0] = rs.getString("乘坐路线");
							info[count][1] = rs.getString("起点");
							info[count][2] = rs.getString("终点");
							info[count][3] = Integer.valueOf(rs.getInt("站点数"));
							info[count][4] = Integer.valueOf(rs.getInt("票价"));
							count++;
						}
						// 定义表头
						String[] title = { "乘坐路线", "起点", "终点", "站点数", "票价" };
						// 创建JTable
						this.tabDemo = new JTable(info, title) {
							public boolean isCellEditable(int row, int column) {
								return false;
							}// 表格不允许被编辑
						};
						// 设置列的宽度和位置不能改变；
						tabDemo.getTableHeader().setReorderingAllowed(false);
						tabDemo.getTableHeader().setResizingAllowed(false);
						// 显示表头
						this.jth = this.tabDemo.getTableHeader();
						// 将JTable加入到带滚动条的面板中
						this.getViewport().add(tabDemo);

					} catch (ClassNotFoundException cnfe) {
						JOptionPane.showMessageDialog(null, "数据源错误", "错误",
								JOptionPane.ERROR_MESSAGE);
					} catch (SQLException sqle) {
						JOptionPane.showMessageDialog(null, "数据操作错误", "错误",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}

			class Testbus_search_two_line extends JScrollPane {
				// 定义组件
				private JTableHeader jth;
				private JTable tabDemo;

				// 构造方法
				public Testbus_search_two_line() {
					// 窗体的相关属性的定义
					// super("JTable数据绑定示例");
					this.setBounds(0, 200, 900, 150);
					;
					show_luxian();
				}

				// 点击按钮时的事件处理
				public void show_luxian() {
					// 以下是连接数据源和显示数据的具体处理方法，请注意下
					try {
						// 获得连接
						Class.forName("com.mysql.jdbc.Driver");
						Connection conn = DriverManager
								.getConnection("jdbc:mysql://localhost/mydata?"
										+ "user=root&password=root");
						// 建立查询条件
						String sql = "SELECT x.`乘坐路线`as 起始公交,x.`起点`as 出发站, x.`终点`as 中转站,x.`票价`as 票价1,x.`站点数`as 站点数1,"
								+ "y.`乘坐路线`as 换乘公交,y.`终点`as 终点站,y.`票价`as 票价2,y.`站点数`as 站点数2,	"
								+ "(x.`站点数`+y.`站点数`)as 总站数,(x.`票价`+y.`票价`)as 总票价"
								+ " FROM `shiyan` x,`shiyan` y "
								+ "where x.起点='"
								+ (String) jt1.getText()
								+ "'"
								+ "and x.终点=y.起点 "
								+ "and y.终点='"
								+ (String) jt2.getText()
								+ "'"
								+ "and x.`乘坐路线`!=y.`乘坐路线`"
								+ "order by 总票价,总站数";
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
						Object[][] info = new Object[count][11];
						count = 0;
						while (rs.next()) {
							info[count][0] = rs.getString("起始公交");
							info[count][1] = rs.getString("出发站");
							info[count][2] = rs.getString("中转站");
							info[count][3] = Integer.valueOf(rs.getInt("票价1"));
							info[count][4] = Integer.valueOf(rs.getInt("站点数1"));
							info[count][5] = rs.getString("换乘公交");
							info[count][6] = rs.getString("终点站");
							info[count][7] = Integer.valueOf(rs.getInt("票价2"));
							info[count][8] = Integer.valueOf(rs.getInt("站点数2"));
							info[count][9] = Integer.valueOf(rs.getInt("总站数"));
							info[count][10] = Integer.valueOf(rs.getInt("总票价"));
							count++;
						}
						// 定义表头
						String[] title = { "起始公交", "出发站", "中转站", "票价1", "站点数1",
								"换乘公交", "终点站", "票价2", "站点数2", "总站数", "总票价" };
						// 创建JTable
						this.tabDemo = new JTable(info, title) {
							public boolean isCellEditable(int row, int column) {
								return false;
							}// 表格不允许被编辑
						};
						tabDemo.getTableHeader().setReorderingAllowed(false);
						tabDemo.getTableHeader().setResizingAllowed(false);
						// 显示表头
						this.jth = this.tabDemo.getTableHeader();
						// 将JTable加入到带滚动条的面板中
						this.getViewport().add(tabDemo);

					} catch (ClassNotFoundException cnfe) {
						JOptionPane.showMessageDialog(null, "数据源错误", "错误",
								JOptionPane.ERROR_MESSAGE);
					} catch (SQLException sqle) {
						JOptionPane.showMessageDialog(null, "数据操作错误", "错误",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}

			class Testbus_search_three_line extends JScrollPane {

				private JTableHeader jth;
				private JTable tabDemo;
				private DefaultTableModel tableModel;// 这是JTable 的子类，目的是使JTable
														// 不被别人编辑http://blog.sina.com.cn/s/blog_867ba16a01012hah.html

				public Testbus_search_three_line() {
					this.setBounds(0, 300, 900, 200);
					;
					show_luxian();
				}

				public void show_luxian() {

					try {
						// 获得连接
						Class.forName("com.mysql.jdbc.Driver");
						Connection conn = DriverManager
								.getConnection("jdbc:mysql://localhost/mydata?"
										+ "user=root&password=root");

						String sql = "SELECT x.`乘坐路线`as 起始公交,x.`起点`as 出发站, x.`终点`as 中转站1,x.`票价`as 票价1,x.`站点数`as 站数1,"
								+ "y.`乘坐路线`as 换乘公交1,y.`终点`as 中转站2,y.`票价`as 票价2,y.`站点数`as 站数2,"
								+ " z.`乘坐路线`as 换乘公交2,z.`终点`as 终点站,z.`票价`as 票价3,z.`站点数`as 站数3,"
								+ "(x.`站点数`+y.`站点数`+z.`站点数`) as 总站数,(x.`票价`+y.`票价`+z.`票价`) as 总票价 "
								+ " FROM `shiyan` x,`shiyan` y,`shiyan` z "
								+ "where x.起点='"
								+ (String) jt1.getText()
								+ "'and x.终点=y.起点"
								+ " and y.终点=z.起点 and z.终点='"
								+ (String) jt2.getText()
								+ "'"
								+ "and x.`乘坐路线`!=y.`乘坐路线`"
								+ "and y.`乘坐路线`!=z.`乘坐路线`"
								+ "order by 总票价,总站数";

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
						Object[][] info = new Object[count][15];
						count = 0;
						while (rs.next()) {

							info[count][0] = rs.getString("起始公交");
							info[count][1] = rs.getString("出发站");
							info[count][2] = rs.getString("中转站1");
							info[count][3] = Integer.valueOf(rs.getInt("票价1"));
							info[count][4] = Integer.valueOf(rs.getInt("站数1"));
							info[count][5] = rs.getString("换乘公交1");
							info[count][6] = rs.getString("中转站2");
							info[count][7] = Integer.valueOf(rs.getInt("票价2"));
							info[count][8] = Integer.valueOf(rs.getInt("站数2"));
							info[count][9] = rs.getString("换乘公交2");
							info[count][10] = rs.getString("终点站");
							info[count][11] = Integer.valueOf(rs.getInt("票价3"));
							info[count][12] = Integer.valueOf(rs.getInt("站数3"));
							info[count][13] = Integer.valueOf(rs.getInt("总站数"));
							info[count][14] = Integer.valueOf(rs.getInt("总票价"));

							count++;
						}
						// 定义表头
						String[] title = { "起始公交", "出发站", "中转站1", "票价1", "站数1",
								"换乘公交1", "中转站2", "票价2", "站数2", "换乘公交2", "终点站",
								"票价3", "站数3", "总站数", "总票价" };
						// 创建JTable
						tabDemo = new JTable(info, title) {
							public boolean isCellEditable(int row, int column) {
								return false;
							}// 表格不允许被编辑
						};
						tabDemo.getTableHeader().setReorderingAllowed(false);
						tabDemo.getTableHeader().setResizingAllowed(false);

						// 显示表头
						this.jth = this.tabDemo.getTableHeader();
						// 将JTable加入到带滚动条的面板中
						this.getViewport().add(tabDemo);
					} catch (ClassNotFoundException cnfe) {
						JOptionPane.showMessageDialog(null, "数据源错误", "错误",
								JOptionPane.ERROR_MESSAGE);
					} catch (SQLException sqle) {
						JOptionPane.showMessageDialog(null, "数据操作错误", "错误",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		}

		class bus_line_JFrame extends JFrame {
			private JTextArea jt1, jt2;

			public bus_line_JFrame() {

				super("车线");
				this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				this.setLayout(null);

				jt1 = new JTextArea();
				jt2 = new JTextArea();

				jt1.setBounds(0, 0, 800, 40);
				jt2.setBounds(0, 50, 800, 40);
				jt1.setEditable(false);
				jt2.setEditable(false);// 不可编辑

				show_zhandian1 t1 = new show_zhandian1();
				t1.setBounds(0, 100, 290, 600);

				show_zhandian2 t2 = new show_zhandian2();
				t2.setBounds(300, 100, 290, 600);

				this.getContentPane().add(t1);
				this.getContentPane().add(t2);
				this.getContentPane().add(jt1);
				this.getContentPane().add(jt2);
				this.pack();
				this.setSize(700, 700);
				this.setVisible(true);
			}

			class show_zhandian1 extends JScrollPane {

				private JTableHeader jth;
				private JTable tabDemo;
				private DefaultTableModel tableModel;// 这是JTable 的子类，目的是使JTable
														// 不被别人编辑http://blog.sina.com.cn/s/blog_867ba16a01012hah.html

				public show_zhandian1() {
					show_luxian();
				}

				public void show_luxian() {

					try {
						// 获得连接
						Class.forName("com.mysql.jdbc.Driver");
						Connection conn = DriverManager
								.getConnection("jdbc:mysql://localhost/mydata?"
										+ "user=root&password=root");

						String sql1 = "SELECT 站名 as 上行区 FROM `bus_information`where 车次='"
								+ (String) jt3.getText() + "'and 方向=0";
						String sql2 = "SELECT DISTINCT 车次,发车,收车,COUNT(站名) as 站数,票价"
								+ " FROM `bus_information`"
								+ "where 方向=0 and 车次='"
								+ (String) jt3.getText() + "';";
						PreparedStatement pstm1 = conn.prepareStatement(sql1);
						PreparedStatement pstm2 = conn.prepareStatement(sql2);
						// 执行查询
						ResultSet rs1 = pstm1.executeQuery();
						ResultSet rs2 = pstm2.executeQuery();
						// 计算有多少条记录
						while (rs2.next()) {
							jt1.setText(" 本 班 车 为 " + rs2.getString(1)
									+ ", 上 行 区 收 发 班 时 间 ：" + "早 上 "
									+ rs2.getString(2) + " 发 车," + " 晚 上 "
									+ rs2.getString(3) + " 收 车 " + ",总 站 数 为："
									+ rs2.getString(4) + " ,全 程 票 价 为(元)："
									+ rs2.getString(5));
						}
						int count = 0;
						while (rs1.next()) {
							count++;
						}
						rs1 = pstm1.executeQuery();
						// 将查询获得的记录数据，转换成适合生成JTable的数据形式
						Object[][] info = new Object[count][1];
						count = 0;

						while (rs1.next()) {

							info[count][0] = rs1.getString("上行区");

							count++;
						}
						// 定义表头
						String[] title = { "上行" };
						// 创建JTable
						tabDemo = new JTable(info, title) {
							public boolean isCellEditable(int row, int column) {
								return false;
							}// 表格不允许被编辑
						};

						tabDemo.getTableHeader().setReorderingAllowed(false);
						tabDemo.getTableHeader().setResizingAllowed(false);

						// 显示表头
						this.jth = this.tabDemo.getTableHeader();
						// 将JTable加入到带滚动条的面板中
						this.getViewport().add(tabDemo);
					} catch (ClassNotFoundException cnfe) {
						JOptionPane.showMessageDialog(null, "数据源错误", "错误",
								JOptionPane.ERROR_MESSAGE);
					} catch (SQLException sqle) {
						JOptionPane.showMessageDialog(null, "数据操作错误", "错误",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}

			class show_zhandian2 extends JScrollPane {

				private JTableHeader jth;
				private JTable tabDemo;
				private DefaultTableModel tableModel;// 这是JTable 的子类，目的是使JTable
														// 不被别人编辑http://blog.sina.com.cn/s/blog_867ba16a01012hah.html

				public show_zhandian2() {
					show_luxian();
				}

				public void show_luxian() {

					try {
						// 获得连接
						Class.forName("com.mysql.jdbc.Driver");
						Connection conn = DriverManager
								.getConnection("jdbc:mysql://localhost/mydata?"
										+ "user=root&password=root");
						String sql1 = "SELECT 站名 as 下行区 FROM `bus_information`where 车次='"
								+ (String) jt3.getText() + "'and 方向=1";
						String sql2 = "SELECT DISTINCT 车次,发车,收车,COUNT(站名) as 站数,票价"
								+ " FROM `bus_information`"
								+ "where 方向=1 and 车次='"
								+ (String) jt3.getText() + "';";
						PreparedStatement pstm1 = conn.prepareStatement(sql1);
						PreparedStatement pstm2 = conn.prepareStatement(sql2);
						// 执行查询
						ResultSet rs1 = pstm1.executeQuery();
						ResultSet rs2 = pstm2.executeQuery();
						// 计算有多少条记录
						while (rs2.next()) {
							jt2.setText(" 本 班 车 为 " + rs2.getString(1)
									+ ", 下行 区 收 发 班 时 间 ：" + "早 上 "
									+ rs2.getString(2) + " 发 车," + " 晚 上 "
									+ rs2.getString(3) + " 收 车"
									+ ",总  站  数  为：" + rs2.getString(4)
									+ " ,全 程 票 价 为(元)：" + rs2.getString(5));
						}
						int count = 0;
						while (rs1.next()) {
							count++;
						}
						rs1 = pstm1.executeQuery();
						// 将查询获得的记录数据，转换成适合生成JTable的数据形式
						Object[][] info = new Object[count][1];
						count = 0;

						while (rs1.next()) {

							info[count][0] = rs1.getString("下行区");

							count++;
						}
						// 定义表头
						String[] title = { "下行" };
						// 创建JTable
						tabDemo = new JTable(info, title) {
							public boolean isCellEditable(int row, int column) {
								return false;
							}// 表格不允许被编辑
						};

						tabDemo.getTableHeader().setReorderingAllowed(false);
						tabDemo.getTableHeader().setResizingAllowed(false);

						// 显示表头
						this.jth = this.tabDemo.getTableHeader();
						// 将JTable加入到带滚动条的面板中
						this.getViewport().add(tabDemo);
					} catch (ClassNotFoundException cnfe) {
						JOptionPane.showMessageDialog(null, "数据源错误", "错误",
								JOptionPane.ERROR_MESSAGE);
					} catch (SQLException sqle) {
						JOptionPane.showMessageDialog(null, "数据操作错误", "错误",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		}

		class zhandian_line_JFrame extends JFrame {

			public zhandian_line_JFrame() {

				super("he frame");
				this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				this.setLayout(null);
				show_bus_line t1 = new show_bus_line();
				// t1.setBounds(0, 0, 100, 150);

				this.getContentPane().add(t1);
				this.pack();
				this.setSize(700, 800);
				this.setVisible(true);
			}

			class show_bus_line extends JScrollPane {

				private JTableHeader jth;
				private JTable tabDemo;
				private DefaultTableModel tableModel;// 这是JTable 的子类，目的是使JTable
														// 不被别人编辑http://blog.sina.com.cn/s/blog_867ba16a01012hah.html

				public show_bus_line() {
					this.setBounds(0, 300, 600, 200);
					;
					show_luxian();
				}

				public void show_luxian() {

					try {
						// 获得连接
						Class.forName("com.mysql.jdbc.Driver");
						Connection conn = DriverManager
								.getConnection("jdbc:mysql://localhost/mydata?"
										+ "user=root&password=root");
						String sql = "SELECT DISTINCT 车次 as 公交路线 FROM `bus_information`"
								+ " where 站名='" + (String) jt4.getText() + "'";
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
						Object[][] info = new Object[count][1];
						count = 0;
						// System.out.println("xq");
						while (rs.next()) {
							// System.out.println("xq");
							info[count][0] = rs.getString("公交路线");
							count++;
						}
						// 定义表头
						String[] title = { "公交路线" };
						// 创建JTable
						tabDemo = new JTable(info, title) {
							public boolean isCellEditable(int row, int column) {
								return false;
							}// 表格不允许被编辑
						};
						tabDemo.getTableHeader().setReorderingAllowed(false);
						tabDemo.getTableHeader().setResizingAllowed(false);

						// 显示表头
						this.jth = this.tabDemo.getTableHeader();
						// 将JTable加入到带滚动条的面板中
						this.getViewport().add(tabDemo);
					} catch (ClassNotFoundException cnfe) {
						JOptionPane.showMessageDialog(null, "数据源错误", "错误",
								JOptionPane.ERROR_MESSAGE);
					} catch (SQLException sqle) {
						JOptionPane.showMessageDialog(null, "数据操作错误", "错误",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		}

		private class ButtonListener implements ActionListener {

			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == b1) {
					new line_JFrame();

				}
				if (e.getSource() == b2) {
					new bus_line_JFrame();

				}
				if (e.getSource() == b3) {

					new zhandian_line_JFrame();
				}
				if (e.getSource() == b4) {
					jt1.setText("请输入您的位置");
					jt2.setText("请输入您想去的地方");
					jt3.setText("请输入您想查询的车号");
					jt4.setText("请输入您想查询的站点");
				}
				if (e.getSource() == b5) {
					new logframe();
					jframe.dispose();
				}
				if (e.getSource() == b6) {
					jframe.dispose();
				}
			}
		}

	}
}