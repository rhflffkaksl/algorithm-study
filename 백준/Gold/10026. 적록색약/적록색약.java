
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();
    picture = new char[N][N];
    for (int i = 0; i < N; i++) {
      String s = sc.next();
      for (int j = 0; j < N; j++) {
        picture[i][j] = s.charAt(j);
      }
    }

    cnt = 0;
    GRcnt = 0;
    visited = new boolean[N][N];
    GRvisited = new boolean[N][N];

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (!visited[i][j]) {
          visited[i][j] = true;
          cnt++;
          go(i, j, 0);// 적록색맹 X
        }
        if (!GRvisited[i][j]) {
          GRvisited[i][j] = true;
          GRcnt++;
          go(i, j, 1);// 적록색맹 O
        }
      }
    }
    System.out.println(cnt + " " + GRcnt);

  }

  static int N, cnt, GRcnt;
  static char[] dir;
  static char[][] picture;
  static boolean[][] visited;
  static boolean[][] GRvisited;
  static int[] dx = {1, 0, 0, -1}; // 좌상만 보기
  static int[] dy = {0, 1, -1, 0};


  static void go(int x, int y, int op) {
    // 상하좌우로 같은값이면 visited=true, go
    // R, G 같은걸로 취급하고 GRvisited=true, go


    for (int i = 0; i < 4; i++) {
      int x1 = dx[i] + x;
      int y1 = dy[i] + y;
      char cur = picture[x][y];

      // 좌상은 굳이 안봐도 될지도...아님!!!!!!!!!!
      if (op == 0 && !isboundary(x1, y1) && !visited[x1][y1] && picture[x1][y1] == cur) {
        visited[x1][y1] = true;
        go(x1, y1, 0);
      }

      if (op == 1 && !isboundary(x1, y1)) {
        char newpic = picture[x1][y1];

        if (picture[x1][y1] == 'G')
          newpic = 'R';
        if (cur == 'G')
          cur = 'R'; // R로 다 통일
        if (!GRvisited[x1][y1] && newpic == cur) {
          GRvisited[x1][y1] = true;
          go(x1, y1, 1);
        }
      }

    }


  }

  static boolean isboundary(int x, int y) {
    if (x < 0 || x >= N || y < 0 || y >= N)
      return true;
    return false;
  }

}
