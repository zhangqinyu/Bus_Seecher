package ��ѯ����;

import javax.swing.*;
import javax.swing.table.JTableHeader;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Test extends JFrame {
	// �������
	private JScrollPane scpDemo;
	private JTableHeader jth;
	private JTable tabDemo;
	private JButton btnShow;

	// ���췽��
	public Test() {
		// �����������ԵĶ���
		super("JTable���ݰ�ʾ��");
		this.setSize(330, 400);
		this.setLayout(null);
		this.setLocation(100, 50);
		// �������
		this.scpDemo = new JScrollPane();
		this.scpDemo.setBounds(10, 50, 300, 270);
		this.btnShow = new JButton("��ʾ����");
		this.btnShow.setBounds(10, 10, 300, 30);
		// ����ťע�����
		show_luxian();
		// ��������뵽������
		add(this.scpDemo);
		add(this.btnShow);
		// ��ʾ����
		this.setVisible(true);
	}

	// �����ťʱ���¼�����
	public void show_luxian() {
		// ��������������Դ����ʾ���ݵľ��崦��������ע����
		try {
			// �������
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost/mydata?"
							+ "user=root&password=root");
			// ������ѯ����
			String sql = "select * from bustest ";
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
				info[count][0] = Integer.valueOf(rs.getInt("����·��"));
				info[count][1] = rs.getString("���");
				info[count][2] = rs.getString("�յ�");
				info[count][3] = Integer.valueOf(rs.getInt("վ����"));
				info[count][4] = Integer.valueOf(rs.getInt("Ʊ��"));
				count++;
			}
			// �����ͷ
			String[] title = { "����·��", "���", "�յ�", "վ����","Ʊ��" };
			// ����JTable
			this.tabDemo = new JTable(info, title);
			// ��ʾ��ͷ
			this.jth = this.tabDemo.getTableHeader();
			// ��JTable���뵽���������������
			this.scpDemo.getViewport().add(tabDemo);
		} catch (ClassNotFoundException cnfe) {
			JOptionPane.showMessageDialog(null, "����Դ����", "����",
					JOptionPane.ERROR_MESSAGE);
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "���ݲ�������", "����",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	
}