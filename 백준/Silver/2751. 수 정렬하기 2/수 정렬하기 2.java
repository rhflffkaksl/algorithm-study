import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 빠른 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 출력 최적화
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>(N);

        // 입력 처리
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        // Collections.sort 사용
        Collections.sort(list);

        // 출력 처리
        for (int num : list) {
            sb.append(num).append('\n');
        }

        System.out.print(sb);
    }
}
