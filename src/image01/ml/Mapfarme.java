package image01.ml;

import java.awt.Container;
import javax.swing.JFrame;
public class Mapfarme extends JFrame{
	Gamepanel p;
	FreshThread thread;
    public Mapfarme(){
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�رմ���
	Container c = getContentPane();//��ȡ�����������
	p = new Gamepanel();
	c.add(p);//����Ϸ�����ӵ��������� 
	addKeyListener(p);
	thread = new FreshThread(p);//���������߳�
   }
	public static void main(String[] args){
		Mapfarme mapfarme = new Mapfarme();
		mapfarme.setBounds(300,100, 826,853);
		mapfarme.setVisible(true);
		mapfarme.thread.start();
	}
	public void restart() {
		java.awt.Container c = getContentPane();
        c.removeAll();
   	    Gamepanel np  = new Gamepanel();
   	    c.add(np);
   	    addKeyListener(np);//����¼�����
   	    c.validate();//������֤�������
		this.thread = new FreshThread(np);
		thread.start();
	}
}
