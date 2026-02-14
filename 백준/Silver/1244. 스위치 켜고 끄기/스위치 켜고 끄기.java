import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int Sn = Integer.parseInt(br.readLine());

    int[] state = new int[Sn];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < Sn; i++) {
      // 스위치 상태
      state[i] = Integer.parseInt(st.nextToken());
    }
    int Pn = Integer.parseInt(br.readLine());

    for (int i = 0; i < Pn; i++) {
      st = new StringTokenizer(br.readLine());
      int gen = Integer.parseInt(st.nextToken());
      int num = Integer.parseInt(st.nextToken()) - 1;

      // 성별 1:받은수의 배수 바꾸기
      // 성별 2: 받은수 중심으로 대칭 최대 구간 바꾸기

      if (gen == 1) {
        for (int j = num; j < Sn; j += num + 1) {
          state[j] = 1 - state[j];
        }
      } else {
        int cnt = 1;
        state[num] = 1 - state[num];

        while (num + cnt < Sn && num - cnt >= 0) {
          if (state[num + cnt] != state[num - cnt])
            break;// 대칭이 아닐때
          state[num + cnt] = 1 - state[num + cnt];
          state[num - cnt] = 1 - state[num - cnt];
          cnt++;
        }
      }

    }

    for (int i = 0; i < Sn; i++) {
      System.out.print(state[i] + " ");
      if ((i + 1) % 20 == 0)
        System.out.println();
    }


  }
}
