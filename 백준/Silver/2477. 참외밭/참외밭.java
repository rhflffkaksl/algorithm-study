import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int K = Integer.parseInt(st.nextToken());

    int[][] arr = new int[6][2];
    int maxH = 0;
    int maxW = 0;
    int idxH = 0;
    int idxW = 0;

    for (int i = 0; i < 6; i++) {
      st = new StringTokenizer(br.readLine());

      arr[i][0] = Integer.parseInt(st.nextToken());
      arr[i][1] = Integer.parseInt(st.nextToken());

      if (arr[i][0] == 1 || arr[i][0] == 2) {
        if (maxW < arr[i][1]) {
          idxW = i;
          maxW = arr[i][1];
        }
      } else {
        if (maxH < arr[i][1]) {
          idxH = i;
          maxH = arr[i][1];
        }
      }
    }

    // 작은 사각형
    int H = Math.abs(arr[(idxW + 1) % 6][1] - arr[(idxW + 5) % 6][1]);
    int W = Math.abs(arr[(idxH + 1) % 6][1] - arr[(idxH + 5) % 6][1]);

    System.out.println((maxW * maxH - W * H) * K);

  }
}
