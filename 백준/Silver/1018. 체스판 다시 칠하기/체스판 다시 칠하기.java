import java.util.*;

public class Main {
    static char[][] board;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();

        board = new char[N][M];
        for (int i = 0; i < N; i++) {
            board[i] = sc.nextLine().toCharArray();
        }

        int min = Integer.MAX_VALUE;

        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                min = Math.min(min, countRepaint(i, j));
            }
        }

        System.out.println(min);
    }

    // 8x8 영역에서 다시 칠해야 할 최소 칸 수
    static int countRepaint(int x, int y) {
        int countW = 0; // W로 시작
        int countB = 0; // B로 시작

        for (int i = x; i < x + 8; i++) {
            for (int j = y; j < y + 8; j++) {
                char expectedW = ((i + j) % 2 == 0) ? 'W' : 'B';
                char expectedB = ((i + j) % 2 == 0) ? 'B' : 'W';

                if (board[i][j] != expectedW) countW++;
                if (board[i][j] != expectedB) countB++;
            }
        }
        return Math.min(countW, countB);
    }
}
