package image01.ml;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class FreshThread extends Thread{
	Gamepanel p;
	int x = 0;
	public FreshThread(Gamepanel p) {
		this.p = p;//给类成员属性赋值
	}
	@Override
	public void run() {

		while(!p.isFinish()){
			 if(!p.isStop()){
//			 	synchronized (){}
			 	p.repaint();//重新绘制图片
			 }
			x++;

			if (x%10==0){
				for(int i=0;i<p.sb.length;i++){//确定蛇身位置
					if(i==0){p.temp1=p.sb[i].x;p.temp2=p.sb[i].y;p.sb[i].x=p.sh.headx;p.sb[i].y=p.sh.heady;continue;}
					p.temp3=p.sb[i].x;p.temp4=p.sb[i].y;
					p.sb[i].x=p.temp1;p.sb[i].y=p.temp2;
					p.temp1=p.temp3;p.temp2=p.temp4;
				}
				p.sh.moveX();//蛇头水平移动
				p.sh.moveY();//蛇头垂直移动
			}

			try {
				Thread.sleep(30);//线程休息300毫秒
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			     
			}
			//循环结束,弹出游戏结束提示
			if(!p.isStop()){
			    java.awt.Container c = p.getParent();
			while(!(c instanceof JFrame)){
				c = c.getParent();
			}
			Mapfarme m1 = (Mapfarme)c ;
			//弹出通知
			JOptionPane.showMessageDialog(m1, "GoodGame");
			m1.restart();
			}
	}
}


