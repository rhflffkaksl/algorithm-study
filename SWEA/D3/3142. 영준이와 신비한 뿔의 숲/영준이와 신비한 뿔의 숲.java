

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
			
		
			int n=sc.nextInt();
			int m=sc.nextInt();
			//유니콘:2m-n
			//트윈혼:n-m
			
            System.out.println("#"+test_case+" "+(2*m-n)+" "+(n-m));
            
	
	}	
}
}


