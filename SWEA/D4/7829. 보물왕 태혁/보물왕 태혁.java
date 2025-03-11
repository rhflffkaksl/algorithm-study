
import java.util.Scanner;

public class Solution {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    for (int tc = 1; tc <= T; tc++) {
      int n = sc.nextInt();
      int[] num = new int[n];
      int min = Integer.MAX_VALUE;
      int max = 0;
      for (int i = 0; i < n; i++) {
        num[i] = sc.nextInt();
        max = Math.max(max, num[i]);
        min = Math.min(min, num[i]);
      }


      System.out.println("#" + tc + " " + (max * min));
    }
  }

}
