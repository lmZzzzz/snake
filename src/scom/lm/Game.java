package scom.lm;

import java.io.IOException;

public class Game {

	/**
	 * �˴������װ
	 * ��־2017��10��4��15:23:37
	 * ��ʱ�������ɹ涨���� �� ���ʳ��(����ˢ��������)
	 * ���ɹ̶�30*30��ͼ
	 * ��־2017��10��5��16:49:54
	 * ��ʱ������������ ʵ�����ߵ�x���ƶ� ��ֲ��cmd�����
	 * 
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws IOException, InterruptedException {
		Snake s1 = new Snake(5,5, 5,0);
		Map[][] map = new Map[30][30];
		Food fd = new Food(1, 1);
		//�����հ׵�ͼ
		Test.m1(map);
		// ������ͷ������
		/* ��������==��ͣ�����»���==m2 m3 m4 m2 m3 m4 
		 * ʳ����û���Ե�ǰ����Ҫ���»���== m2 (�ж���ͷ�Ƿ��ʳ������һ��)ture m3 m4
		 *                                                    false m2 m4
		 * 
		 * 
		 * 
		 */
		
		Test.m2(s1, map);
		for(int i = 0;i<4 ;i++){
		s1.ymove(s1,1,map);
		Test.m4(s1, fd, map);
		//Test.m4(s1, fd, map);
		}  
		for(int i = 0;i<4;i++){
		s1.xmove(s1,1,map);
		Test.m4(s1, fd, map);
		Thread.sleep(1000);
		}
		System.out.println(map[5][4].have);
		// ����ͻ���ʳ��
		//Test.m3(map, fd);
		//������Ϸ����
		
		
	}

}
