
import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			
			int N=sc.nextInt();
			int D=sc.nextInt();
			int t=0;
			int num=N/(2*D+1);
			if(N%(2*D+1)!=0) t=1;

			System.out.println("#"+test_case+" "+(num+t));
	
	}	
}
}