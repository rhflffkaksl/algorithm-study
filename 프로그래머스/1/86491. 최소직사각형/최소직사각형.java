import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int max=0;
        int max2=0;
        int dir=-1;
        for(int i=0;i<sizes.length;i++){
            for(int j=0;j<2;j++){
                if(max<sizes[i][j]) {
                    max=sizes[i][j];
                    dir=j;//가로 0, 세로 1
                }
            }
        }
        
    
        //그냥 젤 큰 값 찾아서 나머지 명함 큰 방향 맞춰서 돌리고 나머지 방향에서 큰값 찾기
        for(int i=0;i<sizes.length;i++){
            
            if(dir==0 && sizes[i][0]<sizes[i][1]){
                int temp=sizes[i][0];
                sizes[i][0]=sizes[i][1];
                sizes[i][1]=temp;
            }
            else if(dir==1&& sizes[i][1]<sizes[i][0])
            {
                int temp=sizes[i][0];
                sizes[i][0]=sizes[i][1];
                sizes[i][1]=temp;
            }
            if(dir==1 &&sizes[i][0]>max2){
                max2=sizes[i][0];
            }
            else if(dir==0 &&sizes[i][1]>max2){
                max2=sizes[i][1];
            }
         
            
        }
        
        answer=max*max2;
        
                                         
        return answer;
    }
    
}