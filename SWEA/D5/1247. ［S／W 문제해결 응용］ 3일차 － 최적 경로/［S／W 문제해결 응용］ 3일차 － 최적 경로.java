
import java.util.Scanner;

public class Solution {
	static int N,hx,hy,Min;
    static int[][] cmap;
    static boolean[] visited; 
    
    
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			
			N=sc.nextInt();
			int fx=sc.nextInt();//회사 출발
			int fy=sc.nextInt();
			 hx=sc.nextInt();//집 도착
			hy=sc.nextInt();
			cmap=new int[N][2];
			
			Min=Integer.MAX_VALUE;
			for(int i=0;i<N;i++) {
				cmap[i][0]=sc.nextInt();
				cmap[i][1]=sc.nextInt();
			}
			
			visited=new boolean[N];
			
			go(0,fx,fy,0);
            System.out.println("#"+tc+" "+ Min);
		}
	}
	
	static void go(int cnt,int x,int y,int sum) {
		if(cnt==N) {
			int end=distance(hx,hy,x,y)+sum;
			Min=Math.min(Min, end);
			return;
		}
		if(sum>Min) return;
		for(int i=0;i<N;i++) {
			if(!visited[i]) {
				visited[i]=true;
				int newsum=sum+distance(x,y,cmap[i][0],cmap[i][1]);
				go(cnt+1,cmap[i][0],cmap[i][1],newsum);
				visited[i]=false;
				
			}
		}
	}
	static int distance(int x1,int y1,int x2,int y2) {
		return Math.abs(x1-x2)+Math.abs(y1-y2);
	}
}
  


