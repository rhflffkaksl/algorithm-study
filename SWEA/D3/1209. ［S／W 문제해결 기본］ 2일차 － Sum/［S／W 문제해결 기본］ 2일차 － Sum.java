import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = 0; t < 10; t++) {
            String tc = br.readLine().trim();
            int[] col = new int[100];
            int ans = Integer.MIN_VALUE;
            int d1 = 0, d2 = 0;

            for (int i = 0; i < 100; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int row = 0;
                for (int j = 0; j < 100; j++) {
                    int n = Integer.parseInt(st.nextToken());
                    row += n;
                    col[j] += n;
                    if (i == j) d1 += n;
                    if (i + j == 99) d2 += n;
                }
                ans = Math.max(ans, row);
            }

            for (int x : col) {
                ans = Math.max(ans, x);
            }
            ans = Math.max(ans, d1);
            ans = Math.max(ans, d2);

            System.out.println("#" + tc + " " + ans);
        }
    }
}
