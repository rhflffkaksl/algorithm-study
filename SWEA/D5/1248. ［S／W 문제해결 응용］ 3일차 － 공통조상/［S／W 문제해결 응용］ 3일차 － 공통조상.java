import java.io.*;
import java.util.*;

public class Solution {
    static List<Integer>[] tree;
    static int[] depth, parent, subtreeSize;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V  = Integer.parseInt(st.nextToken());
            int E  = Integer.parseInt(st.nextToken());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            tree = new ArrayList[V + 1];
            depth = new int[V + 1];
            parent = new int[V + 1];
            subtreeSize = new int[V + 1];
            // 0부터 V까지 모두 초기화
            for (int i = 0; i <= V; i++) {
                tree[i] = new ArrayList<>();
                parent[i] = 0;
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < E; i++) {
                int p = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                parent[c] = p;
                tree[p].add(c);
            }
            // 루트(1번)의 부모를 자기 자신으로 설정
            parent[1] = 1;

            initializeDepth(1, 1);
            int lca = findLowestCommonAncestor(n1, n2);
            calculateSubtreeSize(1);

            sb.append('#').append(tc).append(' ')
              .append(lca).append(' ')
              .append(subtreeSize[lca]).append('\n');
        }

        System.out.print(sb);
    }

    // 깊이 정보 초기화 DFS
    static void initializeDepth(int node, int d) {
        depth[node] = d;
        for (int child : tree[node]) {
            initializeDepth(child, d + 1);
        }
    }

    // 가장 가까운 공통 조상 찾기
    static int findLowestCommonAncestor(int a, int b) {
        while (depth[a] > depth[b]) a = parent[a];
        while (depth[b] > depth[a]) b = parent[b];
        while (a != b) {
            a = parent[a];
            b = parent[b];
        }
        return a;
    }

    // 서브트리 크기 계산 DFS
    static int calculateSubtreeSize(int node) {
        int size = 1;
        for (int child : tree[node]) {
            size += calculateSubtreeSize(child);
        }
        return subtreeSize[node] = size;
    }
}
