import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine()); // 조각 개수

    long[][] arr = new long[N][2];

    StringTokenizer st;

    for (int i = 0; i < N; i++) { // 조각 순서는 고정
      st = new StringTokenizer(br.readLine());
      arr[i][0] = Integer.parseInt(st.nextToken()); // 재생 시간
      arr[i][1] = Integer.parseInt(st.nextToken()); // 다운 시간
    }

    long totalWait = arr[0][1]; // 초깃값 첫번째 조각 다운시간

    long left = 0; //남은 시간

    for (int i = 1; i < N; i++) {
      left+=arr[i-1][0]; //이전 곡 재생시간
      
      if (left < arr[i][1]) {
        totalWait += arr[i][1] - left;
        left = 0;
      } else {
        left -= arr[i][1];
      }
    }

    System.out.println(totalWait);
  }
}
