package image01.ml;

import java.awt.Container;
import javax.swing.JFrame;
public class Mapfarme extends JFrame{
	Gamepanel p;
	FreshThread thread;
    public Mapfarme(){
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭窗口
	Container c = getContentPane();//获取窗体的主容器
	p = new Gamepanel();
	c.add(p);//把游戏面板添加到主容器中 
	addKeyListener(p);
	thread = new FreshThread(p);//另外起新线程
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
   	    addKeyListener(np);//添加事件监听
   	    c.validate();//重新验证容器组件
		this.thread = new FreshThread(np);
		thread.start();
	}
}
