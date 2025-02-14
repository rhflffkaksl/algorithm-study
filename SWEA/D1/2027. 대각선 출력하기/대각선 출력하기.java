import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		
		int index=0;
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				if(index==i && index==j){
					System.out.print("#");
					index++;
				}
				else System.out.print("+");
			}
			System.out.println();
		}
	
}
}