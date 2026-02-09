import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  static int K;
  static int[] tree;
  static List<List<Integer>> levels;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    K = Integer.parseInt(br.readLine());
    // 총 2^K-1개의 노드
    tree = new int[(int) Math.pow(2, K) - 1];

    StringTokenizer st = new StringTokenizer(br.readLine());
    // 완전이진트리 왼쪽->부모->오른쪽 순
    for (int i = 0; i < tree.length; i++) {
      tree[i] = Integer.parseInt(st.nextToken());
    }

    // 층별 노드 저장
    levels = new ArrayList<>();
    for (int i = 0; i < K; i++) {
      levels.add(new ArrayList<>());
    }

    // 맨위부터
    build(0, tree.length - 1, 0);

    // 층별로 노드 출력
    for (int i = 0; i < K; i++) {
      for (int num : levels.get(i)) {
        System.out.print(num + " ");
      }
      System.out.println();
    }

  }

  static void build(int start, int end, int depth) {
    if (start > end)
      return;

    int mid = (start + end) / 2;

    levels.get(depth).add(tree[mid]);

    // 왼쪽 자식들
    build(start, mid - 1, depth + 1);
    // 오른쪽 자식들
    build(mid + 1, end, depth + 1);
  }


}
