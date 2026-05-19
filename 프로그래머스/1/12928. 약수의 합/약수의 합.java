class Solution {
    public int solution(int n) {
        int answer = 0;
        int sqrtN=(int)Math.sqrt(n);
        for(int i=1;i<=sqrtN;i++){
           if(n%i==0){
               answer+=i;
               if(n/i!=i) answer+=n/i;
           }      
        }
        return answer;
    }
}