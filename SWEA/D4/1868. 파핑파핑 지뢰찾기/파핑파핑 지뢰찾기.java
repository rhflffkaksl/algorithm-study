
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	    int TC=sc.nextInt();
	    for(int tc=1;tc<=TC;tc++) {
	    	N=sc.nextInt();
	    	map=new char[N][N];
	    	nonpop=0;
	    	for(int i=0;i<N;i++) {
	    		String s=sc.next();
	    		for(int j=0;j<N;j++) {
	    			map[i][j]=s.charAt(j);
	    			if(map[i][j]!='*') nonpop++;
	    		}
	    	}
	    	
	    	//맵에 숫자 저장
	    	for(int i=0;i<N;i++) {
	    		for(int j=0;j<N;j++) {
	    			
	    			if(map[i][j]!='.') continue;
	    			int pop=0;
	    			for(int k=0;k<8;k++) {
	    				
	    				int x=i+dx[k];
	    				int y=j+dy[k];
	    				
	    				if(!isBoundary(x,y) && map[x][y]=='*') pop++; 
	    				
	    			}
	    			map[i][j]=(char)('0'+pop);//int 값 char에 넣기
	    		}
	    	}
	    
	    	clickCnt=0;
	    	visited = new boolean[N][N];
	    	
	    	//시작점 어디로? 0인곳
	    	//0이 없으면 어카지....????왤케 복잡???
	    	for(int i=0;i<N;i++) {
	    		for(int j=0;j<N;j++) {
	    			if(map[i][j]=='0' && !visited[i][j]) {
	    				click(i,j);
	    				clickCnt++;
	    			}
	    			
	    		}
	    	}
	    	
	    	//모든 0영역(연결된 0과 그 주변 셀)을 DFS/BFS로 한 번에 처리한 후
	    	//남은 비지뢰 셀(개별 클릭)이 몇 개 있는지를 더하기!!!-> 이거를 따로해줘야함
	    	
	    	//아직 방문되지 않은 비지뢰 셀은 개별 클릭
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] != '*' && !visited[i][j]) {
                        clickCnt++;
                    }
                }
            }
	    	
	    	
	    	System.out.println("#"+tc+" "+clickCnt);
	    }
	}
	
	static int clickCnt, N,nonpop;
	static char[][] map;
	static boolean[][] visited;
	static int [] dx= {0,1,1,1,0,-1,-1,-1};
	static int [] dy= {1,1,0,-1,-1,-1,0,1};//8방향
	
	static void click(int x,int y) {
		if (isBoundary(x, y) || visited[x][y]) return;
        if (map[x][y] == '*') return;
        
        visited[x][y] = true;//숫자 표시
        if (map[x][y] == '0') { // 0인 경우에만 주변으로 확장
            for (int i = 0; i < 8; i++) {
                int x1 = x + dx[i];
                int y1 = y + dy[i];
                click(x1, y1);
            }
        }
		
	}
	
	static boolean isBoundary(int x, int y) {
		if(x>=N || x<0 ||y>=N || y<0) return true;
		return false;
	}
}
