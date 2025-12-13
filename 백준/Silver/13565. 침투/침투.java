import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

  static int[][] map;
  static boolean[][] isVisited;
  static int M, N;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    M = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());

    map = new int[M][N];
    isVisited = new boolean[M][N];

    for (int i = 0; i < M; i++) {
      String line = br.readLine();
      // 0은 전류 O, 1은 전류 X
      // 위에서부터 아래까지 전달되는지
      for (int j = 0; j < N; j++) {
        map[i][j] = line.charAt(j) - '0';
      }
    }

    for (int j = 0; j < N; j++) {
      if (map[0][j] == 0 && !isVisited[0][j]) {
        dfs(0, j);
      }
    }

    boolean answer = false;
    for (int j = 0; j < N; j++) {
      if (isVisited[M - 1][j])
        answer = true;
    }

    System.out.println(answer ? "YES" : "NO");
  }

  static void dfs(int i, int j) {
    isVisited[i][j] = true;

    for (int k = 0; k < 4; k++) {
      int newi = i + dir[k][0];
      int newj = j + dir[k][1];

      if (!isBoundary(newi, newj) && !isVisited[newi][newj] && map[newi][newj] == 0) {
        dfs(newi, newj);
      }
    }
  }

  static int[][] dir = {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};

  static boolean isBoundary(int i, int j) {
    if (i < M && j < N && i >= 0 && j >= 0)
      return false;
    return true;
  }
}
