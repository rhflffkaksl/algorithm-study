import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int N;
    static int[][] map, dp;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());

            map = new int[N][N];
            dp = new int[N][N];

            for (int i = 0; i < N; i++) {
                String line = br.readLine();
                for (int j = 0; j < N; j++) {
                    map[i][j] = line.charAt(j) - '0';
                    dp[i][j] = Integer.MAX_VALUE;
                }
            }

            dp[0][0] = 0;

            // 전체 맵을 돌며 초기 호출
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    dfs(i, j);
                }
            }

            System.out.println("#" + tc + " " + dp[N - 1][N - 1]);
        }
    }

    static void dfs(int x, int y) {
        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;

            int newCost = dp[x][y] + map[nx][ny];

            if (dp[nx][ny] > newCost) {
                dp[nx][ny] = newCost;
                dfs(nx, ny);
            }
        }
    }
}
