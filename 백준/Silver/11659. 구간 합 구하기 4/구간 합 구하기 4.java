import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    int[] dp = new int[N + 1];

    st = new StringTokenizer(br.readLine());

    for (int i = 1; i <= N; i++) {
      int num = Integer.parseInt(st.nextToken());
      dp[i] = dp[i - 1] + num;
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int I = Integer.parseInt(st.nextToken());
      int J = Integer.parseInt(st.nextToken());

      int sum = dp[J] - dp[I - 1];
      System.out.println(sum);
    }

  }
}
