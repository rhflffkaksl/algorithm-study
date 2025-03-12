

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
  static class Location {
    public int x;
    public int y;

    public Location(int x, int y) {
      this.x = x;
      this.y = y;
    }

  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    for (int tc = 1; tc <= T; tc++) {
      N = Integer.parseInt(br.readLine());
      StringTokenizer st = new StringTokenizer(br.readLine());

      // 회사 좌표
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      Location company = new Location(x, y);

      // 집 좌표
      x = Integer.parseInt(st.nextToken());
      y = Integer.parseInt(st.nextToken());
      home = new Location(x, y);

      // 고객 좌표 N개
      customers = new Location[N];
      for (int i = 0; i < N; i++) {
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        customers[i] = new Location(x, y);

      }

      // 회사에서 출발
      MIN = Integer.MAX_VALUE;
      visited = new boolean[N];
      go(company, 0, 0);

      System.out.println("#" + tc + " " + MIN);

    }

  }

  static int N, MIN;
  static boolean[] visited;
  static Location home;
  static Location[] customers;

  static int distance(Location lc1, Location lc2) {
    return Math.abs(lc1.x - lc2.x) + Math.abs(lc1.y - lc2.y);
  }

  static void go(Location lc, int cnt, int distSum) {
    if (cnt == N) {// 모든 고객을 방문함
      distSum += distance(lc, home);
      MIN = Math.min(MIN, distSum);
      return;
    }

    if (distSum > MIN)
      return;

    // 순열
    for (int i = 0; i < N; i++) {
      // 방문하지 않았다면
      if (!visited[i]) {
        visited[i] = true;
        int newdistSum = distSum + distance(lc, customers[i]);
        go(customers[i], cnt + 1, newdistSum);
        visited[i] = false;
      }
    }

  }

}
