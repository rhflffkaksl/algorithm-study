import java.util.Scanner;

public class Solution {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    for (int tc = 1; tc <= T; tc++) {
      int N = sc.nextInt();
      int x, y;
      if (N % 2 == 0) {
        x = N + 8;
        y = 8;
      } else {
        x = N + 9;
        y = 9;
      }
      System.out.println("#" + tc + " " + x + " " + y);
    }
  }


}