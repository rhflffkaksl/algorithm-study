import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt(); 

        for (int i = 0; i < T; i++) {
            String line = sc.next();
            int score = 0;
            int count = 0;

            for (int j = 0; j < line.length(); j++) {
                if (line.charAt(j) == 'O') {
                    count++;
                    score += count;
                } else {
                    count = 0;//초기화
                }
            }

            System.out.println(score);
        }
    }
}