import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {
	private static class KeyInput implements Comparable<KeyInput> {
		int time;
		int keyboard;
        char key;
        
        public KeyInput(int time, int keyboard, char key) {
            this.time = time;
            this.keyboard = keyboard;
            this.key = key;
        }
        
		@Override
		public int compareTo(KeyInput o) {
			// 1. 시간을 기준으로 오름차순 정렬
            if (this.time != o.time) return this.time - o.time;
            // 2. 시간이 같다면 키보드 번호를 기준으로 오름차순 정렬
            return this.keyboard - o.keyboard;
		}
	}
	
	
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int M = sc.nextInt();

    List<KeyInput> inputs = new ArrayList<>();
    
    for (int i=0; i<M; i++) {
    	 int keyboard = sc.nextInt();
         int time = sc.nextInt();
         char key = sc.next().charAt(0);
         inputs.add(new KeyInput(time, keyboard, key));
    }
    Collections.sort(inputs);
    String answer="";
    for (KeyInput input : inputs) {
    	answer+=input.key;
    }
      System.out.println(answer);
    }
  }