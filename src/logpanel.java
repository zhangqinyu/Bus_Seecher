

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import µÇÂ¼²¿·Ö.logframe;

import µÇÂ¼²¿·Ö.zuceframe;

import java.sql.*;

public class logpanel extends JPanel{
	private JButton b1,b2,b3;
	private JTextField t1, t2, t3;
	private JLabel jl1,jl2,jl3;
	private JPanel jp1,jp2;
	
	public logpanel(){
		setLayout(null);
		b1=new JButton("µÇÂ½");
		b2=new JButton("×¢²á");
		b3=new JButton("ÍË³ö");
		
		b1.setBounds(13, 203, 81,41);
		b2.setBounds(123, 203, 81,41);
		b3.setBounds(263, 203, 81,41);
		
		b1.addActionListener(new ButtonListener());
		b2.addActionListener(new ButtonListener());
		b3.addActionListener(new ButtonListener());
		
		t1=new JTextField(5);
		t2=new JTextField(5);
		
		t1.setBounds(125, 42,140,41);
		t2.setBounds(125, 111,140,41);
		
		
		jl1=new JLabel("»¶Ó­");
		jl2=new JLabel("ÕËºÅ");
		jl3=new JLabel("ÃÜÂë");
		
		jl1.setBounds(0, 0, 400,35);
		jl2.setBounds(13, 41, 64,29);
		jl3.setBounds(13, 111, 64,29);
		
		add(b1);add(b2);add(b3);
		add(t1);add(t2);
		add(jl1);add(jl2);add(jl3);
		
		setPreferredSize(new Dimension(400, 300));
	}
	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==b1)
				new welcome();
			    //logframe.dispose();
			if(e.getSource()==b2)
				new zuceframe();
			if(e.getSource()==b3)
				System.exit(0);
		}
		
	}
}

