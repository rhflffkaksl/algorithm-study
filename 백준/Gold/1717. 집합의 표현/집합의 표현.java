import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    m = sc.nextInt();

    makeset();

    for (int i = 0; i < m; i++) {
      int x = sc.nextInt();
      int a = sc.nextInt();
      int b = sc.nextInt();

      if (x == 0)
        union(a, b);
      if (x == 1) {
        boolean result = (findset(a) == findset(b));
        if (result)
          System.out.println("yes");
        else
          System.out.println("no");
      }
    }
  }

  private static int n, m;
  private static int[] parents;

  private static void makeset() {
    parents = new int[n + 1];
    for (int i = 0; i <= n; i++) {
      parents[i] = i;
    }
  }

  private static int findset(int a) {
    if (parents[a] == a)
      return a;

    return parents[a] = findset(parents[a]);
  }

  private static void union(int a, int b) {
    if (findset(a) == findset(b))
      return;
    parents[findset(a)] = findset(b);
    return;
  }

}