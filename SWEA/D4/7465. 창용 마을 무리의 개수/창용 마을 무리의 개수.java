import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
      
    	Scanner sc=new Scanner(System.in);
    	int T=sc.nextInt();
    	
    	for(int tc=1;tc<=T;tc++) {
    		int N=sc.nextInt();
    		int M=sc.nextInt();
    		
    		
    		list =new ArrayList[N+1]; //1번부터~
    		
    		for(int i=1;i<=N;i++) {
    			list[i]=new ArrayList<>();
    		}
    		
    		for(int i=0;i<M;i++) {
    			int one=sc.nextInt();
    			int two=sc.nextInt();
    			
    			list[one].add(two);
    			list[two].add(one);
    		}
    		int cnt=0;
    		linked=new boolean[N+1];
    		
    		for(int i=1;i<=N;i++) {
    			if(!linked[i]) {
    				cnt++;
    				start(i);
    			}    			
    		}
	
    		System.out.println("#"+tc+" "+cnt);
    	}

    }
    static boolean[] linked;
    static List<Integer>[] list;
    
    static void start(int i) {
    	for(int friend:list[i]){	
    		if(!linked[friend]) {
    			linked[friend]=true;
    			start(friend);
    		}
    		
    	}
    }
    
    
    
}
