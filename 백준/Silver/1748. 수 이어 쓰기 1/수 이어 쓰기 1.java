import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int digit = 1;  // 자릿수
        int start = 1;  // 해당 자릿수에서의 시작 숫자
        int length = 0; // 전체 자릿수 누적합

        while (start * 10 <= N) {
            int count = start * 9; // 1자리:9,2자리:90,..
            length += count * digit;
            digit++;
            start *= 10;
        }

        // 마지막 남은 자릿수 계산
        length += (N - start + 1) * digit;

        System.out.println(length);
    }
}