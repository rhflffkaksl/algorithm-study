import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //빠른 입력
        StringBuilder sb = new StringBuilder(); //  빠른 출력
        Stack<Integer> stack = new Stack<>();

        int N = Integer.parseInt(br.readLine()); 

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());

            switch (command) {
                case 1:
                    int X = Integer.parseInt(st.nextToken());
                    stack.push(X);
                    break;
                case 2:
                    if (!stack.isEmpty()) {
                        sb.append(stack.pop()).append("\n");
                    } else {
                        sb.append("-1\n");
                    }
                    break;
                case 3:
                    sb.append(stack.size()).append("\n");
                    break;
                case 4:
                    if (!stack.isEmpty()) {
                        sb.append("0\n");
                    } else {
                        sb.append("1\n");
                    }
                    break;
                case 5:
                    if (!stack.isEmpty()) {
                        sb.append(stack.peek()).append("\n");
                    } else {
                        sb.append("-1\n");
                    }
                    break;
            }
        }

        System.out.print(sb.toString()); // 한 번에 출력하여 속도 최적화
        br.close();
    }
}
