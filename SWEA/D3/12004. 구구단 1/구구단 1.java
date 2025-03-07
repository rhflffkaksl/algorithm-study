import java.util.Scanner;


public class Solution {

    
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			
			int N=sc.nextInt();
			boolean result=false;
			for(int a=1;a<=9;a++) {
				for(int b=a;b<=9;b++) {
					if(a*b==N) result=true;
				}
			}
			
            System.out.println("#"+tc+" "+(result?"Yes":"No"));
		}
	}

}