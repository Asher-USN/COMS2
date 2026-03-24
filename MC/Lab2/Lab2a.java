import java.util.Scanner;

public class Program {
//2864809
	public static int multiply(int x, int y) {
		return x*y;
	}
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String i = in.nextLine();
		int x = Integer.parseInt(i);
		i = in.nextLine();
		int y = Integer.parseInt(i);
		int z = multiply(x, y);
		System.out.println(z);
	}
}
