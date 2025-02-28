import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine(); // 개행문자 제거

        for (int tc = 1; tc <= T; tc++) {
            String input = sc.nextLine();
            int len = input.length();

            // 5줄을 저장할 StringBuilder
            StringBuilder[] lines = new StringBuilder[5];
            for (int i = 0; i < 5; i++) {
                lines[i] = new StringBuilder();
            }

            // 패턴 적용
            for (int i = 0; i < len; i++) {
                char c = input.charAt(i);

                // 첫 번째 줄
                lines[0].append(i == 0 ? "..#.." : ".#..");

                // 두 번째 줄
                lines[1].append(i == 0 ? ".#.#." : "#.#.");

                // 세 번째 줄 (문자가 들어가는 줄)
                lines[2].append(i == 0 ? "#." + c + ".#" : "." + c + ".#");

                // 네 번째 줄
                lines[3].append(i == 0 ? ".#.#." : "#.#.");

                // 다섯 번째 줄
                lines[4].append(i == 0 ? "..#.." : ".#..");
            }

            // 결과 출력
            for (int i = 0; i < 5; i++) {
                System.out.println(lines[i]);
            }
        }
        sc.close();
    }
}