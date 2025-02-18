import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder sb = new StringBuilder();

    for (int test_case = 1; test_case <= 10; test_case++) {
      sb.append("#" + test_case + " ");

      Stack<Character> stack = new Stack<>();
      in.readLine();

      String entire = in.readLine();
      // 짝을 지어줘요 아스키코드~~
      for (int i = 0; i < entire.length(); i++) {
        if (!stack.isEmpty()
            && (stack.peek() == entire.charAt(i) - 2 || stack.peek() == entire.charAt(i) - 1))
          stack.pop();
        else
          stack.push(entire.charAt(i));
      }
      int answer = -1;
      if (stack.isEmpty())
        answer = 1;
      else
        answer = 0;


      sb.append(answer).append("\n");
    }
    System.out.println(sb);

  }


}