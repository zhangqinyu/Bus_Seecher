package 登录部分;

import javax.swing.*;

import 登录部分.zuceframe.zucepanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class star {
	private JFrame jframe;
	public static void main(String[] args){
		new star();
	}
    public star(){
    	   jframe=new JFrame();
    	   jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		   Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		   int width = 500;
		   int height = 500;
		   jframe.setBounds((d.width - width) / 2, (d.height - height) / 2, width, height);
		   jframe.getContentPane().add(new chushi_panel());
		   jframe.pack();
		   jframe.setVisible(true);
    }
    private class chushi_panel extends JPanel{
    	private JButton jb1,jb2;
    	private JLabel lb;
    	private chushi_panel(){
    		setLayout(null);
    		setOpaque(false); //设置为透明！！！
    		jb1=new JButton("我是游客");
    		jb2=new JButton("我是管理者");
    		jb1.setBounds(350, 50, 100, 30);
    		jb2.setBounds(350, 100, 100, 30);
    		jb1.addActionListener(new ButtonListener());
    		jb2.addActionListener(new ButtonListener());
    		add(jb1);
    		add(jb2);
 
    		lb=new JLabel();
    		lb.setIcon(new change_image_size ("C:\\Users\\18580_000\\Downloads\\first.jpg",500,400).getImageIcon());
    		lb.setSize(500,400);
    		
    		add(lb);
    		setPreferredSize(new Dimension(500, 400));
    	}
    	private class ButtonListener implements ActionListener {
    		public void actionPerformed(ActionEvent e) {
				if(e.getSource()==jb1)
					new search_frame();
				    jframe.dispose();
				if(e.getSource()==jb2)
					new logframe();
				    jframe.dispose();
			}
    		
    	}
    }
}
