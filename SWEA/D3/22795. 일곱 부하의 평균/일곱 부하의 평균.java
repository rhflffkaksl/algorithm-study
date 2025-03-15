import java.util.Scanner;

public class Solution {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int TC=sc.nextInt();
    for(int tc=1;tc<=TC;tc++) {
    	int[] h=new int [6];
    	int max=0;
    	int sum=0;
    for(int i=0;i<6;i++) {
    	h[i]=sc.nextInt();
    	sum+=h[i];
    	if(max<h[i]) max=h[i];
    }
    boolean find=false;
    int seventh=max+1;
   while(!find) {
	   if((seventh+sum)%7==0) break;
	   seventh++;
   }
       
    System.out.println(seventh);
  }
  }
 
}