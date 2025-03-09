

import java.util.Scanner;


public class Solution {

    
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			
			int N=sc.nextInt();
			int M=sc.nextInt();
			int[] money=new int[N];
			String[] number=new String[N];
			for(int i=0;i<N;i++) {
				number[i]=sc.next();
				money[i]=sc.nextInt();
			}
			String ju[]=new String[M];
			int sum=0;
			for(int i=0;i<M;i++) {
				ju[i]=sc.next();
				for(int j=0;j<N;j++) {
					sum+=money[j];
					for(int k=0;k<8;k++) {
						if(number[j].charAt(k)=='*') continue;
						if(number[j].charAt(k)!=ju[i].charAt(k)) {
							sum-=money[j];
							break;
						}
						
					}
				}
			}
			

			
            System.out.println("#"+tc+" "+sum);
		}

	}
}
  


