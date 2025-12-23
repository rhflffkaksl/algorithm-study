import java.io.*;
import java.util.*;

public class Main {
    static int n, K;
    static int[] arr;
    static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static void main(String[] args) throws Exception {
        int TC = ni();
        for (int tc=0; tc<TC; ++tc) {
            n = ni();
            K = ni();
            int[] arr = new int[n];
            for (int i = 0; i< n; ++i) arr[i] = ni();
            int minDiff = Integer.MAX_VALUE;
            int cnt = 0;
            Arrays.sort(arr);
            // 정렬하고 이진 탐색, 하나는 고정
            for (int i = 0; i < n - 1; i++) {
                int target = K - arr[i];
                int left = i + 1;
                int right = n - 1;
                while (left <= right) {
                    int mid = (left + right) / 2;
                    int diff = Math.abs(target - arr[mid]);

                    if (minDiff == diff)
                        cnt++;
                    else if (minDiff > diff) {
                        minDiff = diff;
                        cnt = 1;
                    }
                    if (arr[mid] < target) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
            }
            System.out.println(cnt);
        }
    }

    static int ni() throws Exception {
        st.nextToken();
        return (int) st.nval;
    }
}