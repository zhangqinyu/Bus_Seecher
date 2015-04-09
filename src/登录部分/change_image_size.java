package µÇÂ¼²¿·Ö;

import java.awt.Image;

import javax.swing.ImageIcon;

public class change_image_size {
	String path; 
	int width; 
	int height;
public change_image_size (String path, int width, int height){
	this.path=path;
	this.width=width;
	this.height=height;
}
public ImageIcon getImageIcon() {
 	  if (width == 0 || height == 0) {
 	   return new ImageIcon(this.getClass().getResource(path));
 	  }
 	  ImageIcon icon = new ImageIcon(path);
 	  icon.setImage(icon.getImage().getScaledInstance(width, height,
 	    Image.SCALE_DEFAULT));
 	  return icon;
 	 }
}
