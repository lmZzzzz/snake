package scom.lm;

import java.util.Random;

public class Smallgame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random r1 = new Random();
        int i = r1.nextInt(100);
        java.util.Scanner s = new java.util.Scanner(System.in);
        Integer z= new Integer(s.next());
        int j = 1;
        while(z.intValue()!=i){
        	if(z.intValue()>i){
        		System.out.println("大了");
        	}else {
				System.out.println("小了");
			}
        	 s = new java.util.Scanner(System.in);
             z= new Integer(s.next());
             j++;
        }
	         System.out.println("你真棒!!"+"一共猜了"+j+"次.");
	}
	            

}
