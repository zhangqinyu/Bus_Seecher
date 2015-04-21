package ��¼����;
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
		private JTextField jt5;// ����������ѡ�𰸣�
		private JLabel jl1, jl2, jl3, jl4, jl5;
		private int a = 0;
		private boolean bl = true;// �ж�ʹ�����ַ�����

		private JLabel image_label;

		private static final long serialVersionUID = 1L;
		private static final String TIP = "QQ����/�ֻ�/����";

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
			jt1.setText("����������λ��");
			jt2.setText("����������ȥ�ĵط�");
			jt3.setText("�����������ѯ�ĳ���");
			jt4.setText("�����������ѯ��վ��");
            jt1.addFocusListener(new FocusHandler());
            jt2.addFocusListener(new FocusHandler());
            jt3.addFocusListener(new FocusHandler());
            jt4.addFocusListener(new FocusHandler());
            
			b1 = new JButton("��ѯ1");
			b2 = new JButton("��ѯ2");
			b3 = new JButton("��ѯ3");
			b4 = new JButton("����");
			b5 = new JButton("����");
			b6 = new JButton("�˳�");

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
			jl1 = new JLabel("��");
			jl2 = new JLabel("==>");
			jl1.setBounds(10, 20, 30, 30);
			jl2.setBounds(245, 20, 30, 30);

			jl3 = new JLabel("����");
			jl4 = new JLabel("վ��");
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
			setOpaque(false); // ����Ϊ͸��������
			
			try {

				new tishi(jt1, "select DISTINCT վ�� from bus_information ");
				new tishi(jt2, "select DISTINCT վ�� from bus_information ");
				new tishi(jt3, "select DISTINCT ���� from bus_information");
				new tishi(jt4, "select DISTINCT վ�� from  bus_information "); // ����Ϣ�����������У�
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		private class FocusHandler extends FocusAdapter{
			public void focusGained(FocusEvent e){
				if(e.getSource()==jt1){
					if("����������λ��".equals(jt1.getText()))
						jt1.setText("");
			}
				if(e.getSource()==jt2){
					if("����������ȥ�ĵط�".equals(jt2.getText()))
						jt2.setText("");
			}
				if(e.getSource()==jt3){
					if("�����������ѯ�ĳ���".equals(jt3.getText()))
						jt3.setText("");
			}
				if(e.getSource()==jt4){
					if("�����������ѯ��վ��".equals(jt4.getText()))
						jt4.setText("");
			}
				}
			
			public void focusLost(FocusEvent e){
				if(e.getSource()==jt1){
					if("".equals(jt1.getText())){
						jt1.setText("����������λ��");
					}
				}
				if(e.getSource()==jt2){
					if("".equals(jt2.getText())){
						jt2.setText("����������ȥ�ĵط�");
					}
				}
				if(e.getSource()==jt3){
					if("".equals(jt3.getText())){
						jt3.setText("�����������ѯ�ĳ���");
					}
				}
				if(e.getSource()==jt4){
					if("".equals(jt4.getText())){
						jt4.setText("�����������ѯ��վ��");
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

				// �����ťʱ���¼�����
				public void show_luxian() {
					// ��������������Դ����ʾ���ݵľ��崦��������ע����
					try {
						// �������
						Class.forName("com.mysql.jdbc.Driver");
						Connection conn = DriverManager
								.getConnection("jdbc:mysql://localhost/mydata?"
										+ "user=root&password=root");
						String sql = "SELECT ����·�� ,��� ,�յ�,վ����,Ʊ�� from shiyan "
								+ "where ���='" + (String) jt1.getText() + "' "
								+ "and �յ�='" + (String) jt2.getText() + "'";
						PreparedStatement pstm = conn.prepareStatement(sql);
						// ִ�в�ѯ
						ResultSet rs = pstm.executeQuery();
						// �����ж�������¼
						int count = 0;
						while (rs.next()) {
							count++;

						}

						rs = pstm.executeQuery();
						// ����ѯ��õļ�¼���ݣ�ת�����ʺ�����JTable��������ʽ
						Object[][] info = new Object[count][5];

						count = 0;
						while (rs.next()) {
							info[count][0] = rs.getString("����·��");
							info[count][1] = rs.getString("���");
							info[count][2] = rs.getString("�յ�");
							info[count][3] = Integer.valueOf(rs.getInt("վ����"));
							info[count][4] = Integer.valueOf(rs.getInt("Ʊ��"));
							count++;
						}
						// �����ͷ
						String[] title = { "����·��", "���", "�յ�", "վ����", "Ʊ��" };
						// ����JTable
						this.tabDemo = new JTable(info, title) {
							public boolean isCellEditable(int row, int column) {
								return false;
							}// ��������༭
						};
						// �����еĿ�Ⱥ�λ�ò��ܸı䣻
						tabDemo.getTableHeader().setReorderingAllowed(false);
						tabDemo.getTableHeader().setResizingAllowed(false);
						// ��ʾ��ͷ
						this.jth = this.tabDemo.getTableHeader();
						// ��JTable���뵽���������������
						this.getViewport().add(tabDemo);

					} catch (ClassNotFoundException cnfe) {
						JOptionPane.showMessageDialog(null, "����Դ����", "����",
								JOptionPane.ERROR_MESSAGE);
					} catch (SQLException sqle) {
						JOptionPane.showMessageDialog(null, "���ݲ�������", "����",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}

			class Testbus_search_two_line extends JScrollPane {
				// �������
				private JTableHeader jth;
				private JTable tabDemo;

				// ���췽��
				public Testbus_search_two_line() {
					// �����������ԵĶ���
					// super("JTable���ݰ�ʾ��");
					this.setBounds(0, 200, 900, 150);
					;
					show_luxian();
				}

				// �����ťʱ���¼�����
				public void show_luxian() {
					// ��������������Դ����ʾ���ݵľ��崦��������ע����
					try {
						// �������
						Class.forName("com.mysql.jdbc.Driver");
						Connection conn = DriverManager
								.getConnection("jdbc:mysql://localhost/mydata?"
										+ "user=root&password=root");
						// ������ѯ����
						String sql = "SELECT x.`����·��`as ��ʼ����,x.`���`as ����վ, x.`�յ�`as ��תվ,x.`Ʊ��`as Ʊ��1,x.`վ����`as վ����1,"
								+ "y.`����·��`as ���˹���,y.`�յ�`as �յ�վ,y.`Ʊ��`as Ʊ��2,y.`վ����`as վ����2,	"
								+ "(x.`վ����`+y.`վ����`)as ��վ��,(x.`Ʊ��`+y.`Ʊ��`)as ��Ʊ��"
								+ " FROM `shiyan` x,`shiyan` y "
								+ "where x.���='"
								+ (String) jt1.getText()
								+ "'"
								+ "and x.�յ�=y.��� "
								+ "and y.�յ�='"
								+ (String) jt2.getText()
								+ "'"
								+ "and x.`����·��`!=y.`����·��`"
								+ "order by ��Ʊ��,��վ��";
						PreparedStatement pstm = conn.prepareStatement(sql);
						// ִ�в�ѯ
						ResultSet rs = pstm.executeQuery();
						// �����ж�������¼
						int count = 0;
						while (rs.next()) {
							count++;
						}
						rs = pstm.executeQuery();
						// ����ѯ��õļ�¼���ݣ�ת�����ʺ�����JTable��������ʽ
						Object[][] info = new Object[count][11];
						count = 0;
						while (rs.next()) {
							info[count][0] = rs.getString("��ʼ����");
							info[count][1] = rs.getString("����վ");
							info[count][2] = rs.getString("��תվ");
							info[count][3] = Integer.valueOf(rs.getInt("Ʊ��1"));
							info[count][4] = Integer.valueOf(rs.getInt("վ����1"));
							info[count][5] = rs.getString("���˹���");
							info[count][6] = rs.getString("�յ�վ");
							info[count][7] = Integer.valueOf(rs.getInt("Ʊ��2"));
							info[count][8] = Integer.valueOf(rs.getInt("վ����2"));
							info[count][9] = Integer.valueOf(rs.getInt("��վ��"));
							info[count][10] = Integer.valueOf(rs.getInt("��Ʊ��"));
							count++;
						}
						// �����ͷ
						String[] title = { "��ʼ����", "����վ", "��תվ", "Ʊ��1", "վ����1",
								"���˹���", "�յ�վ", "Ʊ��2", "վ����2", "��վ��", "��Ʊ��" };
						// ����JTable
						this.tabDemo = new JTable(info, title) {
							public boolean isCellEditable(int row, int column) {
								return false;
							}// ��������༭
						};
						tabDemo.getTableHeader().setReorderingAllowed(false);
						tabDemo.getTableHeader().setResizingAllowed(false);
						// ��ʾ��ͷ
						this.jth = this.tabDemo.getTableHeader();
						// ��JTable���뵽���������������
						this.getViewport().add(tabDemo);

					} catch (ClassNotFoundException cnfe) {
						JOptionPane.showMessageDialog(null, "����Դ����", "����",
								JOptionPane.ERROR_MESSAGE);
					} catch (SQLException sqle) {
						JOptionPane.showMessageDialog(null, "���ݲ�������", "����",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}

			class Testbus_search_three_line extends JScrollPane {

				private JTableHeader jth;
				private JTable tabDemo;
				private DefaultTableModel tableModel;// ����JTable �����࣬Ŀ����ʹJTable
														// �������˱༭http://blog.sina.com.cn/s/blog_867ba16a01012hah.html

				public Testbus_search_three_line() {
					this.setBounds(0, 300, 900, 200);
					;
					show_luxian();
				}

				public void show_luxian() {

					try {
						// �������
						Class.forName("com.mysql.jdbc.Driver");
						Connection conn = DriverManager
								.getConnection("jdbc:mysql://localhost/mydata?"
										+ "user=root&password=root");

						String sql = "SELECT x.`����·��`as ��ʼ����,x.`���`as ����վ, x.`�յ�`as ��תվ1,x.`Ʊ��`as Ʊ��1,x.`վ����`as վ��1,"
								+ "y.`����·��`as ���˹���1,y.`�յ�`as ��תվ2,y.`Ʊ��`as Ʊ��2,y.`վ����`as վ��2,"
								+ " z.`����·��`as ���˹���2,z.`�յ�`as �յ�վ,z.`Ʊ��`as Ʊ��3,z.`վ����`as վ��3,"
								+ "(x.`վ����`+y.`վ����`+z.`վ����`) as ��վ��,(x.`Ʊ��`+y.`Ʊ��`+z.`Ʊ��`) as ��Ʊ�� "
								+ " FROM `shiyan` x,`shiyan` y,`shiyan` z "
								+ "where x.���='"
								+ (String) jt1.getText()
								+ "'and x.�յ�=y.���"
								+ " and y.�յ�=z.��� and z.�յ�='"
								+ (String) jt2.getText()
								+ "'"
								+ "and x.`����·��`!=y.`����·��`"
								+ "and y.`����·��`!=z.`����·��`"
								+ "order by ��Ʊ��,��վ��";

						PreparedStatement pstm = conn.prepareStatement(sql);
						// ִ�в�ѯ
						ResultSet rs = pstm.executeQuery();
						// �����ж�������¼

						int count = 0;
						while (rs.next()) {
							count++;
						}
						rs = pstm.executeQuery();
						// ����ѯ��õļ�¼���ݣ�ת�����ʺ�����JTable��������ʽ
						Object[][] info = new Object[count][15];
						count = 0;
						while (rs.next()) {

							info[count][0] = rs.getString("��ʼ����");
							info[count][1] = rs.getString("����վ");
							info[count][2] = rs.getString("��תվ1");
							info[count][3] = Integer.valueOf(rs.getInt("Ʊ��1"));
							info[count][4] = Integer.valueOf(rs.getInt("վ��1"));
							info[count][5] = rs.getString("���˹���1");
							info[count][6] = rs.getString("��תվ2");
							info[count][7] = Integer.valueOf(rs.getInt("Ʊ��2"));
							info[count][8] = Integer.valueOf(rs.getInt("վ��2"));
							info[count][9] = rs.getString("���˹���2");
							info[count][10] = rs.getString("�յ�վ");
							info[count][11] = Integer.valueOf(rs.getInt("Ʊ��3"));
							info[count][12] = Integer.valueOf(rs.getInt("վ��3"));
							info[count][13] = Integer.valueOf(rs.getInt("��վ��"));
							info[count][14] = Integer.valueOf(rs.getInt("��Ʊ��"));

							count++;
						}
						// �����ͷ
						String[] title = { "��ʼ����", "����վ", "��תվ1", "Ʊ��1", "վ��1",
								"���˹���1", "��תվ2", "Ʊ��2", "վ��2", "���˹���2", "�յ�վ",
								"Ʊ��3", "վ��3", "��վ��", "��Ʊ��" };
						// ����JTable
						tabDemo = new JTable(info, title) {
							public boolean isCellEditable(int row, int column) {
								return false;
							}// ��������༭
						};
						tabDemo.getTableHeader().setReorderingAllowed(false);
						tabDemo.getTableHeader().setResizingAllowed(false);

						// ��ʾ��ͷ
						this.jth = this.tabDemo.getTableHeader();
						// ��JTable���뵽���������������
						this.getViewport().add(tabDemo);
					} catch (ClassNotFoundException cnfe) {
						JOptionPane.showMessageDialog(null, "����Դ����", "����",
								JOptionPane.ERROR_MESSAGE);
					} catch (SQLException sqle) {
						JOptionPane.showMessageDialog(null, "���ݲ�������", "����",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		}

		class bus_line_JFrame extends JFrame {
			private JTextArea jt1, jt2;

			public bus_line_JFrame() {

				super("����");
				this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				this.setLayout(null);

				jt1 = new JTextArea();
				jt2 = new JTextArea();

				jt1.setBounds(0, 0, 800, 40);
				jt2.setBounds(0, 50, 800, 40);
				jt1.setEditable(false);
				jt2.setEditable(false);// ���ɱ༭

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
				private DefaultTableModel tableModel;// ����JTable �����࣬Ŀ����ʹJTable
														// �������˱༭http://blog.sina.com.cn/s/blog_867ba16a01012hah.html

				public show_zhandian1() {
					show_luxian();
				}

				public void show_luxian() {

					try {
						// �������
						Class.forName("com.mysql.jdbc.Driver");
						Connection conn = DriverManager
								.getConnection("jdbc:mysql://localhost/mydata?"
										+ "user=root&password=root");

						String sql1 = "SELECT վ�� as ������ FROM `bus_information`where ����='"
								+ (String) jt3.getText() + "'and ����=0";
						String sql2 = "SELECT DISTINCT ����,����,�ճ�,COUNT(վ��) as վ��,Ʊ��"
								+ " FROM `bus_information`"
								+ "where ����=0 and ����='"
								+ (String) jt3.getText() + "';";
						PreparedStatement pstm1 = conn.prepareStatement(sql1);
						PreparedStatement pstm2 = conn.prepareStatement(sql2);
						// ִ�в�ѯ
						ResultSet rs1 = pstm1.executeQuery();
						ResultSet rs2 = pstm2.executeQuery();
						// �����ж�������¼
						while (rs2.next()) {
							jt1.setText(" �� �� �� Ϊ " + rs2.getString(1)
									+ ", �� �� �� �� �� �� ʱ �� ��" + "�� �� "
									+ rs2.getString(2) + " �� ��," + " �� �� "
									+ rs2.getString(3) + " �� �� " + ",�� վ �� Ϊ��"
									+ rs2.getString(4) + " ,ȫ �� Ʊ �� Ϊ(Ԫ)��"
									+ rs2.getString(5));
						}
						int count = 0;
						while (rs1.next()) {
							count++;
						}
						rs1 = pstm1.executeQuery();
						// ����ѯ��õļ�¼���ݣ�ת�����ʺ�����JTable��������ʽ
						Object[][] info = new Object[count][1];
						count = 0;

						while (rs1.next()) {

							info[count][0] = rs1.getString("������");

							count++;
						}
						// �����ͷ
						String[] title = { "����" };
						// ����JTable
						tabDemo = new JTable(info, title) {
							public boolean isCellEditable(int row, int column) {
								return false;
							}// ��������༭
						};

						tabDemo.getTableHeader().setReorderingAllowed(false);
						tabDemo.getTableHeader().setResizingAllowed(false);

						// ��ʾ��ͷ
						this.jth = this.tabDemo.getTableHeader();
						// ��JTable���뵽���������������
						this.getViewport().add(tabDemo);
					} catch (ClassNotFoundException cnfe) {
						JOptionPane.showMessageDialog(null, "����Դ����", "����",
								JOptionPane.ERROR_MESSAGE);
					} catch (SQLException sqle) {
						JOptionPane.showMessageDialog(null, "���ݲ�������", "����",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}

			class show_zhandian2 extends JScrollPane {

				private JTableHeader jth;
				private JTable tabDemo;
				private DefaultTableModel tableModel;// ����JTable �����࣬Ŀ����ʹJTable
														// �������˱༭http://blog.sina.com.cn/s/blog_867ba16a01012hah.html

				public show_zhandian2() {
					show_luxian();
				}

				public void show_luxian() {

					try {
						// �������
						Class.forName("com.mysql.jdbc.Driver");
						Connection conn = DriverManager
								.getConnection("jdbc:mysql://localhost/mydata?"
										+ "user=root&password=root");
						String sql1 = "SELECT վ�� as ������ FROM `bus_information`where ����='"
								+ (String) jt3.getText() + "'and ����=1";
						String sql2 = "SELECT DISTINCT ����,����,�ճ�,COUNT(վ��) as վ��,Ʊ��"
								+ " FROM `bus_information`"
								+ "where ����=1 and ����='"
								+ (String) jt3.getText() + "';";
						PreparedStatement pstm1 = conn.prepareStatement(sql1);
						PreparedStatement pstm2 = conn.prepareStatement(sql2);
						// ִ�в�ѯ
						ResultSet rs1 = pstm1.executeQuery();
						ResultSet rs2 = pstm2.executeQuery();
						// �����ж�������¼
						while (rs2.next()) {
							jt2.setText(" �� �� �� Ϊ " + rs2.getString(1)
									+ ", ���� �� �� �� �� ʱ �� ��" + "�� �� "
									+ rs2.getString(2) + " �� ��," + " �� �� "
									+ rs2.getString(3) + " �� ��"
									+ ",��  վ  ��  Ϊ��" + rs2.getString(4)
									+ " ,ȫ �� Ʊ �� Ϊ(Ԫ)��" + rs2.getString(5));
						}
						int count = 0;
						while (rs1.next()) {
							count++;
						}
						rs1 = pstm1.executeQuery();
						// ����ѯ��õļ�¼���ݣ�ת�����ʺ�����JTable��������ʽ
						Object[][] info = new Object[count][1];
						count = 0;

						while (rs1.next()) {

							info[count][0] = rs1.getString("������");

							count++;
						}
						// �����ͷ
						String[] title = { "����" };
						// ����JTable
						tabDemo = new JTable(info, title) {
							public boolean isCellEditable(int row, int column) {
								return false;
							}// ��������༭
						};

						tabDemo.getTableHeader().setReorderingAllowed(false);
						tabDemo.getTableHeader().setResizingAllowed(false);

						// ��ʾ��ͷ
						this.jth = this.tabDemo.getTableHeader();
						// ��JTable���뵽���������������
						this.getViewport().add(tabDemo);
					} catch (ClassNotFoundException cnfe) {
						JOptionPane.showMessageDialog(null, "����Դ����", "����",
								JOptionPane.ERROR_MESSAGE);
					} catch (SQLException sqle) {
						JOptionPane.showMessageDialog(null, "���ݲ�������", "����",
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
				private DefaultTableModel tableModel;// ����JTable �����࣬Ŀ����ʹJTable
														// �������˱༭http://blog.sina.com.cn/s/blog_867ba16a01012hah.html

				public show_bus_line() {
					this.setBounds(0, 300, 600, 200);
					;
					show_luxian();
				}

				public void show_luxian() {

					try {
						// �������
						Class.forName("com.mysql.jdbc.Driver");
						Connection conn = DriverManager
								.getConnection("jdbc:mysql://localhost/mydata?"
										+ "user=root&password=root");
						String sql = "SELECT DISTINCT ���� as ����·�� FROM `bus_information`"
								+ " where վ��='" + (String) jt4.getText() + "'";
						PreparedStatement pstm = conn.prepareStatement(sql);
						// ִ�в�ѯ
						ResultSet rs = pstm.executeQuery();
						// �����ж�������¼

						int count = 0;
						while (rs.next()) {
							count++;
						}
						rs = pstm.executeQuery();
						// ����ѯ��õļ�¼���ݣ�ת�����ʺ�����JTable��������ʽ
						Object[][] info = new Object[count][1];
						count = 0;
						// System.out.println("xq");
						while (rs.next()) {
							// System.out.println("xq");
							info[count][0] = rs.getString("����·��");
							count++;
						}
						// �����ͷ
						String[] title = { "����·��" };
						// ����JTable
						tabDemo = new JTable(info, title) {
							public boolean isCellEditable(int row, int column) {
								return false;
							}// ��������༭
						};
						tabDemo.getTableHeader().setReorderingAllowed(false);
						tabDemo.getTableHeader().setResizingAllowed(false);

						// ��ʾ��ͷ
						this.jth = this.tabDemo.getTableHeader();
						// ��JTable���뵽���������������
						this.getViewport().add(tabDemo);
					} catch (ClassNotFoundException cnfe) {
						JOptionPane.showMessageDialog(null, "����Դ����", "����",
								JOptionPane.ERROR_MESSAGE);
					} catch (SQLException sqle) {
						JOptionPane.showMessageDialog(null, "���ݲ�������", "����",
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
					jt1.setText("����������λ��");
					jt2.setText("����������ȥ�ĵط�");
					jt3.setText("�����������ѯ�ĳ���");
					jt4.setText("�����������ѯ��վ��");
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