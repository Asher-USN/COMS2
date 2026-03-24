//package Lab2c;

import java.util.Scanner;

public class Program {
//2864809
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[10];
		for(int i =0; i<10; i++) {
		
		arr[i] = sc.nextInt();
	}
		
		int pos = sc.nextInt();
		System.out.println(arr[pos]);
		sc.close();
}
}
