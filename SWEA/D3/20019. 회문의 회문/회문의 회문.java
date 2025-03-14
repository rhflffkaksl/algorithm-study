import java.util.Scanner;

public class Solution {
    // 문자열 s가 회문이면 true 반환
    public static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();  // 테스트 케이스 수 입력
        for (int t = 1; t <= T; t++) {
            String s = sc.next();
            int n = s.length();
            String result;
            // 문자열의 길이가 짝수이거나, 전체 문자열이 회문이 아니면 바로 "NO" 출력
            if (n % 2 == 0 || !isPalindrome(s)) {
                result = "NO";
            } else {
                // 앞쪽 부분 문자열 추출: 시작 인덱스 0부터 (n-1)/2 미만까지 추출
                // 예: n=7이면 0~2 인덱스의 3글자 추출
                String front = s.substring(0, (n - 1) / 2);
                
                // 뒷쪽 부분 문자열 추출: 전체 길이에서 (n-1)/2만큼 빼서 추출 시작 인덱스 설정
                // 예: n=7이면 인덱스 4부터 6까지 추출
                String back = s.substring(n - (n - 1) / 2);
                
                // 앞쪽과 뒷쪽 모두 회문이면 "YES", 아니면 "NO"
                result = (isPalindrome(front) && isPalindrome(back)) ? "YES" : "NO";
            }
            // 테스트 케이스 번호와 결과 출력 (#1 NO, #2 NO, #3 YES 형태)
            System.out.println("#" + t + " " + result);
        }
     
    }
}
