import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    k = sc.nextInt();
    cards = new int[100];
    for (int i = 0; i < n; i++) {
      int card = sc.nextInt();
      cards[card]++;
    }

    // 그냥 순열인거같은디? 아니다 같은수의 카드가 있을수잇다
    // -> cards[n] 에서 card[1~99]로 숫자별 개수 저장


    visited = new boolean[100];


    permutation(0, "");

    System.out.println(number.size());

  }

  public static boolean visited[];
  public static int k, n;
  public static int[] cards;
  public static Set<String> number = new HashSet<>();// 카드로 조합한 정수의 수(중복 자동제거)

  public static void permutation(int size, String current) {
    if (size == k) {
      number.add(current);
      return;
    }

    for (int j = 1; j < 100; j++) {
      if (cards[j] != 0 && !visited[j]) {

        cards[j]--;
        if (cards[j] == 0)
          visited[j] = true;
        permutation(size + 1, current + j);
        cards[j]++;
        visited[j] = false;

        // card[j]>0 조건을 쓰기때문에 visited를 또 안써도된다고함
      }
    }

  }
}