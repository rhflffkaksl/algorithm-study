import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        Integer[] integerArr = new Integer[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            integerArr[i] = numbers[i];
        }//Integer로 변환   
        
        // 배열 정렬하기
        //Arrays.sort(persons, (p1, p2) -> p2.age - p1.age);
       // Arrays.sort(integerArr, (a,b)->(a+"").charAt(0)-(b+"").charAt(0));
        //문자열로 변환후 첫숫자 기준으로 정렬-> 첫숫자만 고려하면 안됨!!!!
        
Arrays.sort(integerArr, (a, b) -> (b + "" + a).compareTo(a + "" + b));
//합친것기준으로 정렬(두번째 이후 자릿수도 고려하기 위해)

        
         for (int i = 0; i < numbers.length; i++) {
            answer+= integerArr[i];
        }
        
         // 모든 숫자가 0일 경우
        if (integerArr[0] == 0) return "0";
        
        return answer;
    }
    
}