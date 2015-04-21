package 登录部分;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class zuce_succes_frame {
	JFrame zuce_succes_frame;

	public zuce_succes_frame() {
		zuce_succes_frame = new JFrame(
				"注                册               成                 功");
		zuce_succes_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int width = 500;
		int height = 500;
		zuce_succes_frame.setBounds((d.width - width) / 2,
				(d.height - height) / 2, width, height);
		zuce_succes_frame.getContentPane().add(new zuce_succes_panel());
		zuce_succes_frame.pack();
		zuce_succes_frame.setVisible(true);
	}

	class zuce_succes_panel extends JPanel {
		private JButton b1, b2;
		private JLabel jl1, jl2;

		public zuce_succes_panel() {
			setLayout(null);
			b1 = new JButton("进入登录界面");
			b2 = new JButton("退出");

			jl1 = new JLabel("恭喜注册成功！！请牢记您的账户和密码 ！！");

			jl1.setBounds(45, 40, 300, 56);

			b1.setBounds(31, 185, 107, 40);
			b2.setBounds(229, 185, 107, 40);

			b1.addActionListener(new ButtonListener());
			b2.addActionListener(new ButtonListener());

			add(jl1);
			add(b1);
			add(b2);
			setPreferredSize(new Dimension(400, 300));
		}

		private class ButtonListener implements ActionListener {

			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == b1)
				{	
					 new logframe();
					 zuce_succes_frame.dispose();
				   
				    }
				if (e.getSource() == b2)
					System.exit(0);

			}

		}
	}
}
