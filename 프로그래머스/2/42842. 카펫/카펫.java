import java.util.*;
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        //가로가 긴쪽
        
        //노란 직사각형 a*b 조합
        for(int i=1;i<=Math.sqrt(yellow);i++){
            if(yellow%i!=0) continue;//약수가 아니면 넘기기
            
            if((i+2)*2+(yellow/i)*2==brown){
                    
                answer[0]=yellow/i+2;//더 긴쪽
                answer[1]=i+2;
                break;
            }
        }
        
         return answer;
    }
}