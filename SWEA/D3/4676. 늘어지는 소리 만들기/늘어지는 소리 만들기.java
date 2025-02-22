

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
			
			String a=sc.next();
			int H=sc.nextInt();
			int place[]=new int[H];
			for (int i = 0; i < H; i++) {
				place[i]=sc.nextInt();
				
			}
			 Arrays.sort(place); //정렬해줘야 안꼬임!!!!!!!!!
			StringBuffer sb=new StringBuffer();
			sb.append(a);
			int index=0;
			for(int i=0;i<H;i++) {
				sb.insert(place[i]+index,'-');
						index++;
			}
			System.out.println("#"+test_case+" "+sb);
	
	
	}	
}
}


