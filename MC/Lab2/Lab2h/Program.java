import java.util.Scanner;

public class Program {
	//2864809
	public static void main(String[] args) {
		Dog arr[] = new Dog[5];
		Scanner sc = new Scanner(System.in);
		for(int i = 0; i<5; i++) {
			String name = sc.next();
			int age = sc.nextInt();
		Dog d1 = new Dog(name, age);
		arr[i] = d1;
	}
		sc.close();
		for(int i = 0 ; i<5; i++) {
			arr[i].bark();
		}
		
	
	}
}
