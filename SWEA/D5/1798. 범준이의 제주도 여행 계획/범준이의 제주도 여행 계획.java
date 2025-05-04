import java.io.*;
import java.util.*;

public class Solution {
    static int N, M, airport, bestSat;
    static int[][] dist;
    static int[] playTime, score;
    static char[] type;
    static List<Integer> points, bestPath;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            dist = new int[N+1][N+1];
            for (int i = 1; i < N; i++) {
                st = new StringTokenizer(br.readLine().trim());
                for (int j = i+1; j <= N; j++) {
                    int d = Integer.parseInt(st.nextToken());
                    dist[i][j] = dist[j][i] = d;
                }
            }
            playTime = new int[N+1];
            score    = new int[N+1];
            type     = new char[N+1];
            points   = new ArrayList<>();
            airport  = -1;

            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine().trim());
                type[i] = st.nextToken().charAt(0);
                if (type[i]=='A') {
                    airport = i;
                } else if (type[i]=='P') {
                    playTime[i] = Integer.parseInt(st.nextToken());
                    score[i]    = Integer.parseInt(st.nextToken());
                    points.add(i);
                }
            }

            bestSat  = 0;
            bestPath = new ArrayList<>();
            List<Integer> path = new ArrayList<>();
            path.add(airport);
            dfs(1, airport, 0, 0L, 0, path);

            StringBuilder sb = new StringBuilder();
           // 출력부 수정연
		sb.append("#").append(tc).append(" ").append(bestSat);
		if (bestSat > 0) {
    		for (int i = 1; i < bestPath.size(); i++) {
        		sb.append(" ").append(bestPath.get(i));
  		  }
	}

            System.out.println(sb);
        }
    }

    static void dfs(int day, int cur, int timeUsed, long mask, int sat, List<Integer> path) {
        // 마지막날 공항 복귀
        if (day == M && timeUsed + dist[cur][airport] <= 540) {
            path.add(airport);
            if (sat > bestSat) {
                bestSat = sat;
                bestPath = new ArrayList<>(path);
            }
            path.remove(path.size()-1);
        }
        // 관광포인트 방문
        for (int nxt : points) {
            if ((mask & (1L<<nxt)) == 0) {
                int t = dist[cur][nxt] + playTime[nxt];
                if (timeUsed + t <= 540) {
                    path.add(nxt);
                    dfs(day, nxt, timeUsed + t, mask | (1L<<nxt), sat + score[nxt], path);
                    path.remove(path.size()-1);
                }
            }
        }
        // 다음날 호텔 복귀
        if (day < M) {
            for (int h = 1; h <= N; h++) {
                if (type[h]=='H' && timeUsed + dist[cur][h] <= 540) {
                    path.add(h);
                    dfs(day+1, h, 0, mask, sat, path);
                    path.remove(path.size()-1);
                }
            }
        }
    }
}
