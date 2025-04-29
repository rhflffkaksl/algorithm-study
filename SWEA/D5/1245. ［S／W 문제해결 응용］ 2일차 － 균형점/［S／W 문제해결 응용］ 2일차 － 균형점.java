

import java.util.Scanner;

public class Solution {
    static int[][] mag; // x좌표와 질량
    static int n; // 자석 개수
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트케이스 수

        for (int tc = 1; tc <= T; tc++) {
            n = sc.nextInt(); // 자석 개수
            mag = new int[n][2];

            for (int i = 0; i < n; i++) {
                mag[i][0] = sc.nextInt(); // x좌표 입력
            }
            for (int i = 0; i < n; i++) {
                mag[i][1] = sc.nextInt(); // 질량 입력
            }

            sb.append("#").append(tc);

            // 각 구간별 이분탐색
            for (int i = 1; i < n; i++) {
                double left = mag[i - 1][0];
                double right = mag[i][0];
                double mid = 0;
                double res;

                while (left < right && right - left > 1e-12) {
                    mid = (left + right) / 2;
                    res = cal(mid, i);
                    if (res == 0) {
                        break;
                    }
                    if (res < 0) { // 오른쪽 힘이 더 큼
                        right = mid;
                    } else { // 왼쪽 힘이 더 큼
                        left = mid;
                    }
                }

                sb.append(" ").append(String.format("%.10f", mid));
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    // 중간 지점에서 왼쪽과 오른쪽 인력 합 계산
    private static double cal(double mid, int idx) {
        double left = 0, right = 0;
        for (int i = 0; i < idx; i++) {
            left += mag[i][1] / ((mag[i][0] - mid) * (mag[i][0] - mid));
        }
        for (int i = idx; i < n; i++) {
            right += mag[i][1] / ((mag[i][0] - mid) * (mag[i][0] - mid));
        }
        return left - right;
    }
}
