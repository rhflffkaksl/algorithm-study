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
			
			String s=sc.next();
			int an=0;
			int bn=0;
			char a=s.charAt(0);
			char b=' ';
			
			for(int i=0;i<s.length();i++) {
				if (s.charAt(i) == a) {
                    an++;  
                } else if (b == ' ') {
                    b = s.charAt(i); 
                    bn++;  
                } else if (s.charAt(i) == b) {
                    bn++; 
                } else {
                    an = -1;  
                    break;
                }
			}
				
			
			if (an == 2 && bn == 2) {
                System.out.println("#"+test_case+" Yes");
            } else {
                System.out.println("#"+test_case+" No");
            }
	
	}	
}
}