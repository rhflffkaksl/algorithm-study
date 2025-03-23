import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String A = sc.next();
        String B = sc.next();

        //거꾸로 읽으므로 끝자리부터 비교
        for (int i = 2; i >= 0; i--) {
            if (A.charAt(i) > B.charAt(i)) {
                System.out.println(A.charAt(2) + "" + A.charAt(1) + A.charAt(0));
                break;
            } else if (A.charAt(i) < B.charAt(i)) {
                System.out.println(B.charAt(2) + "" + B.charAt(1) + B.charAt(0));
                break;
            }
            
        }

        sc.close();
    }
}
