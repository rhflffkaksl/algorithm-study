import java.util.Scanner;

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for (int test_case = 1; test_case <= T; test_case++) {
            String A = sc.next();
            String B = sc.next();
            String C = sc.next();

            System.out.println("#" + test_case + " " 
                + Character.toUpperCase(A.charAt(0)) 
                + Character.toUpperCase(B.charAt(0)) 
                + Character.toUpperCase(C.charAt(0)));
        }
        sc.close();
    }
}