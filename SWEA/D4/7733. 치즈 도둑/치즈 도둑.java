import java.util.Scanner;

public class Solution {
	static int n, day;
	static int[][] map;
	static boolean[][] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc=1; tc<=T; tc++) {
			n = sc.nextInt();
			map = new int[n][n];
			for (int i=0; i<n; i++) {
				for (int j=0; j<n; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			int ans = 1;
			for (day=1; day<=100; day++) {
				int r = 0, c = 0;
				visited = new boolean[n][n];
				int cnt = 0;
				
				for (int i=0; i<n; i++) {
					for (int j=0; j<n; j++) {
						if (visited[i][j] || map[i][j] <= day) 
							continue;
						dfs(i, j);
						cnt++;
					}
					
					ans = Math.max(ans, cnt);
				}
			}
			
			
			System.out.println("#" + tc + " " + ans);
		}
	}
	
	static void dfs(int r, int c) {
		int[] dr = {1, -1, 0, 0};
		int[] dc = {0, 0, 1, -1};
		
		for (int d=0; d<4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if (canGo(nr, nc)) {
				visited[nr][nc] = true;
				dfs(nr, nc);
			}
		}
	}
	
	static boolean canGo(int r, int c) {
		return 0 <= r && r < n && 0 <= c && c < n 
				&& !visited[r][c] && map[r][c] > day;
	}
}
