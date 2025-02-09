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
			
			int a[]=new int[N];
			int sum=0;
			int max=0;
			for(int i=0;i<N;i++) {
				a[i]=sc.nextInt();
				if(a[i]>max) max=a[i];
				sum+=a[i];
			}
			sum+=N+max;
			
			
			System.out.println("#"+test_case+" "+sum);
	
	}	
}
}