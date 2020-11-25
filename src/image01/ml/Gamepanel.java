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
	BufferedImage image;//��ͼƬ
	Graphics2D g2;//��������
	SnakeHead sh;//��ͷ
	SnakeBody[] sb;//�������,��һά����
	Food food;
	BackGround background;//����
	Map[][] map;//��ͼ
	int bodyLong=3;//����������
	int temp1;//��
	int temp2;//��
	int temp3;//��
	int temp4;//��
	boolean finish = false;//�ж���Ϸ�Ƿ����
	boolean stop = false;
	long time = 0L;
	public Gamepanel(){
    image = new BufferedImage(810,810, BufferedImage.TYPE_INT_BGR);//��
    g2 = image.createGraphics();                                   //ʼ
    background = new BackGround();                                 //��
    map = new Map[9][9];                                           //��
    food= new Food(5,5);                                           //��  
    sb = new SnakeBody[bodyLong];                                  
    m2(sb);//��ʼ������
    sh = new SnakeHead();

	}
	public void paint(Graphics g){
		if(sh.headx>9||sh.headx<=-1||sh.heady>=9||sh.heady<=-1){finish=true;}
		m1(map);//����հ׵�ͼ
		paintImage();//���Ƶ���ͼƬ��
		g.drawImage(image,0,0,this);//����ͼƬ���Ƶ������
//		for(int i=0;i<sb.length;i++){//ȷ������λ��
//			if(i==0){temp1=sb[i].x;temp2=sb[i].y;sb[i].x=sh.headx;sb[i].y=sh.heady;continue;}
//			temp3=sb[i].x;temp4=sb[i].y;
//			sb[i].x=temp1;sb[i].y=temp2;
//			temp1=temp3;temp2=temp4;
//			}
//		sh.moveX();//��ͷˮƽ�ƶ�
//	    sh.moveY();//��ͷ��ֱ�ƶ�
	}
	public void paintImage(){
		g2.drawImage(background.image,0,0, this);//���Ʊ���
		g2.drawImage(sh.image, sh.headx*90,sh.heady*90, this);//������ͷ
		try{for(int i=0;i<sb.length;i++){map[sb[i].x][sb[i].y].have=true;}}catch (Exception e) {
			System.out.println("111");
		}//��������
		if(sh.headx==food.x&&sh.heady==food.y){
			m3(map,food);
			//bodyLong+=1;
			//sb=new SnakeBody[bodyLong];
			//for(int i=0;i<bodyLong;i++){sb[i]=new SnakeBody(3-i,1);}
		}//����ʳ��λ��
		g2.drawImage(food.image, food.x*90,food.y*90, this);//����ʳ��
		for(int i=0;i<=8;i++){//��������
			for(int j=0;j<=8;j++){
				if(map[i][j].have){g2.drawImage(sb[0].image,i*90,j*90, this);}
				}
		}
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	@Override
	//���̰�ѹ����
	public void keyPressed(KeyEvent e) {
	    int code = e.getKeyCode();
	    if (time != 0L && System.currentTimeMillis()-time<250){
			System.out.println(System.currentTimeMillis()-time);
	    	return;
	    }
        time =System.currentTimeMillis();
	    if(code==37&&sh.isgoy){sh.x=-1;sh.gox();}//��
	    if(code==38&&sh.isgox){sh.x=-1;sh.goy();}//��
	    if(code==39&&sh.isgoy){sh.x=1;sh.gox();} //��
	    if(code==40&&sh.isgox){sh.x=1;sh.goy();} //��
	    if(code==88&&stop==false){stop=true;}//x
	    if(code==67&&stop==true){stop=false;}//c
	    
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	public boolean isFinish() {
		//�ж���Ϸ�Ƿ�����ı�־
			return finish;
		}
	public boolean isStop() {
		//�ж���Ϸ�Ƿ�����ı�־
			return stop;
		}
	//��ͼ��ʼ��
	public void m1(Map[][] map){
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				map[i][j] = new Map(false);
				// System.out.println(map[i][j].have);
			}
		}
	}
	//�����ʼ��
	public void m2(SnakeBody[] sb){
		for(int i=0;i<bodyLong;i++){sb[i]=new SnakeBody(3-i,1);}
	}
	//ʳ���ʼ��
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
