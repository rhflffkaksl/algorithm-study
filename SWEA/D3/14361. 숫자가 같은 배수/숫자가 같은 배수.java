import java.util.Scanner;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 1; i <= T; i++) {
            String nStr = sc.next();
            int N = Integer.parseInt(nStr);
            int d = nStr.length();
            if(d == 1) {
                System.out.println("#"+i+" "+"impossible");
                continue;
            }
            char[] sortedN = nStr.toCharArray();
            Arrays.sort(sortedN);
            String sortedNStr = new String(sortedN);
            boolean possible = false;
            int lowerBound = (int) Math.pow(10, d - 1);
            int upperBound = (int) Math.pow(10, d);
            for (int m = 2;; m++) {
                int candidate = N * m;
                if (candidate >= upperBound) break;
                if (candidate < lowerBound) continue;//숫자로 변환
                
                char[] candArr = Integer.toString(candidate).toCharArray();
                Arrays.sort(candArr);
                if (new String(candArr).equals(sortedNStr)) {//정렬한 값이 값으면 됨!!
                    possible = true;
                    break;
                }
            }
            System.out.println("#"+i+" "+(possible ? "possible" : "impossible"));
        }
        sc.close();
    }
}
