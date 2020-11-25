package image01.ml;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BackGround {
  BufferedImage image;
  Graphics2D g2;
  BackGround(){
		 
		try {

			image = ImageIO.read(new File("image/background.png"));
			image.setRGB(image.getMinX(),image.getMinY(), BufferedImage.TYPE_INT_BGR);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		    image = new BufferedImage(810,810, BufferedImage.TYPE_INT_BGR);
//		 g2 = image.createGraphics();
//		 g2.drawImage(image, 0, 0, null);
}
  }
