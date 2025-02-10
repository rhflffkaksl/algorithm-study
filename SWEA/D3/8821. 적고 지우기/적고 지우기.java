import java.util.ArrayList;
import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			
			String a=sc.next();
			int num[]=new int[10];
			int c=0;
			for(int i=0;i<a.length();i++) {
				num[a.charAt(i)-'0']++;
				
			}
			for(int i=0;i<10;i++) {
				if(num[i]%2==1) c++;
			}
			
			
			System.out.println("#"+test_case+" "+c);
	
	}	
}
}