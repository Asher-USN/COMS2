import java.util.ArrayList;
import java.util.Scanner;


public class Program {
	public static void main(String Args[]) {
		ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		int numRow = 0;
		int numCol = 0;
		while (true) {
			String line = sc.nextLine();
			if (line.equals("-1")) {
				break;
			}
			ArrayList<Integer> row = new ArrayList<>();
			String[] rowToAdd = line.split(" ");
			numCol = rowToAdd.length;
			for (String e : rowToAdd) {
				row.add(Integer.parseInt(e));
				
			}
			numRow++;
			matrix.add(row);

		}
		

		ArrayList<ArrayList<Integer>> transpose = new ArrayList<>();
		
		for(int i = 0;i<numCol;i++) {
			ArrayList<Integer> rowNowCol = new ArrayList<>();
			for(int j =0;j<numRow;j++) {
				rowNowCol.add(matrix.get(j).get(i));
			}
			transpose.add(rowNowCol);
		}

		for(int i =0; i<numCol;i++) {
			for(int j =0; j<numRow;j++) {
				System.out.print((transpose.get(i).get(j)) + " ");
			}
			System.out.println();
		}
		
	}
}
