import java.math.BigInteger;
import java.util.Scanner;

public class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); 
        
        for (int i = 1; i <= T; i++) {
            BigInteger A = sc.nextBigInteger();//매우큰수!!!
            BigInteger B = sc.nextBigInteger();
            BigInteger sum = A.add(B);  //합
            System.out.println("#"+i+" "+sum);
        }

    }
}

