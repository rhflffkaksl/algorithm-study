import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            String line = sc.nextLine();

            if (line.equals(".")) break;

            if (isBalanced(line)) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }

    public static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '[') {
                stack.push(ch);//왼쪽은 푸시
            } else if (ch == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            } else if (ch == ']') {
                if (stack.isEmpty() || stack.pop() != '[') {
                    return false;
                }
            }
        }

        return stack.isEmpty(); // 모든 괄호가 짝지어졌으면 비어있어야 함
    }
}
