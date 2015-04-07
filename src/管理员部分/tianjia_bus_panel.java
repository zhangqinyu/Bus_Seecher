package 管理员部分;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class tianjia_bus_panel extends JPanel {
	private JButton b1, b2, b3, b4;
	private JTextField jt1, jt2, jt3, jt4, jt5, jt6, jt7, jt8, jt9;
	private JTextArea ja1, ja2, ja3;
	private JLabel jl1, jl2, jl3, jl4, jl5, jl6, jl7;

	private Connection conn = null;
	private Statement stmt = null;
	private ResultSet rs = null;
    
	public tianjia_bus_panel() {
		setLayout(null);
		jl1 = new JLabel(
				"       车次                              票价                                 IC卡                             学生卡                               老年卡");
		jl1.setBounds(0, 1, 600, 15);

		jt1 = new JTextField(10);
		jt2 = new JTextField(10);
		jt3 = new JTextField(10);
		jt4 = new JTextField(10);
		jt5 = new JTextField(10);

		jt1.setBounds(10, 17, 50, 30);
		jt2.setBounds(125, 17, 50, 30);
		jt3.setBounds(250, 17, 50, 30);
		jt4.setBounds(367, 17, 50, 30);
		jt5.setBounds(500, 17, 50, 30);

		jl2 = new JLabel("上行区：发车时间");
		jl2.setBounds(10, 80, 150, 15);
		jt6 = new JTextField(10);
		jt6.setBounds(120, 80, 50, 30);
		jl3 = new JLabel("收车时间");
		jl3.setBounds(180, 80, 100, 15);
		
		jt7 = new JTextField(10);
		jt7.setBounds(250, 80, 50, 30);

		jl4 = new JLabel("下行区：发车时间");
		jl4.setBounds(10, 120, 150, 15);
		jt8 = new JTextField(10);
		jt8.setBounds(120, 120, 50, 30);
		jl5 = new JLabel("收车时间");
		jl5.setBounds(180, 120, 100, 15);
		;
		jt9 = new JTextField(10);
		jt9.setBounds(250, 120, 50, 30);

		b1 = new JButton("提交");
		b2 = new JButton("清空");
		b3 = new JButton("返回");
		b4 = new JButton("退出");

		b1.setBounds(20, 500, 85, 40);
		b2.setBounds(140, 500, 85, 40);
		b3.setBounds(260, 500, 85, 40);
		b4.setBounds(380, 500, 85, 40);

		b1.addActionListener(new ButtonListener());
		b2.addActionListener(new ButtonListener());
		b3.addActionListener(new ButtonListener());
		b4.addActionListener(new ButtonListener());

		ja1 = new JTextArea(
				"提示：一，车次中若含有英文，请用大写；二，IC卡，学生卡，老年卡均用：1表示可用，0表示不可用；"
						+ "三，发收车均使用'6:10'的格式；四，填写站名时，不同的站名之间用“；”隔开");
		ja1.setBounds(320, 70, 260, 100);
		ja1.setLineWrap(true);// 设置自动换行；
		ja1.setEditable(false);//其中的值不可改
        ja1.setBorder (BorderFactory.createLineBorder(Color.gray,1));//设置边框
		
		ja2 = new JTextArea();
		ja2.setBounds(50, 180, 500, 130);
		ja2.setLineWrap(true);// 设置自动换行；
        ja2.setBorder (BorderFactory.createLineBorder(Color.gray,1));
		
		ja3 = new JTextArea();
		ja3.setBounds(50, 340, 500, 130);
		ja3.setLineWrap(true);// 设置自动换行；
        ja3.setBorder (BorderFactory.createLineBorder(Color.gray,1));
		
		jl6 = new JLabel("上行区");
		jl6.setBounds(10, 180, 80, 100);

		jl7 = new JLabel("下行区");
		jl7.setBounds(10, 340, 80, 100);

		add(jl1);
		add(jl2);
		add(jl3);
		add(jl4);
		add(jl5);
		add(jl6);
		add(jl7);
		
		add(jt1);
		add(jt2);
		add(jt3);
		add(jt4);
		add(jt5);
		add(jt6);
		add(jt7);
		add(jt8);
		add(jt9);

		add(b1);
		add(b2);
		add(b3);
		add(b4);

		add(ja1);
		add(ja2);
		add(ja3);
		
		setBounds(0, 0, 600, 600);
	}

	private class ButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == b1) {
				new insertTxtFile(ja2.getText(), ja2);
				new insertTxtFile(ja3.getText(), ja3);
			}
			if (e.getSource() == b2) {

			}
			if (e.getSource() == b3) {
				
			}
			if (e.getSource() == b4) {
				System.exit(0);
			}

		}
	}



