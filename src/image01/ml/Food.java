package image01.ml;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Food {
  int x;
  int y;
  BufferedImage image;
public Food(int x, int y) {
	this.x = x;
	this.y = y;
	try {
		image = ImageIO.read(new File("image/Food.png"));
	} catch (IOException e) {
		e.printStackTrace();
	}
}
public Food() {

}
    
}
