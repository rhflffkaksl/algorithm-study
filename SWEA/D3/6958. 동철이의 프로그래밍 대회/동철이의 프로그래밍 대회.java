import java.util.Scanner;



class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			int N=sc.nextInt();
			int M=sc.nextInt();
			int [][]a=new int[N][M];
			
			int c=0;
			int num=0;
			int max=0;
			for(int i=0;i<N;i++) {
				c=0;
				for(int j=0;j<M;j++) {
					a[i][j]=sc.nextInt();
					if(a[i][j]==1) c++;
				}
				if(c==max) {
					max=c;
					num++;
				}else if(c>max) {
					max=c;
					num=1;
				}
			}
				
			System.out.println("#"+test_case+" "+num+" "+max);
	}
	}
}