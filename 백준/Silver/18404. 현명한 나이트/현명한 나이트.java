import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static int N, M;
  static int[][] map;
  static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
  static int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken()); // N*N
    M = Integer.parseInt(st.nextToken()); // 상대 말의 개수

    map = new int[N + 1][N + 1]; // 1부터
    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= N; j++) {
        map[i][j] = -1; // 미방문 표시
      }
    }

    st = new StringTokenizer(br.readLine()); // 나이트 좌표값
    int X = Integer.parseInt(st.nextToken());
    int Y = Integer.parseInt(st.nextToken());

    // 모든 칸까지 최단거리(bfs)를 구하고 출력은 해당하는 칸만
    bfs(X, Y);


    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int ox = Integer.parseInt(st.nextToken());
      int oy = Integer.parseInt(st.nextToken());

      System.out.print(map[ox][oy] + " ");
    }
  }

  static void bfs(int x, int y) {
    Queue<int[]> q = new ArrayDeque<>();
    q.add(new int[] {x, y});
    map[x][y] = 0;

    while (!q.isEmpty()) {
      int[] cur = q.poll();
      int cx = cur[0];
      int cy = cur[1];

      for (int i = 0; i < 8; i++) {
        int nx = cx + dx[i];
        int ny = cy + dy[i];

        if (nx < 1 || nx > N || ny < 1 || ny > N)
          continue;
        if (map[nx][ny] != -1)
          continue;

        map[nx][ny] = map[cx][cy] + 1; // 이동거리+1
        q.add(new int[] {nx, ny});

      }

    }

  }
}
