import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {
  int to;
  long w;

  public Edge(int to, long w) {
    this.to = to;
    this.w = w;
  }

  @Override
  public int compareTo(Edge o) {
    return (int) (this.w - o.w);
  }
}


public class Main {
  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    int N = Integer.parseInt(br.readLine());

    List<List<Edge>> gugu = new ArrayList<>();
    for (int i = 0; i <= N; i++) {
      gugu.add(new ArrayList<>());
    }

    for (int i = 0; i < N - 1; i++) {
      // 입력 : a,b,c -> a와 b 연결길이가 c (양방향)
      StringTokenizer st = new StringTokenizer(br.readLine());

      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());

      gugu.get(a).add(new Edge(b, c));
      gugu.get(b).add(new Edge(a, c));
    }

    // 최대한 입구에서 먼 방에 아이스크림을 숨김. 이동거리를 구하여라.
    // 각 방까지의 거리 최솟값을 구하고 그 중 최댓값 구하기
    long[] dist = new long[N + 1]; // 1~N
    boolean[] visited = new boolean[N + 1];
    Arrays.fill(dist, Long.MAX_VALUE);

    PriorityQueue<Edge> pq = new PriorityQueue<>();
    dist[1] = 0; // 시작점
    pq.add(new Edge(1, 0));

    while (!pq.isEmpty()) {
      Edge cur = pq.poll();

      if (!visited[cur.to]) {
        visited[cur.to] = true;

        for (Edge next : gugu.get(cur.to)) {// 인접 노드 확인
          long newd = dist[cur.to] + next.w;
          if (newd < dist[next.to]) {
            dist[next.to] = newd; // 최솟값 갱신
            pq.add(new Edge(next.to, newd));
          }
        }
      }
    }

    long Max = 0;
    for (int i = 1; i <= N; i++) {
      Max = Math.max(Max, dist[i]);
    }
    System.out.println(Max);

  }
}