

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			
			String[]a=new String[5];
			for (int i = 0; i < 5; i++) {
				a[i]=sc.next();
			}
			String s="";
			for(int i=0;i<15;i++) {
				for(int j=0;j<5;j++) {
					if(a[j].length()>i) {
					s+=a[j].charAt(i);}
				}
			}
			System.out.println("#"+test_case+" "+s);
	
	
	}	
}
}


