package ʵ��;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class log_again_frame {
	  JFrame log_again_frame ;
		public log_again_frame(){
			log_again_frame =new JFrame("��                  ��                ��                 ��                 ¼");
			log_again_frame .setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		   Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		   int width = 500;
		   int height = 500;
		   log_again_frame .setBounds((d.width - width) / 2, (d.height - height) / 2, width, height);
		   log_again_frame .getContentPane().add(new log_again_panel());
		   log_again_frame .pack();
		   log_again_frame .setVisible(true);
	}
		class log_again_panel extends JPanel{
			private JButton b1,b2;
			private JLabel jl1,jl2;
			public log_again_panel(){
				setLayout(null);
				b1=new JButton("���µ�¼");
				b2=new JButton("�˳�");
				
				jl1=new JLabel("�˻���������������µ�¼��");
				
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
					  new logframe();
					  log_again_frame.dispose();
				  if(e.getSource()==b2)
					  System.exit(0);
					
				}
				
			}
		}
}
