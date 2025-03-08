

import java.util.Scanner;


public class Solution {

    
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			
			N=sc.nextInt();
			M=sc.nextInt();
			weight=new int[N];
			for(int i=0;i<N;i++) {
				weight[i]=sc.nextInt();
			}
			//조합
			MAX=-1;
			combi(0,0,0);
			
            System.out.println("#"+tc+" "+MAX);
		}

	}
	static int MAX,M,N;
	static int[] weight;
	static void combi(int cnt,int sum,int start) {
		if(sum>M) return;
		if(cnt==2) {
			MAX=Math.max(MAX, sum);
			return;
		}
		for(int i=start;i<N;i++) {
			int newsum=sum+weight[i];
			combi(cnt+1,newsum,i+1);
		}
		
	}
}
  


