import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    
    for (int t = 0; t < T; t++) {
      // 2^트리의 최대 깊이

      String s = br.readLine();

      int depth = 0;
      int maxdepth = 0;

      // [ :++, ]:-- 했을때 스택이 젤 커졋을떄가 최대 깊이
      for (char c : s.toCharArray()) {
        if (c == '[') {
          depth++;
          maxdepth = Math.max(depth, maxdepth);
        } else {
          depth--;
        }
      }

      int result = (int) Math.pow(2, maxdepth);
      System.out.println(result);
    }

  }

}
