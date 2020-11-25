package scom.lm;

public class Food {
int x;
int y;

public Food(int x, int y) {
	super();
	this.x = x;
	this.y = y;
}
@Override
public String toString() {
	// TODO Auto-generated method stub
	return "食物的坐标为"+"("+(y+1)+","+(x+1)+")";
}


}
