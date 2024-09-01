import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int n, m;
	static int[] arr;
	static ArrayList<Integer> result;
	static StringBuilder sb;
	
	public static void main(String[] args) {
		sb = new StringBuilder();
		Scanner s = new Scanner(System.in);
		n = s.nextInt();
		m = s.nextInt();
		
		arr = new int[n];
		result = new ArrayList<>();
		
		for (int i=0; i<n; i++) {
			arr[i] = s.nextInt();
		}
		Arrays.sort(arr);
		
		recur(0);
		System.out.println(sb);
	}
	
	static void recur(int depth) {
		if (depth == m) {
			for (int num: result) {
				sb.append(num).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		// 1부터 n까지 뽑는데,
		for (int i=0; i<n; i++) {
			result.add(arr[i]);
			recur(depth+1);
			result.remove(result.size()-1);
		}
	}

}
