import java.util.Scanner;

public class Solution {
    static int D, W, K, min;
    static int[][] film, temp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            D = sc.nextInt();
            W = sc.nextInt();
            K = sc.nextInt();
            film = new int[D][W];
            temp = new int[D][W];

            for (int i = 0; i < D; i++)
                for (int j = 0; j < W; j++)
                    film[i][j] = sc.nextInt();

            min = K; // 최대 약품 투입 횟수는 K
            if (check(film)) {
                System.out.println("#" + tc + " 0");
                continue;
            }

            dfs(0, 0);
            System.out.println("#" + tc + " " + min);
        }
        sc.close();
    }

    static void dfs(int depth, int cnt) {
        if (cnt >= min) return;

        if (depth == D) {
            if (check(temp))
                min = cnt;
            return;
        }

        // 원본 유지
        for (int i = 0; i < W; i++)
            temp[depth][i] = film[depth][i];
        dfs(depth + 1, cnt);

        // 약품 A 투입
        for (int i = 0; i < W; i++)
            temp[depth][i] = 0;
        dfs(depth + 1, cnt + 1);

        // 약품 B 투입
        for (int i = 0; i < W; i++)
            temp[depth][i] = 1;
        dfs(depth + 1, cnt + 1);
    }

    static boolean check(int[][] arr) {
        for (int j = 0; j < W; j++) {
            int cnt = 1;
            boolean pass = false;
            for (int i = 1; i < D; i++) {
                if (arr[i][j] == arr[i - 1][j])
                    cnt++;
                else
                    cnt = 1;

                if (cnt >= K) {
                    pass = true;
                    break;
                }
            }
            if (!pass)
                return false;
        }
        return true;
    }
}
