
import java.util.Scanner;

public class Solution {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int TC=sc.nextInt();
    for(int tc=1;tc<=TC;tc++) {
    N=sc.nextInt();
    L=sc.nextInt();
    //재료 포함/미포함-> 부분집합 합
    T=new int[N];
    K=new int[N];
  
    for(int i=0;i<N;i++) {
    	T[i]=sc.nextInt();//맛
    	K[i]=sc.nextInt();//칼로리
    }
    max=0;
    subset(0,0,0);
    
    
    
    System.out.println("#"+tc+" "+max);
  }
  }
  static int N,L,max;
  static int[] K,T;
 
  static void subset(int idx,int Tsum,int Ksum) {
	  
	if(Ksum>L) return;
	if(idx==N)  {
		 max = Math.max(max, Tsum);
        return;
	}
	subset(idx+1,Tsum,Ksum);
	 subset(idx+1,Tsum+T[idx],Ksum+K[idx]);
  }
}
