import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int len=commands.length;
         int[] answer = new int[len];
        for(int i=0;i<len;i++){
            int I=commands[i][0];
            int J=commands[i][1];
            int K=commands[i][2];
            
            int[] arr=new int[J-I+1];
            for(int j=0;j<J-I+1;j++){
                arr[j]=array[I+j-1];
            }
            
            Arrays.sort(arr);
            answer[i]=arr[K-1];
            
        }
        
       
        return answer;
    }
}