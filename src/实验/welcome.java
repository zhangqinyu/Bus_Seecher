package สตั้;

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

	 
}
