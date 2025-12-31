import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int D;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    D = Integer.parseInt(st.nextToken()); // 일수
    int K = Integer.parseInt(st.nextToken()); // 해당 일의 떡 개수
    // 피보나치 수열에서 P0, P1을 구하여라.

    int[] v = p(1, 1, 3);

    int A = 1, B = 1;

    for (A = 1; A * v[0] < K; A++) {
      if ((K - (v[0] * A)) % v[1] == 0) {
        B = (K - (v[0] * A)) / v[1];
        System.out.println(A + "\n" + B);
        break;
      }

    }
  }

  static int[] p(int p1, int p2, int d) {
    if (d >= D) {
      return new int[] {p1, p2};
    }

    int p3 = p1 + p2;
    return p(p2, p3, d + 1);
  }
}
