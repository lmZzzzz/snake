package scom.lm;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Test {

	/**
	 * @param args
	 * @throws IOException
	*/ 
	 public static void main(String[] args) throws IOException {
	 

		Snake s1 = new Snake(5, 5, 5,0);
		Map[][] map = new Map[30][30];
		Food fd = new Food(1, 1);
		/*Random r1 = new Random();
		int x = r1.nextInt(29);
		int y = r1.nextInt(29);*/
		// ����հ׵�ͼ
		//����Ϊm1
		m1(map);
		/*for (int i = 0; i < 30; i++) {
			for (int j = 0; j < 30; j++) {
				map[i][j] = new Map(false);
				// System.out.println(map[i][j].have);
			}
		}*/
		// ������ͷ������
		
		/*for (int i = 0; i < s1.bodylong; i++) {
			map[s1.heady][s1.headx - i].have = true;

		}*/
		//����Ϊm2����
		m2(s1,map);
		//��ʳ���������Ϊm3����
		m3(map,fd);
		// ����ͻ���ʳ��
		/*while (map[x][y].have) {
			x = r1.nextInt(29);
			y = r1.nextInt(29);
		}
		Food fd = new Food(x, y);
		map[x][y].have = true;*/
		//�������������Ϊm4����
		m4(s1,fd,map);
		// ��Ϸ�������(Ц)
		/*int z = 0;
		for (int i = 0; i < 30; i++) {
			for (int j = 0; j < 30; j++) {
				z++;
				if (map[i][j].have) {
					fw.write("*" + " ");
					// while(z==29){System.out.println(j);z=0;/*fw.write(1+" "+"\n");}
				} else if (map[i][j].have == false) {
					fw.write(0 + " ");
					// while(j==30){fw.write(0+" "+"\n");}
				}
				while (z == 30) {
					fw.write("\n");
					z = 0;
				}
			}

		}
		fw.write(fd + "\n");
		fw.write(s1 + "\n");
		fw.flush();
		fw.close();*/
	}

	public static void m2(Snake s,Map[][] map) {
		for (int i = 0; i < s.body; i++) {
			map[s.headx][s.heady - i].have = true;
			

		}
	}
	public static void m4(Snake s1,Food fd,Map[][] map) throws IOException{
		FileWriter fw = new FileWriter("�����Ϸ����.txt",true);
		int z = 0;
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j <15 ; j++) {
				z++;
				if (map[i][j].have) {
					fw.write("*" + " ");
					// while(z==29){System.out.println(j);z=0;/*fw.write(1+" "+"\n");*/}
				} else if (map[i][j].have == false) {
					fw.write("0" + " ");
					// while(j==30){fw.write(0+" "+"\n");}
				}
				while (z == 15) {
					fw.write("\n");
					z = 0;
				}
			}
		}
		fw.write(fd + "\n");
		fw.write(s1 + "\n");
		fw.flush();
		fw.close();
	}
	public static void m3(Map[][] map,Food fd){
		Random r1 = new Random();
		int x = r1.nextInt(29);
		int y = r1.nextInt(29);
		while (map[x][y].have) {
			x = r1.nextInt(29);
			y = r1.nextInt(29);
		}
		fd.x=x;
		fd.y=y;
		map[x][y].have = true;
	}
	public static void m1(Map[][] map){
		for (int i = 0; i < 30; i++) {
			for (int j = 0; j < 30; j++) {
				map[i][j] = new Map(false);
				// System.out.println(map[i][j].have);
			}
		}
	}
}


















