package ʵ��;

import java.awt.*;

import javax.swing.*;
public class welcome {

	public welcome() {
		// TODO Auto-generated method stub
		JFrame frame=new JFrame("he frame");
		   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		   
		   welpanel p=new welpanel();
		   frame.getContentPane().add(p);
		   frame.pack();
		   frame.setVisible(true);
	}

	class welpanel extends JPanel{

		private JButton b1,b2,b3,b4,b5;
		private JTextField t1, t2, t3;
		private JComboBox jc1 = null,jc2 = null;
		private JLabel jl1,jl2,jl3;
		private JPanel jp1,jp2;
		public welpanel(){
			setLayout(new GridLayout(2, 1));

			String nations[] = { "+", "-", "*", "/" };//�����Ҫд�ɹ�����վ��
			this.jc1 = new JComboBox(nations);// �����б�
			this.jc2 = new JComboBox(nations);// �����б�
			
			 jc1.setBounds(40, 20, 150, 30);
			 jc2.setBounds(300, 20, 150, 30);
			b1 = new JButton("����˵�·��");
			b2 = new JButton("��̵�·��");
			b3 = new JButton("��ʡʱ���·��");
			b4 = new JButton("����");
			b5 = new JButton("�˳�");
			b1.setBounds(20, 100, 85, 40);
			b2.setBounds(122, 100, 85, 40);
			b3.setBounds(230, 100, 85, 40);
			b4.setBounds(350, 100, 85, 40); 
			b5.setBounds(459, 100, 85, 40);
			
			jl1=new JLabel("��");
			jl2=new JLabel("��");
	    	jl1.setBounds(10,  20,30, 30);
	    	jl2.setBounds(245,  20,30, 30);
			
			jp1=new JPanel();
			jp2=new JPanel();
	        
			jp1.setLayout(null);
			
			jp1.add(jl1);
			jp1.add(jl2);
			jp1.add(b1);
			jp1.add(b2);
			jp1.add(b3);
			jp1.add(b4);
			jp1.add(b5);
		
			jp1.add(jc1);
			jp1.add(jc2);
		
			
			add(jp1);
			add(jp2);
			
			
			
			setPreferredSize(new Dimension(600, 600));
		}
 
}}
