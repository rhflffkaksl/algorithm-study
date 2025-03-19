import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
       
        Stack<Integer> s=new Stack<>();
        for(int i:arr){
             if (s.isEmpty() || s.peek() != i) { // 연속된 숫자가 아닐 때만 추가
                s.push(i);
            }
        }
        
      int[] answer = new int[s.size()];
        for (int i = s.size() - 1; i >= 0; i--) {//뒤에서부터
            answer[i] = s.pop(); 
        }

        return answer;
    }
}