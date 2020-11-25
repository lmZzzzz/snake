package image01.ml;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SnakeBody {
 
    int x;
    int y;
    BufferedImage image;
	public SnakeBody(int x,int y) {
		this.x =x;
		this.y =y;
		try {
			image = ImageIO.read(new File("image/Body.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public SnakeBody() {
		try {
			image = ImageIO.read(new File("image/Body.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
    
 
}
