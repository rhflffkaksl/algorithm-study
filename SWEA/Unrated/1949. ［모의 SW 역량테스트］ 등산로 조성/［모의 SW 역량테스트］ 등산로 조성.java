
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 등산로 DFS로 가다가 막히면 1~K만큼 깎고 가보기
 * 1. 입력 받기
 * 2. 가장 높은 봉우리부터 등산로 조성 시도 : DFS
 * 3. 최대 등산로 길이 갱신
 * 4. 출력
 *
 */
public class Solution {
	static int N, K;
	static int[][] map;	
	static boolean[][] visited;
	static int result;
	static int[] dr = {-1,1,0,0}; //상, 하, 좌, 우
	static int[] dc = {0,0,-1,1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			//1. 입력 받기
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			visited = new boolean[N][N];
			int top = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j<N; j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
					top = Math.max(top, map[i][j]); //가장 높은 봉우리의 높이 찾아주기
				}
			}
			
			
			//2. 가장 높은 봉우리부터 등산로 조성 시도 : DFS
			result=Integer.MIN_VALUE; //가장 긴 등산로를 찾기 위해서 작은 값으로 초기화
 			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j]==top) {
						visited[i][j]=true;
						dfs(i, j, map[i][j],0,1);
						visited[i][j]=false;
					}
				}
			}
 			System.out.println("#"+t+" "+result);
		}

	}
	/**
	 * 출발 봉우리부터 조성할 수 있는 등산로까지 가보기
	 * @param r 현재 위치 좌표 R
	 * @param c 현재 위치 좌표 C
	 * @param height 현재 높이
	 * @param cutNum 깍은 횟수
	 * @param count 등산로 길이
	 */
	static void dfs(int r, int c, int height,int cutNum, int count) {
		//최대 등산로 길이 갱신
		result = Math.max(result, count); //최대 등산로 길이 갱신
		
		//현재 위치에서 갈 수 있는 4방향으로 가보기
		for (int d = 0; d < 4; d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			if(nr>=0 && nr<N&& nc>=0&&nc<N && !visited[nr][nc]) { //경계 체크
				if(height>map[nr][nc]) {//다음 위치의 높이가 지금보다 낮으면 등산로 조성 가능
					visited[nr][nc] = true;
					dfs(nr,nc, map[nr][nc], cutNum, count+1);
					visited[nr][nc] = false;
				}else{ //못가는 경우
					//1~K만큼 깎는 시도를 해봐도 됨
//						for (int k = 1; k <= K; k++) {
//							if(cutNum==0&& height>map[nr][nc]-k) {
//								visited[nr][nc] = true;
//								dfs(nr,nc, map[nr][nc]-k, cutNum+1, count+1);
//								visited[nr][nc] = false;
//							}
//						}

					//한번도 깎은적 없어서 깎을 수 있고
					if(cutNum==0&& height>map[nr][nc]-K) {//높이 깎았을 때 , 갈 수 있으면 조성하러 가기
						visited[nr][nc]=true;
						//깎는 높이는 현재 높이-1로 전달
						dfs(nr, nc, height-1, cutNum+1, count+1);
						visited[nr][nc]=false;
					}
				}
			}
		}
	}

}
