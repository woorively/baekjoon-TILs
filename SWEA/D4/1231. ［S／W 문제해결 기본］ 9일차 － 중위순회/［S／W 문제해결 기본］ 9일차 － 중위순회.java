import java.util.*;

public class Solution {
	static int n;
	static char[] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int tc=1; tc<=10; tc++) {
			System.out.print("#" + tc + " ");
			
			n = sc.nextInt();
			arr = new char[n+1];
			
			for (int i=1; i<=n; i++) {
				sc.nextInt();
				arr[i] = sc.next().charAt(0);
				sc.nextLine();
			}
			
			dfs(1);
			System.out.println();	
		}

	}
	
	static void dfs(int cur) {
		if (cur > n) return;
		
		dfs(cur * 2);
		System.out.print(arr[cur]+"");
		dfs(cur * 2 + 1);
	}

}
