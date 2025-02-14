

import java.util.Arrays;
import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			
			int []srt=new int[2];
			
			srt[0]=sc.nextInt();
			srt[1]=sc.nextInt();
			int c=sc.nextInt();
			
			Arrays.sort(srt);
			
			
			int bbang=c/srt[0];
			
			System.out.println("#"+test_case+" "+bbang);
	
	}	
}
}