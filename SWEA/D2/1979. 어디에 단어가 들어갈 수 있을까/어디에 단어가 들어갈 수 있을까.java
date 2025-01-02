import java.util.Scanner;

public class Solution {
	static int n, k, cnt;
	static int[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for (int tc = 1; tc <= t; tc++) {
			n = sc.nextInt();
			k = sc.nextInt();

			map = new int[n][n];

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			cnt = 0;
			// 가로 검사
			for (int i = 0; i < n; i++) {
				for (int j = 0; j <= n - k; j++) {
					boolean flag = true;
					
					for (int p = 0; p < k; p++) {
						if (map[i][j + p] == 0) {
							flag = false;
							break;
						}
					}
					
					if (flag && (j + k == n || map[i][j + k] == 0) && (j == 0 || map[i][j - 1] == 0)) {
						cnt++;
					}
				}
			}

			// 세로 검사
			for (int j = 0; j < n; j++) {
				for (int i = 0; i <= n - k; i++) {
					boolean flag = true;

					for (int p = 0; p < k; p++) {
						if (map[i + p][j] == 0) {
							flag = false;
							break;
						}
					}

					if (flag && (i + k == n || map[i + k][j] == 0) && (i == 0 || map[i - 1][j] == 0)) {
						cnt++;
					}
				}
			}

			System.out.println("#" + tc + " " + cnt);
		}
	}
}
