import java.util.*;

public class Main {
    public static void main(String[] args) {
        //a,b 교차하지 않게 짝지음 = 괄호 짝짓기 문제
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine(); 

        int goodWordCnt = 0;

        for (int i = 0; i < N; i++) {
            String word = sc.nextLine();
            Stack<Character> stack = new Stack<>();

            for (char ch : word.toCharArray()) {
                if (!stack.isEmpty() && stack.peek() == ch) {
                    stack.pop(); // 짝 지음
                } else {
                    stack.push(ch); // 스택에 추가
                }
            }

            if (stack.isEmpty()) {
                goodWordCnt++;
            }
        }

        System.out.println(goodWordCnt);
    }
}
