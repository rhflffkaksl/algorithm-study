import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

  static class Node {
    int idx; // 원래 위치
    int num; // 중요도

    public Node(int idx, int num) {
      this.idx = idx;
      this.num = num;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int T = Integer.parseInt(br.readLine());

    StringTokenizer st;

    for (int t = 0; t < T; t++) {
      st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());

      // 중요도가 같은 경우 있을수있음
      Deque<Node> q = new ArrayDeque<Node>();

      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < N; i++) {
        q.offer(new Node(i, Integer.parseInt(st.nextToken())));
      }

      int cnt = 0;

      while (!q.isEmpty()) {
        Node temp = q.pop();

        boolean hasBigger = false;

        // 중요도가 더 큰게 있다면 뒤로
        for (Node node : q) {
          if (temp.num < node.num) {
            hasBigger = true;
            break;
          }
        }

        if (hasBigger) {
          q.offer(temp);
        } else {
          cnt++;

          if (temp.idx == M) {
            System.out.println(cnt);
            break;
          }
        }
      }

    }
  }
}
