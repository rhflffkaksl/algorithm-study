import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int answer = 0;

        // 인용 수로 정렬해서 뒤에서 h-1번째 인용수가 h여야 함
        
        Arrays.sort(citations);
        int n=citations.length;
        
        for(int i=0;i<n;i++){
            if(citations[n-1-i]>=i+1) answer=i+1;
        }
        
        return answer;
    }
}