



import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			
			int N=sc.nextInt();
		
			int[] grass=new int[N];
			int avg=0;
			
			for(int i=0;i<N;i++) {
				grass[i]=sc.nextInt();
				avg+=grass[i];
			}
			avg/=N;
			int cnt=0;
			for(int i=0;i<N;i++) {
				if(grass[i]>avg) cnt+=grass[i]-avg;
			}
			
			
            System.out.println("#"+tc+" "+ cnt);
		}
	}
	
}
  


