import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double[] num = new double[n];

        for (int i = 0; i < n; i++) {
            num[i] = sc.nextDouble();
        }

        double max = num[0];  //  초기값 중요
        for (int i = 0; i < n; i++) {
            double product = 1.0;
            for (int j = i; j < n; j++) {
                product *= num[j];
                if (product > max) max = product;
            }
        }

        // 반올림 + 셋째 자리 출력
        System.out.printf("%.3f\n", max);
    }
}
