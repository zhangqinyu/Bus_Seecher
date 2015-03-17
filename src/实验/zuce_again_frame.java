package 实验;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class zuce_again_frame {
	   JFrame zuce_again_frame ;
	public zuce_again_frame(){
		zuce_again_frame =new JFrame("请                  重                新                 注                 册");
		zuce_again_frame .setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
	   int width = 500;
	   int height = 500;
	   zuce_again_frame .setBounds((d.width - width) / 2, (d.height - height) / 2, width, height);
	   zuce_again_frame .getContentPane().add(new zuce_again_panel());
	   zuce_again_frame .pack();
	   zuce_again_frame .setVisible(true);
}
	class zuce_again_panel extends JPanel{
		private JButton b1,b2;
		private JLabel jl1,jl2;
		public zuce_again_panel(){
			setLayout(null);
			b1=new JButton("重新注册");
			b2=new JButton("退出");
			
			jl1=new JLabel("此账户已被注册");
			
			jl1.setBounds(45, 40,300, 56);
			
			b1.setBounds(31, 185, 107, 40);
			b2.setBounds(229, 185, 107, 40);
			
			b1.addActionListener(new ButtonListener());
			b2.addActionListener(new ButtonListener());
			
			add(jl1);
			add(b1);add(b2);
			setPreferredSize(new Dimension(400, 300));
		}
		private class ButtonListener implements ActionListener{

			public void actionPerformed(ActionEvent e) {
			  if(e.getSource()==b1) 
				  new zuceframe();
				  zuce_again_frame.dispose();
			  if(e.getSource()==b2)
				  System.exit(0);
				
			}
			
		}
	}
}