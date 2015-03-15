package ÊµÑé;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class logframe {
	JFrame frame;
public logframe(){
	frame=new JFrame("he frame");
	   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   
	   Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
	   int width = 500;
	   int height = 500;
	   frame.setBounds((d.width - width) / 2, (d.height - height) / 2, width, height);
	   panel p=new panel();
	   
	   frame.getContentPane().add(p);
	   frame.pack();
	   frame.setVisible(true);
}

class panel extends JPanel{
	private JButton b1,b2,b3;
	private JTextField t1, t2, t3;
	private JLabel jl1,jl2,jl3;
	private JPanel jp1,jp2;
	
	public panel(){
		setLayout(null);
		b1=new JButton("µÇÂ½");
		b2=new JButton("×¢²á");
		b3=new JButton("ÍË³ö");
		
		b1.setBounds(13, 203, 81,41);
		b2.setBounds(123, 203, 81,41);
		b3.setBounds(263, 203, 81,41);
		b1.addActionListener(new ButtonListener());
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
			if(e.getSource()==b3)
				System.exit(0);
			if(e.getSource()==b1)
				new welcome();
				frame.dispose();
		}
		
	}
}

}
