import java.util.Scanner;
import java.util.ArrayList;

public class Program {
	public static double getDistance(double x1, double y1, double x2, double y2) {
		double distance = Math.sqrt((((x2 - x1) * (x2 - x1)) + ((y2 - y1) * (y2 - y1))));
		return distance;
	}

	public static void main(String Args[]) {
		ArrayList<ArrayList<Double>> coord = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()) {
			String line = sc.nextLine();

			if (line.equals("-1")) {
				break;
			}

			ArrayList<Double> row = new ArrayList<>();
			String[] num = line.split(",");
			for (String no : num) {
				row.add(Double.parseDouble(no));
			}
			coord.add(row);

		}
		int amount = coord.size();
		ArrayList<Double> distance = new ArrayList<Double>();
		for (int i = 0; i < amount - 1; i++) {
			for (int j = i + 1; j < amount - 1; j++) {
				double d = getDistance(coord.get(i).get(0), coord.get(i).get(1), coord.get(j).get(0),
						coord.get(j).get(1));
				distance.add(d);
			}
		}

		double smallest = distance.get(0);
		for (double e : distance) {
			if (e < smallest) {
				smallest = e;
			}
		}
		System.out.println(smallest);

		sc.close();
	}
}
