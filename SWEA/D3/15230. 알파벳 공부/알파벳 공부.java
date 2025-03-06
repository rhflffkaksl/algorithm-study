
import java.util.Scanner;

public class Solution {

    
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			
			String N=sc.next();
			int cnt=0;
			for(int i=0;i<N.length();i++) {//a='97',z="122'
				if(N.charAt(i)==(char)(i+97)) cnt++;
				else break;
			}
			
			
            System.out.println("#"+tc+" "+ cnt);
		}
	}
	
}
  
