import java.util.Scanner;

public class Main {
  // 부분집합
  // 1억번연산->1초(테케 하나당)

  private static int N;
  private static int[] S;
  private static int[] B;
  private static boolean[] isSelected;

  private static int min;


  public static void main(String[] args) throws Exception {

    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();
    S = new int[N];
    B = new int[N];
    for (int i = 0; i < N; i++) {
      S[i] = sc.nextInt();
      B[i] = sc.nextInt();
    }

    min = Integer.MAX_VALUE;
    isSelected = new boolean[N];


    // 재료는 적어도 한개 이상

    subset(0);
    System.out.println(min);

  }

  private static void subset(int cnt) {
    if (cnt == N) {
      int resultS = 1;
      int resultB = 0;

      int selectedCnt = 0;
      for (int i = 0; i < N; i++) {
        if (isSelected[i]) {
          selectedCnt++;// 재료가 선택된 개수
          resultS *= S[i];// 신맛은 재료의 곱,
          resultB += B[i];// 쓴맛은 합
        }
      }
      if (selectedCnt > 0) { // 재료가 한개 이상 사용되면
        int result = Math.abs(resultS - resultB);
        if (result < min) {
          min = result; // 결과의 최솟값 업데이트
        }
      }
      return;
    }
    // 원소 선택
    isSelected[cnt] = true;
    subset(cnt + 1);

    // 원소 미선택
    isSelected[cnt] = false;
    subset(cnt + 1);

  }
}