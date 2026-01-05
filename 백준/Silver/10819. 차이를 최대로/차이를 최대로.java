import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int N;
  static int[] A;
  static boolean[] visited;
  static int maxSum = 0;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());
    A = new int[N];
    visited = new boolean[N];

    for (int i = 0; i < N; i++) {
      A[i] = Integer.parseInt(st.nextToken());
    }

    gogo(new int[N], 0);

    System.out.println(maxSum);
  }

  static void gogo(int arr[], int cnt) {
    if (cnt == N) {
      int sum = 0;
      for (int i = 0; i < N - 1; i++) {
        sum += Math.abs(arr[i] - arr[i + 1]);
      }
      maxSum = Math.max(maxSum, sum);
      return;
    }

    for (int i = 0; i < N; i++) {
      if (!visited[i]) {
        visited[i] = true;
        arr[cnt] = A[i];
        gogo(arr, cnt + 1);
        visited[i] = false;
      }
    }
  }


}
