package image01.ml;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class FreshThread extends Thread{
	Gamepanel p;
	int x = 0;
	public FreshThread(Gamepanel p) {
		this.p = p;//�����Ա���Ը�ֵ
	}
	@Override
	public void run() {

		while(!p.isFinish()){
			 if(!p.isStop()){
//			 	synchronized (){}
			 	p.repaint();//���»���ͼƬ
			 }
			x++;

			if (x%10==0){
				for(int i=0;i<p.sb.length;i++){//ȷ������λ��
					if(i==0){p.temp1=p.sb[i].x;p.temp2=p.sb[i].y;p.sb[i].x=p.sh.headx;p.sb[i].y=p.sh.heady;continue;}
					p.temp3=p.sb[i].x;p.temp4=p.sb[i].y;
					p.sb[i].x=p.temp1;p.sb[i].y=p.temp2;
					p.temp1=p.temp3;p.temp2=p.temp4;
				}
				p.sh.moveX();//��ͷˮƽ�ƶ�
				p.sh.moveY();//��ͷ��ֱ�ƶ�
			}

			try {
				Thread.sleep(30);//�߳���Ϣ300����
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			     
			}
			//ѭ������,������Ϸ������ʾ
			if(!p.isStop()){
			    java.awt.Container c = p.getParent();
			while(!(c instanceof JFrame)){
				c = c.getParent();
			}
			Mapfarme m1 = (Mapfarme)c ;
			//����֪ͨ
			JOptionPane.showMessageDialog(m1, "GoodGame");
			m1.restart();
			}
	}
}


