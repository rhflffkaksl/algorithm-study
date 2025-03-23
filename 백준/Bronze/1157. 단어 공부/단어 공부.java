import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String word = sc.nextLine().toUpperCase(); //대소문자 구분 제거
        int[] count = new int[26];
        
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            count[ch - 'A']++;
        }

        int max = 0;
        char result = '?';
        for (int i = 0; i < 26; i++) {
            if (count[i] > max) {
                max = count[i];
                result = (char)(i + 'A');
            } else if (count[i] == max) {
                result = '?'; // 최빈값이 여러 개일 때
            }
        }

        System.out.println(result);
    }
}
