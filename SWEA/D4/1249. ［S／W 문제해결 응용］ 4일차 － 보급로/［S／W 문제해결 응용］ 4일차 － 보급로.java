import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static int N;
    static int[][] map, dist;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static class Point implements Comparable<Point> {
        int x, y, cost;

        public Point(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        public int compareTo(Point o) {
            return this.cost - o.cost; // 비용 적은 게 먼저
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            dist = new int[N][N];

            for (int i = 0; i < N; i++) {
                String line = br.readLine();
                for (int j = 0; j < N; j++) {
                    map[i][j] = line.charAt(j) - '0';
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }

            dijkstra();

            System.out.println("#" + tc + " " + dist[N - 1][N - 1]);
        }
    }

    static void dijkstra() {
        PriorityQueue<Point> pq = new PriorityQueue<>();
        dist[0][0] = 0;
        pq.offer(new Point(0, 0, 0));

        while (!pq.isEmpty()) {
            Point now = pq.poll();

            if (now.cost > dist[now.x][now.y]) continue;

            for (int dir = 0; dir < 4; dir++) {
                int nx = now.x + dx[dir];
                int ny = now.y + dy[dir];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;

                int newCost = dist[now.x][now.y] + map[nx][ny];

                if (newCost < dist[nx][ny]) {
                    dist[nx][ny] = newCost;
                    pq.offer(new Point(nx, ny, newCost));
                }
            }
        }
    }
}
