  package image01.ml;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.text.BreakIterator;
import java.util.Random;

import javax.swing.JPanel;




public class Gamepanel extends JPanel implements KeyListener{
	BufferedImage image;//主图片
	Graphics2D g2;//创建美工
	SnakeHead sh;//蛇头
	SnakeBody[] sb;//多段蛇身,用一维数组
	Food food;
	BackGround background;//背景
	Map[][] map;//地图
	int bodyLong=3;//定义蛇身长度
	int temp1;//参
	int temp2;//数
	int temp3;//传
	int temp4;//递
	boolean finish = false;//判断游戏是否结束
	boolean stop = false;
	long time = 0L;
	public Gamepanel(){
    image = new BufferedImage(810,810, BufferedImage.TYPE_INT_BGR);//初
    g2 = image.createGraphics();                                   //始
    background = new BackGround();                                 //化
    map = new Map[9][9];                                           //对
    food= new Food(5,5);                                           //象  
    sb = new SnakeBody[bodyLong];                                  
    m2(sb);//初始化蛇身
    sh = new SnakeHead();

	}
	public void paint(Graphics g){
		if(sh.headx>9||sh.headx<=-1||sh.heady>=9||sh.heady<=-1){finish=true;}
		m1(map);//定义空白地图
		paintImage();//绘制到主图片上
		g.drawImage(image,0,0,this);//将主图片绘制到面板上
//		for(int i=0;i<sb.length;i++){//确定蛇身位置
//			if(i==0){temp1=sb[i].x;temp2=sb[i].y;sb[i].x=sh.headx;sb[i].y=sh.heady;continue;}
//			temp3=sb[i].x;temp4=sb[i].y;
//			sb[i].x=temp1;sb[i].y=temp2;
//			temp1=temp3;temp2=temp4;
//			}
//		sh.moveX();//蛇头水平移动
//	    sh.moveY();//蛇头垂直移动
	}
	public void paintImage(){
		g2.drawImage(background.image,0,0, this);//绘制背景
		g2.drawImage(sh.image, sh.headx*90,sh.heady*90, this);//绘制蛇头
		try{for(int i=0;i<sb.length;i++){map[sb[i].x][sb[i].y].have=true;}}catch (Exception e) {
			System.out.println("111");
		}//定义蛇身
		if(sh.headx==food.x&&sh.heady==food.y){
			m3(map,food);
			//bodyLong+=1;
			//sb=new SnakeBody[bodyLong];
			//for(int i=0;i<bodyLong;i++){sb[i]=new SnakeBody(3-i,1);}
		}//定义食物位置
		g2.drawImage(food.image, food.x*90,food.y*90, this);//绘制食物
		for(int i=0;i<=8;i++){//绘制蛇身
			for(int j=0;j<=8;j++){
				if(map[i][j].have){g2.drawImage(sb[0].image,i*90,j*90, this);}
				}
		}
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	@Override
	//键盘按压监听
	public void keyPressed(KeyEvent e) {
	    int code = e.getKeyCode();
	    if (time != 0L && System.currentTimeMillis()-time<250){
			System.out.println(System.currentTimeMillis()-time);
	    	return;
	    }
        time =System.currentTimeMillis();
	    if(code==37&&sh.isgoy){sh.x=-1;sh.gox();}//←
	    if(code==38&&sh.isgox){sh.x=-1;sh.goy();}//↑
	    if(code==39&&sh.isgoy){sh.x=1;sh.gox();} //→
	    if(code==40&&sh.isgox){sh.x=1;sh.goy();} //↓
	    if(code==88&&stop==false){stop=true;}//x
	    if(code==67&&stop==true){stop=false;}//c
	    
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	public boolean isFinish() {
		//判断游戏是否结束的标志
			return finish;
		}
	public boolean isStop() {
		//判断游戏是否结束的标志
			return stop;
		}
	//地图初始化
	public void m1(Map[][] map){
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				map[i][j] = new Map(false);
				// System.out.println(map[i][j].have);
			}
		}
	}
	//蛇身初始化
	public void m2(SnakeBody[] sb){
		for(int i=0;i<bodyLong;i++){sb[i]=new SnakeBody(3-i,1);}
	}
	//食物初始化
	public static void m3(Map[][] map,Food fd){
		Random r1 = new Random();
		int x = r1.nextInt(7);
		int y = r1.nextInt(7);
		while(map[x][y].have) {
			x = r1.nextInt(7);
			y = r1.nextInt(7);
		}
		fd.x=x;
		fd.y=y;
	}
}
