import java.util.*;
class Solution {
    
    Set<Integer> set =new HashSet<>();
    
    public int solution(String numbers) {
      
        go(numbers.split(""),new boolean[numbers.length()],"");
        
        int cnt=0;
        for(int n:set){
            if (isPrime(n)) cnt++;
        }
        return cnt;
    }
    
    //순열
    void go(String[] nums,boolean[] visited,String cur){
       if(!cur.isEmpty()){
           set.add(Integer.parseInt(cur));
       }
        for(int i=0;i<nums.length;i++){
            if(!visited[i]){
                visited[i]=true;
                go(nums,visited,cur+nums[i]);
                visited[i]=false;
            }
        }
    }
    
    boolean isPrime(int n){
        if(n<2) return false;
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0) return false;
        }
        return true;
    }
}