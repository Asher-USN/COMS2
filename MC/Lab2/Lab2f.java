//package Lab2c;

import java.util.Scanner;

public class Program {
//2864809
	public static void main(String args[]) {
		 Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		int arr[] = new int[number];
		for(int i =0; i<number;i++) {
			arr[i] = sc.nextInt();
		}
		for(int i = number-1; i >= 0 ;i--) {
			System.out.println(arr[i]);
		}
	}
}
