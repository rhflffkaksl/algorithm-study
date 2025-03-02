import java.util.ArrayList;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    for (int t = 1; t <= T; t++) {
      int V = sc.nextInt();
      int E = sc.nextInt();
      // 이분 그래프 판별(사이클이 생기지 않으면 된다)
      // 인접 리스트로 구현
      l1 = new ArrayList[V + 1];
      visited = new boolean[V + 1];
      check = new int[V + 1];

      // 이거 해줘야 함 리스트배열 돌면서 각각 초기화
      for (int i = 1; i <= V; i++) {
        l1[i] = new ArrayList<Integer>();
      }



      // 노드 저장
      for (int i = 0; i < E; i++) {

        int a = sc.nextInt();
        int b = sc.nextInt();

        // 방향이 없으므로 양쪽으로 넣어줘야함!!
        l1[a].add(b);
        l1[b].add(a);
      }
      isEven = true;
      // 각 노드별로 dfs 실행
      for (int i = 1; i < V; i++) {
        if (isEven) {
          dfs(i);
        } else
          break;
      }
      if (isEven)
        System.out.println("YES");
      else
        System.out.println("NO");


    }
  }

  private static int check[];
  private static boolean visited[];
  private static ArrayList<Integer>[] l1;
  private static boolean isEven;

  private static void dfs(int a) {
    visited[a] = true;

    // 중요
    for (int i : l1[a]) {

      if (!visited[i]) {
        check[i] = (check[a] + 1) % 2;// 1,0으로 분류
        // 바로 직전에 있는 노드와 다른 집합으로 분류를
        // 해주는 것이 필요


        dfs(i);
      } else {//방문한 노드인데
        if (check[a] == check[i]) {//이전과 같은 집합이면
          isEven = false;
        }
      }
    }
  }

}