

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
			
		
			int n=sc.nextInt();
			sc.nextLine();
			String s=sc.nextLine();
			String[]a=s.split(" ");
			String[] newd=new String[n];
			int num=(n%2==0 ? n/2:n/2+1);
			int index=0;
			for (int i = 0; i < num; i++) {
				//i번째,i+num번째 교대로 newd에 할당
				newd[index++]=a[i];
				if (i + num < n) { // 배열 범위 초과 방지
                    newd[index++] = a[i + num];
                }
			}
			System.out.print("#"+test_case+" ");
			for (String card:newd) {
				System.out.print(card+" ");
			}
            System.out.println();
	
	}	
}
}


