package scom.lm;

import java.io.IOException;

public class Game {

	/**
	 * 此处程序封装
	 * 日志2017年10月4日15:23:37
	 * 此时可以生成规定蛇身 和 随机食物(不会刷新在蛇身处)
	 * 生成固定30*30地图
	 * 日志2017年10月5日16:49:54
	 * 此时可以生成蛇身 实现了蛇的x轴移动 移植到cmd命令窗口
	 * 
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws IOException, InterruptedException {
		Snake s1 = new Snake(5,5, 5,0);
		Map[][] map = new Map[30][30];
		Food fd = new Food(1, 1);
		//创建空白地图
		Test.m1(map);
		// 绘制蛇头和蛇身
		/* 画面连续==不停的重新绘制==m2 m3 m4 m2 m3 m4 
		 * 食物在没被吃掉前不需要重新绘制== m2 (判断蛇头是否和食物坐标一致)ture m3 m4
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
		// 定义和绘制食物
		//Test.m3(map, fd);
		//绘制游戏界面
		
		
	}

}
