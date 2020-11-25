package scom.lm;

public class Map {
boolean have;

public Map(boolean have) {
	super();
	this.have = have;
}
public  void m1(Map[][] map){
	for (int i = 0; i < 8; i++) {
		for (int j = 0; j < 8; j++) {
			map[i][j] = new Map(false);
			// System.out.println(map[i][j].have);
		}}}
}
