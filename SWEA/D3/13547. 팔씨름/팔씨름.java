import java.util.Scanner;

public class Solution {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    for (int tc = 1; tc <= T; tc++) {
      String s = sc.next();
      int cnt = 0;
      // 15-k+x개수>=8일때 yes
      for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) == 'o')
          cnt++;
      }
      String answer = "NO";
      if (15 - s.length() + cnt >= 8)
        answer = "YES";
      System.out.println("#" + tc + " " + answer);
    }
  }
}