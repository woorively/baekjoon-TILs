import java.util.Scanner;

public class Solution {
	static int ans;
	static int[][] maze;
	static int[] drs = {1, -1, 0, 0};
	static int[] dcs = {0, 0, -1, 1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int tc=1; tc<=10; tc++) {
			int T = sc.nextInt();
			ans = 0;
			maze = new int[16][16];
			
			for (int i=0; i<16; i++) {
				String str = sc.next();
				for (int j=0; j<16; j++) {
					maze[i][j] = str.charAt(j) - '0';
				}
			}
			
			maze[1][1] = 1;
			dfs(1, 1);
			
			System.out.println("#" + T + " " + ans);
		}
	}
	
	static void dfs(int r, int c) {
		
		for (int d=0; d<4; d++) {
			int nr = r + drs[d];
			int nc = c + dcs[d];
			
			if (inRange(nr, nc) && maze[nr][nc] != 1) {
				if (maze[nr][nc] == 3) {
					ans = 1;
					return;
				}
				maze[nr][nc] = 1;
				dfs(nr, nc);
			}
		}
	}
	
	static boolean inRange(int r, int c) {
		return 0 <= r && r < 16 && 0 <= c && c < 16;
	}
}
