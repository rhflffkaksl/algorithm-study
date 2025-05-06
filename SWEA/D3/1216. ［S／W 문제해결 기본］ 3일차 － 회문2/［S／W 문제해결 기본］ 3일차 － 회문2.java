import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = 1; t <= 10; t++) {
            String tc = br.readLine().trim();
            int n = 100;
            char[][] a = new char[n][n];
            for (int i = 0; i < n; i++) {
                a[i] = br.readLine().toCharArray();
            }

            int ans = 1;
            outer:
            for (int len = n; len > 1; len--) {
                // 가로 검사
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j <= n - len; j++) {
                        int k;
                        for (k = 0; k < len/2; k++) {
                            if (a[i][j+k] != a[i][j+len-1-k]) break;
                        }
                        if (k == len/2) {
                            ans = len;
                            break outer;
                        }
                    }
                }
                // 세로 검사
                for (int j = 0; j < n; j++) {
                    for (int i = 0; i <= n - len; i++) {
                        int k;
                        for (k = 0; k < len/2; k++) {
                            if (a[i+k][j] != a[i+len-1-k][j]) break;
                        }
                        if (k == len/2) {
                            ans = len;
                            break outer;
                        }
                    }
                }
            }

            System.out.println("#" + tc + " " + ans);
        }
    }
}
