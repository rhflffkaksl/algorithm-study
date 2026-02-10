import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // N과 M이 모두 0으로 주어지는 행이 인풋의 마지막입니다.
    while (true) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());

      int[] score = new int[10001];

      int first = -1;
      int second = -1;

      if (N == 0 && M == 0)
        break;

      for (int i = 0; i < N; i++) {
        st = new StringTokenizer(br.readLine());

        for (int j = 0; j < M; j++) {
          // 선수 번호별로 횟수 저장
          score[Integer.parseInt(st.nextToken())]++;
        }
      }

      for (int i = 1; i <= 10000; i++) {
        if (score[i] > first) {
          second = first;
          first = score[i];
        } else if (score[i] > second && score[i] < first) {
          second = score[i];
        }
      }

      for (int i = 1; i <= 10000; i++) {
        if (score[i] == second)
          System.out.print(i + " ");
      }
      System.out.println();
    }

  }

}
