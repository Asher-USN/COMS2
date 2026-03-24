
public class Program {
//2864809
	public static int[] scale(int[] arr, int s) {
		int size = arr.length;
		for(int i = 0; i<size;i++) {
			arr[i] = arr[i]*s;
		}
		return arr;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] toSend = {4,9,2,7};
		int []result = scale(toSend, 4);
		System.out.println(result);
	}

}
