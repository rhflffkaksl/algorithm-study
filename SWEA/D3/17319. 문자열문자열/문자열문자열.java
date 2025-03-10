import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();

        for (int tc = 1; tc <= TC; tc++) {
            int N = sc.nextInt();
            String S = sc.next();

            // 홀수 길이면 무조건 "No"
            if (N % 2 == 1) {
                System.out.println("#" + tc + " No");
                continue;
            }

            // 문자열 절반씩 나누기
            String firstHalf = S.substring(0, N / 2);
            String secondHalf = S.substring(N / 2);

            // 두 절반이 같은지 확인
            if (firstHalf.equals(secondHalf)) {
                System.out.println("#" + tc + " Yes");
            } else {
                System.out.println("#" + tc + " No");
            }
        }

        sc.close();
    }
}
