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
			int a=sc.nextInt();
			int b=sc.nextInt();
			//둘다 구독하고있는사람 최소,최대
			int max=-1;
			int min=-1;
			if(n>=a+b) {
				min=0;
			}else {
				min=a+b-n;
				
			}
			
			max=Math.min(a,b);
	
            System.out.println("#"+test_case+" "+max+" "+min);
            
	
	}	
}
}