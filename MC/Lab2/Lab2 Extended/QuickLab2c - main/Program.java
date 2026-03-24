import java.util.ArrayList;
import java.util.Scanner;

public class Program {

	public static void main(String Args[]) {
		ArrayList<Rating> allRatings = new ArrayList<>();
		Scanner sc = new Scanner(System.in).useDelimiter(";");
		while (true) {
			String line = sc.nextLine();
			if (line.equals("-1")) {
				break;

			}
			String[] v = line.split(";");
			String name = v[0];
			int score = Integer.parseInt(v[1]);
			
			Rating myRating = new Rating(name,score);
			allRatings.add(myRating);
			
		}
		Program p = new Program();
		System.out.println(p.getAverage(allRatings));
	}

	public double getAverage(ArrayList<Rating> v) {
		double avg = 0;
		int size = v.size();
		for (int i = 0; i < size; i++) {
			avg += v.get(i).getScore();
		}
		return (double) avg / size;
	}
}