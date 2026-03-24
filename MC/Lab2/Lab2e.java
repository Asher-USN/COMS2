//package Lab2c;

import java.util.Scanner;

public class Program {
//2864809
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int arr[] = new int[size];
		for(int i = 0; i <size; i++) {
			arr[i] = sc.nextInt();
			
		}
		
		int num = sc.nextInt();
		System.out.println(arr[num]);
		
		
	}
}
