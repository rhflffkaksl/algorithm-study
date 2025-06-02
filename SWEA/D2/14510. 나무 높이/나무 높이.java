
import java.util.Scanner;


public class Solution {


  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    for (int tc = 1; tc <= T; tc++) {
      int N = sc.nextInt();
      int[] trees = new int[N];

      int goal = 0;
      for (int i = 0; i < N; i++) {
        trees[i] = sc.nextInt();
        goal = Math.max(goal, trees[i]);// 최대 높이가 목표 높이
      }
      // --입력 끝--

      // 가능한 최소 날짜 수
      // 홀숫날 1, 짝숫날 2, 0
      int odd = 0, even = 0, nothing = 0;

      for (int i = 0; i < N; i++) {
        odd += (goal - trees[i]) % 2;
        even += (goal - trees[i]) / 2; 
      }

      // 짝숫날이 홀숫날+1 보다 더 많으면
      while (odd + 1 < even) {
        odd += 2;
        even--;
      }

      // 2 -> 1 0 1
      if (odd + 1 == even) {
        nothing++;
      }

      // 홀수가 많을때
      // 1 1 -> 1 0 1
      // 1 1 1 -> 1 0 1 0 1
      if (odd > even + 1) {
        nothing += odd - even - 1;
      }

      int answer = odd + even + nothing;

      System.out.println("#" + tc + " " + answer);
    }

  }

}
