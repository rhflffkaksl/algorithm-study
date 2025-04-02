import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        N=sc.nextInt();
        map=new int[N][N];
       for(int i=0;i<N;i++) {
    	   String s=sc.next();
    	   for(int j=0;j<N;j++) {
    		   map[i][j]=s.charAt(j)-'0';
    	   }
       }
       List<Integer> list=new ArrayList<>();
       visited=new boolean[N][N];
       for(int i=0;i<N;i++) {
    	   for(int j=0;j<N;j++) {
    		  if(map[i][j]==0 || visited[i][j]) continue;
    		
    		  visited[i][j]=true;
    		  int count = dfs(i, j); // 단지 내 집 개수
    		  list.add(count);
    	   }
       }
       Collections.sort(list);
       System.out.println(list.size());
       for(int i=0;i<list.size();i++) {
    	   System.out.println(list.get(i));
       }
    }
    static int N;
    static int [][] map;
    static boolean visited[][];
    static int[] dx= {1,0,-1,0};
    static int[] dy= {0,1,0,-1};
    
    static int dfs(int x,int y) {
    	int count = 1;
    	
    	
    	for(int i=0;i<4;i++) {
    		int nx=x+dx[i];
    		int ny=y+dy[i];
    		
    		if(!isBoundary(nx,ny) && !visited[nx][ny] && map[nx][ny]!=0) {
    			visited[nx][ny]=true;
    			count +=dfs(nx,ny); 
    		}
    		
    	}
    	return count;
    }
    
    static boolean isBoundary(int i,int j) {
    	if(i<0 || i>=N || j<0 || j>=N) return true;
    	return false;
    }
}

