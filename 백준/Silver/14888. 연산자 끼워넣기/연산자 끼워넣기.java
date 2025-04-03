import java.util.*;

public class Main {
    static int N;
    static int[] nums;
    static int[] ops = new int[4]; // + - * /
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        nums = new int[N];

        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }

        for (int i = 0; i < 4; i++) {
            ops[i] = sc.nextInt(); //연산자의 수
        }
        //n-1 중복순열!!(각 연산자 수!)로 나눔

        dfs(1, nums[0]); // idx 1부터 시작, 첫 숫자 고정
        System.out.println(max);
        System.out.println(min);
    }

    static void dfs(int idx, int result) {
        if (idx == N) {
            max = Math.max(max, result);
            min = Math.min(min, result);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (ops[i] > 0) {
                ops[i]--;

                int next = 0;
                switch (i) {
                    case 0: next = result + nums[idx]; break;
                    case 1: next = result - nums[idx]; break;
                    case 2: next = result * nums[idx]; break;
                    case 3: 
                        if (result < 0)
                            next = -(-result / nums[idx]);
                        else
                            next = result / nums[idx];
                        break;
                }

                dfs(idx + 1, next);
                ops[i]++; // 백트래킹
            }
        }
    }
}
