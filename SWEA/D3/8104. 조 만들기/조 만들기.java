import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            int K = sc.nextInt();
            int[] groupSum = new int[K];
            for (int i = 0; i < N;i++) {
                for (int j = 0; j < K; j++) {
                    int rank = i* K + j + 1;
                    int Index = (i % 2 == 0) ?j : (K - j - 1);
                    groupSum[Index] += rank;
                }
            }
            System.out.print("#" + tc);
            for (int sum : groupSum) {
                System.out.print(" " + sum);
            }
            System.out.println();
        }
        sc.close();
    }
}
