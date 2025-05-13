import java.util.*;

public class Solution {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][] board = new int[4][4];
    static Set<String> set;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    board[i][j] = sc.nextInt();
                }
            }
            set = new HashSet<>();
            // 모든 시작점에서 DFS
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    dfs(i, j, 1, String.valueOf(board[i][j]));
                }
            }
            System.out.println("#" + tc + " " + set.size());
        }
        sc.close();
    }

    static void dfs(int x, int y, int depth, String num) {
        if (depth == 7) {
            set.add(num);
            return;
        }
        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if (nx < 0 || nx >= 4 || ny < 0 || ny >= 4) continue;
            dfs(nx, ny, depth + 1, num + board[nx][ny]);
        }
    }
}
