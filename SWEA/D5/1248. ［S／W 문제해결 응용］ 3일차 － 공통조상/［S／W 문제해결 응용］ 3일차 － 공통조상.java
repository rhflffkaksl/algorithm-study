import java.util.*;

public class Solution {
    static final int MAXV = 10000;
    static final int MAXLOG = 14;  // 2^14 = 16384 > 10000

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int V = sc.nextInt();
            int E = sc.nextInt();
            int u = sc.nextInt();
            int v = sc.nextInt();

            int[][] parent = new int[MAXLOG+1][V+1];
            int[] depth = new int[V+1];
            List<Integer>[] children = new ArrayList[V+1];
            for (int i = 1; i <= V; i++) {
                children[i] = new ArrayList<>();
            }

            // 부모 정보 입력
            for (int i = 0; i < E; i++) {
                int p = sc.nextInt();
                int c = sc.nextInt();
                parent[0][c] = p;
                children[p].add(c);
            }

            // 깊이 계산 (루트=1)
            Queue<Integer> q = new LinkedList<>();
            depth[1] = 1;
            q.add(1);
            while (!q.isEmpty()) {
                int cur = q.poll();
                for (int ch : children[cur]) {
                    depth[ch] = depth[cur] + 1;
                    q.add(ch);
                }
            }

            // DP
            for (int k = 1; k <= MAXLOG; k++) {
                for (int i = 1; i <= V; i++) {
                    parent[k][i] = parent[k-1][ parent[k-1][i] ];
                }
            }

            // LCA 계산
            int lca = getLCA(u, v, depth, parent);

            int[] subtree = new int[V+1];
            List<Integer> order = new ArrayList<>();
            Stack<Integer> st = new Stack<>();
            st.push(1);
            while (!st.isEmpty()) {
                int x = st.pop();
                order.add(x);
                for (int ch : children[x]) {
                    st.push(ch);
                }
            }
            // 역순으로 합산
            for (int i = order.size()-1; i >= 0; i--) {
                int x = order.get(i);
                subtree[x] = 1;
                for (int ch : children[x]) {
                    subtree[x] += subtree[ch];
                }
            }

            System.out.println("#" + tc + " " + lca + " " + subtree[lca]);
        }
        sc.close();
    }

    // 이진 리프팅으로 LCA 구하기
    static int getLCA(int a, int b, int[] depth, int[][] parent) {
        if (depth[a] < depth[b]) {
            int t = a; a = b; b = t;
        }
        // 깊이 맞추기
        int diff = depth[a] - depth[b];
        for (int k = 0; k <= MAXLOG; k++) {
            if ((diff & (1 << k)) != 0) {
                a = parent[k][a];
            }
        }
        if (a == b) return a;

        // 공통 조상 찾기
        for (int k = MAXLOG; k >= 0; k--) {
            if (parent[k][a] != parent[k][b]) {
                a = parent[k][a];
                b = parent[k][b];
            }
        }
        return parent[0][a];
    }
}
