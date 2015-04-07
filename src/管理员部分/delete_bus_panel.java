package ����Ա����;

import javax.swing.*;

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

public class delete_bus_panel extends JPanel {
	private JRadioButton jr1, jr2, jr3;
	private JLabel jl1, jl2, jl3, jl4;
	private JTextField jt1, jt2, jt3, jt4, jt5, jt6, jt7, jt8, jt9;

	private JTextArea ja1, ja2, ja3;
	private JButton jb1, jb2;
	private int count = 0;// �����ж������Щ���֣�

	public delete_bus_panel() {
		setLayout(null);
		jr1 = new JRadioButton("ɾ������", true);
		jr1.setBounds(0, 0, 100, 50);
		jr2 = new JRadioButton("ɾ��վ��");
		jr2.setBounds(0, 40, 100, 50);
		jr3 = new JRadioButton("�޸���Ϣ");
		jr3.setBounds(0, 80, 100, 50);

		jr1.addActionListener(new RadioButtonListener());
		jr2.addActionListener(new RadioButtonListener());
		jr3.addActionListener(new RadioButtonListener());

		ButtonGroup group = new ButtonGroup();
		group.add(jr1);
		group.add(jr2);
		group.add(jr3);// �����Ŀ����Ϊ��ֻ��ѡһ����
		add(jr1);
		add(jr2);
		add(jr3);
		setBounds(0, 0, 600, 600);
	}
   private void delete_zujian(int count){
	  
	   switch (count) {
		case 1:
			remove(jl1);
			remove(jt1);
			remove(jb2);
			break;
		case 2:
			remove(jl1);
			remove(jl2);
			remove(jl3);
			remove(jl4);
			remove(jt1);
			remove(jt2);
			remove(ja1);
			remove(ja2);
			remove(jb1);
			remove(jb2);
			break;
		case 3:
			remove(jl1);
			remove(jl2);
			remove(jl3);
			remove(jl4);
			remove(jt1);
			remove(jt2);
			remove(jt3);
			remove(jt4);
			remove(jt5);
			remove(jt6);
			remove(jt7);
			remove(jt8);
			remove(jt9);
			remove(jb1);
			remove(jb2);
			break;
		default:
			System.out.println("no");
			break;
		}
}
	private void delete_checi() {

		jl1 = new JLabel("��������ɾ���ĳ��κţ�");
		jl1.setBounds(10, 130, 150, 30);
		jt1 = new JTextField();
		jt1.setBounds(150, 135, 100, 20);
		
		jb2=new JButton("�ύ");
		jb2.setBounds(50, 500, 60, 30);
		add(jl1);
		add(jt1);
		add(jb2);
		this.repaint();
	}

	private void delete_zhandian() {

		jl1 = new JLabel("��������ɾ����վ��ĳ��κţ�");
		jl1.setBounds(10, 130, 190, 30);
		jt1 = new JTextField();
		jt1.setBounds(190, 135, 130, 20);
		jb1 = new JButton("��ʾ");
		jb1.setBounds(350, 130, 60, 30);
		
		jb2=new JButton("�ύ");
		jb2.setBounds(50, 500, 60, 30);
		
		jl2= new JLabel("��������ɾ����վ�㣺");
		jl2.setBounds(10, 160, 190, 30);
		jt2 = new JTextField();
		jt2.setBounds(190, 165, 130, 20);

		ja1 = new JTextArea();
		ja1.setBounds(50, 200, 500, 130);
		ja1.setLineWrap(true);// �����Զ����У�
        ja1.setBorder (BorderFactory.createLineBorder(Color.gray,1));
        
		ja2 = new JTextArea();
		ja2.setBounds(50, 360, 500, 130);
		ja2.setLineWrap(true);// �����Զ����У�
        ja2.setBorder (BorderFactory.createLineBorder(Color.gray,1));
        
		jl3 = new JLabel("������");
		jl3.setBounds(10, 180, 80, 100);

		jl4 = new JLabel("������");
		jl4.setBounds(10, 340, 80, 100);

		add(jl1);
		add(jt1);
		add(jl2);
		add(jt2);
		add(ja1);
		add(ja2);
		add(jl3);
		add(jl4);
		add(jb1);
		add(jb2);
		this.repaint();
	}

	private void xiugai() {

		jl1 = new JLabel("���������޸���Ϣ�ĳ��κţ�");
		jl1.setBounds(10, 130, 190, 30);
		jt1 = new JTextField();
		jt1.setBounds(190, 135, 130, 20);
		jb1 = new JButton("��ʾ");
		jb1.setBounds(350, 130, 60, 30);
		jb2=new JButton("�ύ");
		jb2.setBounds(50, 500, 60, 30);
		
		jl2 = new JLabel(
				"   IC��                 ѧ����                  ���꿨                  Ʊ��");
		jl2.setBounds(80, 160, 300, 40);
		jl3 = new JLabel("Ŀǰ");
		jl3.setBounds(15, 200, 30, 20);

		jt2 = new JTextField();
		jt2.setBounds(75, 200, 50, 20);

		jt3 = new JTextField();
		jt3.setBounds(160, 200, 50, 20);

		jt4 = new JTextField();
		jt4.setBounds(250, 200, 50, 20);

		jt5 = new JTextField();
		jt5.setBounds(340, 200, 50, 20);

		jl4 = new JLabel("��Ϊ");
		jl4.setBounds(15, 240, 30, 20);

		jt6 = new JTextField();
		jt6.setBounds(75, 240, 50, 20);

		jt7 = new JTextField();
		jt7.setBounds(160, 240, 50, 20);

		jt8 = new JTextField();
		jt8.setBounds(250, 240, 50, 20);

		jt9 = new JTextField();
		jt9.setBounds(340, 240, 50, 20);
		add(jl1);
		add(jt1);
		add(jb1);
		add(jb2);
		add(jl2);
		add(jl3);
		add(jt2);
		add(jt3);
		add(jt4);
		add(jt5);
		add(jl4);
		add(jt6);
		add(jt7);
		add(jt8);
		add(jt9);
		this.repaint();
	}

	private class RadioButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == jr1) {
				delete_zujian(count);
				delete_checi();
				count=1;
				System.out.println("hello");
			}
			if (e.getSource() == jr2) {
				delete_zujian(count);
				delete_zhandian();
			    count=2;
				System.out.println("ho");
			}
			if (e.getSource() == jr3) {
				delete_zujian(count);
				xiugai();
				count = 3;
				System.out.println("he");
			}
		}
	}
}
