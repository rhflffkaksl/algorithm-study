

import java.util.Scanner;

public class Solution {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    for (int tc = 1; tc <= T; tc++) {
      N = sc.nextInt();
      B = sc.nextInt();

      H = new int[N];
      min = Integer.MAX_VALUE;

      int totalSum = 0;

      for (int i = 0; i < N; i++) {
        H[i] = sc.nextInt();
        totalSum += H[i];
      }



      if (totalSum > B)
        subset(0, 0);
      else
        min = 0;

      System.out.println("#" + tc + " " + min);
    }
  }

  static int N, B, min;
  static int[] H;

  // 부분집합
  static void subset(int start, int sum) {

    if (sum >= B) {
      min = Math.min(min, sum - B);
      return;
    }
    // 모든 점원을 고려했으면 종료
    if (start == N) {
      return;
    }
//for문 부분집합 방식!!!!
// 현재 원소를 고려하지 않은 상태는 이미 for문 전에 결정됨(즉, 아무것도 추가하지 않은 채로 for문 시작)
    for (int i = start; i < N; i++) {
        // 현재 원소 포함하는 경우만 한 번 재귀 호출
        subset(i + 1, sum + H[i]);
    }


  }

}
