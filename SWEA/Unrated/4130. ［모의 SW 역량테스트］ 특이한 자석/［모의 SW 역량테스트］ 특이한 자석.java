import java.util.*;

public class Solution {
    static int[][] gears = new int[4][8];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();  

        for (int t = 1; t <= T; t++) {
            int K = sc.nextInt();  // 회전 수

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 8; j++) {
                    gears[i][j] = sc.nextInt();
                }
            }

            for (int k = 0; k < K; k++) {
                int num = sc.nextInt() - 1; // 자석 번호 
                int dir = sc.nextInt();     // 방향

                int[] dirs = new int[4];    // 자석별 회전 방향 저장
                dirs[num] = dir;

                // 왼쪽으로 전파
                for (int i = num - 1; i >= 0; i--) {
                    if (gears[i][2] != gears[i + 1][6]) {
                        dirs[i] = -dirs[i + 1];
                    } else break;
                }

                // 오른쪽으로 전파
                for (int i = num + 1; i < 4; i++) {
                    if (gears[i - 1][2] != gears[i][6]) {
                        dirs[i] = -dirs[i - 1];
                    } else break;
                }

                // 실제 회전
                for (int i = 0; i < 4; i++) {
                    if (dirs[i] != 0) rotate(i, dirs[i]);
                }
            }

            // 점수 계산
            int score = 0;
            for (int i = 0; i < 4; i++) {
                if (gears[i][0] == 1) score += (1 << i);
            }

            System.out.println("#" + t + " " + score);
        }
    }

    static void rotate(int idx, int dir) {
        if (dir == 1) {  // 시계방향
            int tmp = gears[idx][7];
            for (int i = 7; i > 0; i--) {
                gears[idx][i] = gears[idx][i - 1];
            }
            gears[idx][0] = tmp;
        } else {         // 반시계방향
            int tmp = gears[idx][0];
            for (int i = 0; i < 7; i++) {
                gears[idx][i] = gears[idx][i + 1];
            }
            gears[idx][7] = tmp;
        }
    }
}