public class insertTxtFile {
	public insertTxtFile(String st, JTextArea jt) {
		BufferedWriter bfw;
		try {
			// bfw = new BufferedWriter(new
			// FileWriter("C://Users//18580_000//Desktop//Student.txt",true));
			bfw = new BufferedWriter(new FileWriter(
					"C://Users//18580_000//Desktop//管理车实验.txt"));
			// 加true是为了不覆盖原本的值；
			// bfw.newLine() ; //写入一个换行符
			// string value = "192.168.128.33";
			String[] names = st.split("\\；"); // 分割字符；其中的“；”必须为中文状态下的；而不是;切记
			for (int i = 0; i < names.length; i++) {
				bfw.write(names[i]); // 写入
				bfw.newLine();
			}
			bfw.flush();
			bfw.close();
			if (jt == ja2)
				new readTxtFile("C://Users//18580_000//Desktop//管理车实验.txt",
						0);
			if (jt == ja3)
				new readTxtFile("C://Users//18580_000//Desktop//管理车实验.txt",
						1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

public class readTxtFile {
	public readTxtFile(String filePath, int fangxiang) {
		try {
			// fangxiang定义上行区还是下行区；0表示上行区，1表示下行区
			// filePath="C://Users//18580_000//Desktop//Student.txt";
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager
					.getConnection("jdbc:mysql://localhost/mydata?"
							+ "user=root&password=root");
			stmt = conn.createStatement();
			String encoding = "GBK";
			File file = new File(filePath);// filePath =
											// "C://Users//18580_000//Desktop//Student.txt";
			if (file.isFile() && file.exists()) { // 判断文件是否存在
				InputStreamReader read = new InputStreamReader(
						new FileInputStream(file), encoding);// 考虑到编码格式
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt = null;
				int count = 1;
				if (fangxiang == 0) {
					while ((lineTxt = bufferedReader.readLine()) != null) {
						String sql = "INSERT INTO 管理车实验 " + "VALUES ('"
								+ jt1.getText() + "'," + "'" + lineTxt
								+ "'," + "" + count + "," + "" + fangxiang
								+ "," + "'" + jt6.getText() + "'," + "'"
								+ jt7.getText() + "'," + "'"
								+ jt2.getText() + "')";
						stmt.executeUpdate(sql);
						count++;
						// rs =
						// stmt.executeQuery("select * from  customer ");
						System.out.println(lineTxt);
					}
					count = 1;
				}
				if (fangxiang == 1) {
					while ((lineTxt = bufferedReader.readLine()) != null) {
						String sql = "INSERT INTO 管理车实验 " + "VALUES ('"
								+ jt1.getText() + "'," + "'" + lineTxt
								+ "'," + "" + count + "," + "" + fangxiang
								+ "," + "'" + jt8.getText() + "'," + "'"
								+ jt9.getText() + "'," + "'"
								+ jt2.getText() + "')";
						stmt.executeUpdate(sql);
						count++;
						// rs =
						// stmt.executeQuery("select * from  customer ");
						System.out.println(lineTxt);
					}
					count = 1;
				}
				read.close();
			} else {
				System.out.println("找不到指定的文件");
			}
		} catch (Exception e) {
			System.out.println("读取文件内容出错");
			e.printStackTrace();
		}
	}
}
}
