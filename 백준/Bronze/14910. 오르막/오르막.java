import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = st.countTokens(); //
    int prev = Integer.parseInt(st.nextToken());
    boolean answer = true;

    for (int i = 1; i < N; i++) {
      int cur = Integer.parseInt(st.nextToken());
      if (prev > cur) {// 내림차순이 아님
        answer = false;
        break;
      }
      prev = cur;
    }
    System.out.println(answer ? "Good" : "Bad");
  }
}
