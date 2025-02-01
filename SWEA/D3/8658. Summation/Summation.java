import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트 케이스의 수
        
        for (int t = 1; t <= T; t++) {
            int maxVal = Integer.MIN_VALUE;
            int minVal = Integer.MAX_VALUE;
            
            for (int i = 0; i < 10; i++) {
                int num = sc.nextInt();
                int digitSum = sumOfDigits(num);
                maxVal = Math.max(maxVal, digitSum);
                minVal = Math.min(minVal, digitSum);
            }
            
            System.out.println("#" + t + " " + maxVal + " " + minVal);
        }
        sc.close();
    }
    
    private static int sumOfDigits(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}