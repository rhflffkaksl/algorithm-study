import java.util.Scanner;

public class Solution {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    for (int test_case = 1; test_case <= T; test_case++) {
      int N = sc.nextInt();
      int count = 0;
      int[] p = new int[N + 1];
      for (int i = 1; i <= N; i++) {
        p[i] = sc.nextInt();
      }
      for (int i = 2; i <= N - 1; i++) {
        if ((p[i - 1] < p[i] && p[i] < p[i + 1]) || (p[i + 1] < p[i] && p[i] < p[i - 1])) {
          count++;
        }
      }

      System.out.println("#" + test_case + " " + count);
    }
  }
}