
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
			
			int c=0;
			for(int i=0;i<a.length()-1;i++) {
				if(a.charAt(i)=='(') c++;
				else if(a.charAt(i)=='|' && a.charAt(i+1)==')') c++;
			}

			
			
			System.out.println("#"+test_case+" "+c);
	
	}	
}
}