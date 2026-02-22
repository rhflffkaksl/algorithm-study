import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    ArrayDeque<Integer> dq = new ArrayDeque<>();

    for (int i = 1; i <= N; i++) {
      dq.offer(i);
    }


    System.out.print("<");
    while (!dq.isEmpty()) {
      for (int i = 0; i < K - 1; i++) {
        dq.offer(dq.poll()); // K-1까지 빼고 넣기로 한칸씩 미루기
      }

      System.out.print(dq.pollFirst());

      if (!dq.isEmpty()) {
        System.out.print(", ");
      }
    }
    System.out.print(">");

  }
}
