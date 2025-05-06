import java.io.*;
import java.util.*;
//비트 마스크 써보기!!
public class Solution {
    static int N, M, maxLen;
    static List<Integer>[] point;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            point = new ArrayList[N+1];
            for (int i = 1; i <= N; i++) {
                point[i] = new ArrayList<>();
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine().trim());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                point[x].add(y);
                point[y].add(x);
            }

            maxLen = 0;

            for (int i = 1; i <= N; i++) {
                dfs(i, 1 << (i-1), 1);
            }

            System.out.println("#" + tc + " " + maxLen);
        }
    }


    static void dfs(int u, int visited, int len) {
        if (len > maxLen) {
            maxLen = len;
        }
        for (int v : point[u]) {
            int bit = 1 << (v-1);
            if ((visited & bit) == 0) {
                dfs(v, visited | bit, len + 1);
            }
        }
    }
}
