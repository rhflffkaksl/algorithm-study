import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Work {
  int score;
  int time;

  public Work(int score, int time) {
    super();
    this.score = score;
    this.time = time;
  }
}


public class Main {


  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());

    // 스택
    Stack<Work> stack = new Stack<>();
    int totalScore = 0;

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());


      if (Integer.parseInt(st.nextToken()) == 1) {
        int score = Integer.parseInt(st.nextToken());
        int minute = Integer.parseInt(st.nextToken());

        if (minute - 1 == 0) {
          totalScore += score;
        } else {
          stack.push(new Work(score, minute - 1));
        }
      } else { // 새과제 없음
        if (!stack.isEmpty()) {
          Work cur = stack.peek();
          cur.time--;
          if (cur.time == 0) {
            totalScore += cur.score;
            stack.pop();
          }
        }
      }

    }
    System.out.println(totalScore);
  }
}
