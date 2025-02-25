import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(); 

      
        int T = 0;
        try {
            T = Integer.parseInt(in.readLine().trim()); // 공백 제거 후 정수 변환
        } catch (NumberFormatException e) {
            System.out.println("잘못된 입력값입니다.");
            return;
        }

        for (int tc = 1; tc <= T; tc++) {
            String s = in.readLine().trim();  // 공백 제거
            ArrayList<Character> list = new ArrayList<>();

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (list.contains(c)) list.remove(Character.valueOf(c)); // 정수 인덱스가 아닌 문자를 제거하려면 Character.valueOf() 필요
                else list.add(c);
            }

            sb.append("#").append(tc).append(" ");
            Collections.sort(list);  //  알파벳 순 정렬

          if (list.size() == 0) {
                sb.append("Good");
            } else {
                for (char ch : list) {
                    sb.append(ch);
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}