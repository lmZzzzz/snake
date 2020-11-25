package image01.ml;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SnakeHead {
    
	int  headx=4;
	int  heady=1;
	volatile boolean isgox=true;
	volatile boolean isgoy=false;
	int x = 1;
	BufferedImage image;
	SnakeHead() {
		try {
			image = ImageIO.read(new File("image/Head.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void gox(){
		isgoy=false;
		isgox=true;
	}
	public void goy(){
		isgox=false;
		isgoy=true;
	}
    public void moveX(){
    	if(isgox){this.headx+=x;}
    }
    public void moveY(){
    	if(isgoy){this.heady+=x;}
    }	
}
