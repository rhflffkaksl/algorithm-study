



import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class Solution {

    
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			
			num=new int[7];
			
			for(int i=0;i<7;i++) {
				num[i]=sc.nextInt();
			}
			order=new ArrayList<>();
			index=0;
			//조합
			combi(0,0,0);
			Collections.sort(order);
            System.out.println("#"+tc+" "+order.get(order.size() - 5));//뒤에서 5번째
		}
		
	
	}
	static List<Integer> order;
	static int[] num;
	static int index;
	static void combi(int cnt,int start,int sum) {
		if(cnt==3) {
			if(!order.contains(sum)) order.add(sum);//중복 제거
			return;
		}
		for(int i=start;i<7;i++) {
			int newsum=sum+num[i];
			combi(cnt+1,i+1,newsum);
		}
		
		
	}
}
  


