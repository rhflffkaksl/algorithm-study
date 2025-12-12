import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;


public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    Stack<Integer> s = new Stack<>();
    
    for (int i = 0; i < N; i++) {
      // 스택에서 현재 숫자보다 더 작은것들 빼고 넣기
      int h = Integer.parseInt(br.readLine());
      while (!s.empty() && s.peek() <= h) {
        s.pop();
      }
      s.push(h);
    }

    System.out.println(s.size());

  }
}
