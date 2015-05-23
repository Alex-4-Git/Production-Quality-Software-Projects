package edu.nyu.cs.pqs.connect4View;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import edu.nyu.cs.pqs.connect4Model.Connect4Constant;
import edu.nyu.cs.pqs.connect4Model.Connect4Controller;

public class ImageLoader {
	public static ImageIcon getImageIcon(Connect4Constant.COLOR color) throws IOException{
		String imagePath;
		switch(color){
		case RED:
			imagePath = "images/garbook.gif";
			break;
		case YELLOW:
			imagePath = "images/odie.png";
			break;
		default:
			imagePath = "";
			break;
		}

		ImageIcon imageIcon = new ImageIcon(imagePath); // load the image to a imageIcon

		Image image = imageIcon.getImage(); // transform it

		Image newimg = image.getScaledInstance(100, 100,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way 
		imageIcon = new ImageIcon(newimg);  // transform it back
		return imageIcon;
	}

}
