import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        int result = A * B * C;

        int[] count = new int[10];

        String str = ""+result;
        for (int i = 0; i < str.length(); i++) {
            int num = str.charAt(i) - '0';
            count[num]++;
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(count[i]);
        }

        sc.close();
    }
}
