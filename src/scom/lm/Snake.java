package scom.lm;


public class Snake {
   int bodylong;
   int headx;
   int heady;
   int bodyhigh;
   int body;
public Snake(int bodylong, int headx, int heady,int bodyhigh) {
	super();
	this.bodylong = bodylong;
	this.headx = headx;
	this.heady = heady;
	this.bodyhigh =bodyhigh;
	this.body=bodyhigh+bodylong;
}  
    void xmove(Snake s1,int x,Map[][] map){
    	s1.headx += x;
    	s1.bodylong+=x;if(s1.bodylong==s1.body+1){s1.bodylong=s1.body;}
    	s1.bodyhigh-=x;if(s1.bodyhigh==-1){s1.bodyhigh=0;}
    	map[heady][headx].have=true;
    	map[s1.heady-(bodyhigh)][s1.headx-(s1.bodylong)].have=false;
    }
    void ymove(Snake s1,int y,Map[][] map){
    	s1.heady +=y;
    	s1.bodylong-=y;if(s1.bodylong==-1){s1.bodylong=0;}
    	s1.bodyhigh+=y;if(s1.bodyhigh==s1.body+1){s1.bodyhigh=s1.body;}
    	map[heady][headx].have=true;
    	map[s1.heady-(s1.bodyhigh)][s1.headx-(s1.bodylong)].have=false;
    	
    }	
    	
    	
    
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "蛇头的坐标为"+"("+(headx+1)+","+(heady+1)+")";
	}
   
   
}
