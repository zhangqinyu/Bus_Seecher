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
	// ���췽��
	public Test() {
		// �����������ԵĶ���
		super("JTable���ݰ�ʾ��");
		this.setSize(600,600);
		this.setLayout(null);
		this.setLocation(100, 50);
		// �������
		this.scpDemo = new JScrollPane();
		this.scpDemo.setBounds(0, 0,590, 600);
		
		// ����ťע�����
		show_luxian();
		// ��������뵽������
		add(this.scpDemo);

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
			String sql ="SELECT x.`����·��`as ��ʼ����,x.`���`as ����վ, x.`�յ�`as ��תվ1,x.`Ʊ��`as Ʊ��1,x.`վ����`as վ��1,y.`����·��`as ���˹���1,y.`�յ�`as ��תվ2,y.`Ʊ��`as Ʊ��2,y.`վ����`as վ��2, z.`����·��`as ���˹���2,z.`�յ�`as �յ�վ,z.`Ʊ��`as Ʊ��3,z.`վ����`as վ��3,(x.`վ����`+y.`վ����`+z.`վ����`) as ��վ��,(x.`Ʊ��`+y.`Ʊ��`+z.`Ʊ��`) as ��Ʊ�� FROM `bustest` x,`bustest` y,`bustest` z where x.���='s1'and x.�յ�=y.��� and y.�յ�=z.���and z.�յ�='s12'and x.`����·��`!=y.`����·��`and y.`����·��`!=z.`����·��`";
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
			Object[][] info = new Object[count][115];
			count = 0;
			while (rs.next()) {
				info[count][0] = Integer.valueOf(rs.getInt("��ʼ����"));
				info[count][1] = rs.getString("����վ");
				info[count][2] = rs.getString("��תվ1");
				info[count][3] = Integer.valueOf(rs.getInt("Ʊ��1"));
				info[count][4] = Integer.valueOf(rs.getInt("վ����1"));
				info[count][5] = Integer.valueOf(rs.getInt("���˹���1"));
				info[count][6] = rs.getString("��תվ2");
				info[count][7] = Integer.valueOf(rs.getInt("Ʊ��2"));
				info[count][8] = Integer.valueOf(rs.getInt("վ����2"));
				info[count][9] = Integer.valueOf(rs.getInt("���˹���2"));
				info[count][10] = rs.getString("�յ�վ");
				info[count][11] = Integer.valueOf(rs.getInt("Ʊ��3"));
				info[count][12] = Integer.valueOf(rs.getInt("վ����3"));
				info[count][12] = Integer.valueOf(rs.getInt("��վ��"));
				info[count][14] = Integer.valueOf(rs.getInt("��Ʊ��"));
				count++;
			}
			// �����ͷ
			String[] title = { "��ʼ����", "����վ","��תվ1" ,"Ʊ��1","վ����1","���˹���1","��תվ2","Ʊ��2","վ����2","���˹���2","�յ�վ","Ʊ��3","վ����3","��վ��","��Ʊ��"};
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