import java.util.Scanner;


public class Solution {

    
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			
			int N=sc.nextInt();
			int[] abc=new int[26];
			for(int i=0;i<N;i++) {
				String temp=sc.next();
				abc[temp.charAt(0)-'A']++;
			}
			for(int i=0;i<26;i++) {
				if(abc[i]==0) {
					System.out.println("#"+tc+" "+i);
					break;
				}
				if(i==25) System.out.println("#"+tc+" "+"26"); // 마지막까지 break 문 실행안되는경우!!! 
			}
		}

	}
}