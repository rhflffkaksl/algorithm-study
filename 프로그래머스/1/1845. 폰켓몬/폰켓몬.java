import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int n=nums.length;
        Set<Integer> set=new HashSet<>();
        for(int i:nums){
            set.add(i);
        }
        if(n/2>set.size()) answer=set.size();
        else answer=n/2;
        return answer;
    }
}