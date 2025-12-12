import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    
    Set<String> set = new HashSet<>();

    for (int i = 0; i < N; i++) {
      String[] log = br.readLine().split(" ");
      String name = log[0];
      String cmd = log[1];

      if (cmd.equals("leave")) {
        set.remove(name);
      } else
        set.add(name);
    }

    List<String> list = new ArrayList<>(set);
    list.sort(Comparator.reverseOrder());

    for (String s : list)
      System.out.println(s);

  }
}
