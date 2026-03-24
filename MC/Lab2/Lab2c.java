//package Lab2c;

import java.util.Scanner;

public class Program {
//2864809
	public static int getX(String c) {
		char letter = c.charAt(0);
		
		int x = letter - '0';
		return x;
	}
	
	public static int getY(String c) {
		char letter = c.charAt(2);
		int y= letter - '0';
		return y;
	}
	
	public static int getXDistance(String a, String b) {
		int x1= getX(a);
		int x2 = getX(b);
		//int y1 = getY(a);
		//int y2 = getY(b);
		int distance = Math.abs(x2-x1);
		return distance;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String c = in.nextLine();
		String d = in.nextLine();
		int dis = getXDistance(c, d);
		System.out.println(dis);
				
	}

}
