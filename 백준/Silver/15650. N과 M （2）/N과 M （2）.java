import java.util.Scanner;

public class Main {
	static int n, m;
	static int[] arr;
	static boolean[] selected;
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		n = s.nextInt();
		m = s.nextInt();
		
		arr = new int[m];
		selected = new boolean[n+1];
		
		// 1부터 n까지의 자연수 중에서 중복 없이 m개를 고른 수열
		// 오름차
		recur(1, 0);
	}
	
	static void recur(int idx, int cnt) {
		// 기저조건
		if (cnt == m) {
			for (int i=0; i<m; i++) {
				System.out.print(arr[i]+ " ");
			}
			System.out.println();
			return;
		}
		
		
		for (int i=idx; i<=n; i++) {
			arr[cnt] = i;
			recur(i+1, cnt+1);
		}
	}

}
