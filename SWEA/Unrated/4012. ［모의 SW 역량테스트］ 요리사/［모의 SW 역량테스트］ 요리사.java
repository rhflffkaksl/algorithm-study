import java.io.*;
import java.util.*;

public class Solution {
    static int N, minDiff;
    static int[][] synergy;
    static boolean[] selected;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine()); 

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            synergy = new int[N][N];
            selected = new boolean[N];
            minDiff = Integer.MAX_VALUE;

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    synergy[i][j] = Integer.parseInt(st.nextToken());
                }
            }

           
            combination(0, 0);

            sb.append("#").append(t).append(" ").append(minDiff).append("\n");
        }
        System.out.print(sb);
    }

    // 조합 - N개의 재료 중 N/2개 선택
    static void combination(int idx, int count) {
        if (count == N / 2) {
            calculateMinDiff();
            return;
        }
        if (idx >= N) return;

        // 현재 재료 선택
        selected[idx] = true;
        combination(idx + 1, count + 1);

        // 현재 재료 선택 취소
        selected[idx] = false;
        combination(idx + 1, count);
    }

   
    static void calculateMinDiff() {
        int teamA = 0, teamB = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (selected[i] && selected[j]) {
                    teamA += synergy[i][j] + synergy[j][i]; // 팀 A 시너지 합
                } else if (!selected[i] && !selected[j]) {
                    teamB += synergy[i][j] + synergy[j][i]; // 팀 B 시너지 합
                }
            }
        }

        // 최소 차이 갱신
        minDiff = Math.min(minDiff, Math.abs(teamA - teamB));
    }
}
