import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    static int S;   // 판 크기
    static int N;   // 손상 지점 개수
    static int[][] map; // 손상 좌표 표시용 배열
    static List<int[]> ans = new ArrayList<>(); // 도금 결과 저장 리스트

    // 지정한 위치(r, c)에서 size×size 범위 내에 손상(1)이 몇 개 있는지 센다
    public static int getDamage(int r, int c, int size) {
        int cnt = 0;
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (map[i][j] == 1) cnt++;
            }
        }
        return cnt;
    }

    // 해당 영역을 도금 완료했다고 보고 전부 0으로 바꿈
    public static void restore(int r, int c, int size) {
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                map[i][j] = 0;
            }
        }
    }

    public static void solve() {
        // 그리디 핵심 전략
        // 큰 범위(3x3)부터 가능한 곳에 도금 -> 손상 많이 덮을수록 우선시
        // 손상 많이 덮는 3x3 먼저 처리 (덮는 손상 수 = 9 ~ 5)
        for (int damage = 9; damage >= 5; damage--) {
            for (int i = 0; i <= S - 3; i++) {
                for (int j = 0; j <= S - 3; j++) {
                    if (getDamage(i, j, 3) == damage) {
                        restore(i, j, 3); // 도금 처리
                        ans.add(new int[] {i, j, 3});
                    }
                }
            }
        }

        // 중간 범위(2x2) 도금 처리 (덮는 손상 수 = 4 ~ 2)
        for (int damage = 4; damage >= 2; damage--) {
            for (int i = 0; i <= S - 2; i++) {
                for (int j = 0; j <= S - 2; j++) {
                    if (getDamage(i, j, 2) == damage) {
                        restore(i, j, 2);
                        ans.add(new int[] {i, j, 2});
                    }
                }
            }
        }

        // 남은 손상은 1x1 도금으로 처리 (덮는 손상 수 = 1)
        for (int i = 0; i < S; i++) {
            for (int j = 0; j < S; j++) {
                if (map[i][j] == 1) {
                    map[i][j] = 0;
                    ans.add(new int[] {i, j, 1});
                }
            }
        }
        //  작은 범위는 큰 범위로 커버되지 못한 잔여 손상을 마무리 용도로 처리
    }

    public static void test(int testNo) {
        ans.clear(); // 테스트마다 결과 초기화
        solve();     // 도금 처리 시작

        // 출력 형식에 맞게 작성
        System.out.print("#" + testNo + " " + ans.size() + " ");
        StringBuilder sb = new StringBuilder();
        for (int[] tmp : ans) {
            sb.append(tmp[0] + 1).append(" ").append(tmp[1] + 1).append(" ").append(tmp[2]).append(" ");
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            S = Integer.parseInt(br.readLine());
            N = Integer.parseInt(br.readLine());

            map = new int[S][S];
            for (int[] row : map) Arrays.fill(row, 0);

            String[] tmp = br.readLine().split(" ");
            for (int i = 0; i < N; i++) {
                int x = Integer.parseInt(tmp[2 * i]);
                int y = Integer.parseInt(tmp[2 * i + 1]);
                map[x - 1][y - 1] = 1; // 입력은 1-based, 내부는 0-based
            }

            test(tc);
        }
    }
}
