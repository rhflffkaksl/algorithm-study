import java.io.*;
import java.util.*;

public class Solution {

    static int N, L;    
    static int[] taste, cal;     
    static int maxTaste;         

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();   

        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();     
            L = sc.nextInt();   

            taste = new int[N];
            cal = new int[N];

            for (int i = 0; i < N; i++) {
                taste[i] = sc.nextInt();
                cal[i] = sc.nextInt();
            }

            maxTaste = 0;
            dfs(0, 0, 0);         // 부분집합

            System.out.println("#" + tc + " " + maxTaste);
        }
    }

    static void dfs(int idx, int tSum, int cSum) {
        if (cSum > L) return;                    
        if (idx == N) {                           
            maxTaste = Math.max(maxTaste, tSum); 
            return;
        }


        dfs(idx + 1, tSum + taste[idx], cSum + cal[idx]);
        dfs(idx + 1, tSum, cSum);
    }
}
