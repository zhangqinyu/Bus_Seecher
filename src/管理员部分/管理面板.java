package ����Ա����;
import java.awt.*;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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

import java.io.*;

public class ������� {
	public static void main(String argv[]) {
		new �������();
	}

	private JFrame jframe;
	private JTabbedPane jp;
	public �������() {
		jframe = new JFrame();
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int width = 600;
		int height = 600;
		jframe.setBounds((d.width - width) / 2, (d.height - height) / 2, width,
				height);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jp=new JTabbedPane();
		jp.addTab("���", new tianjia_bus_panel());
		jp.addTab("�޸�", new delete_bus_panel());
		
		jframe.getContentPane().add(jp);
		jframe.pack();
		jframe.setSize(600, 620);
		jframe.setVisible(true);

	}

}