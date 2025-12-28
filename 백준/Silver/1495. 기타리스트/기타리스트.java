import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken()); // 곡 개수
    int S = Integer.parseInt(st.nextToken()); // 시작 볼륨
    int M = Integer.parseInt(st.nextToken()); // 최대 볼륨

    int[] V = new int[N + 1]; // 각 곡마다 +V or -V
    st = new StringTokenizer(br.readLine());

    // 각 곡마다 가능한 볼륨
    boolean[][] dp = new boolean[N + 1][M + 1]; // 볼륨 0부터 M까지
    dp[0][S] = true;

    for (int i = 1; i < N + 1; i++) {
      V[i] = Integer.parseInt(st.nextToken());
    }

    for (int i = 1; i < N + 1; i++) {
      for (int j = 0; j < M + 1; j++) {
        if (dp[i - 1][j]) {
          if (j + V[i] <= M)
            dp[i][j + V[i]] = true;
          if (j - V[i] >= 0)
            dp[i][j - V[i]] = true;
        }
      }

    }

    int answer = -1;
    for (int i = 0; i < M + 1; i++) {
      // 최댓값 찾기
      if (dp[N][i])
        answer = i;
    }
    System.out.println(answer);
  }
}
