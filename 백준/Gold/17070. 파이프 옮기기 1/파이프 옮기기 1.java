

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		house=new int[N+1][N+1];
		
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				house[i][j]=sc.nextInt();
			}
		}
		
		cnt=0;
		
		
		//→, ↘, ↓ 방향
		//벽이 아니어야 함
		//dfs
		
		go(1,2,0);//dir 0:가로, 1:세로, 2: 대각선
		
		System.out.println(cnt);
		
	}
	
	static int N,cnt;
	static int[][] house;
	
	static void go(int x,int y, int dir) {
		if(x>N || y>N) return;//경계 벗어남
		if(house[x][y]==1) return;//벽
		
		if(dir==2) {// 대각선일때 주변 두칸도 빈칸이어야함
			if(house[x][y-1]==1 || house[x-1][y]==1) return;
		}
		
		//항상 파이프의 끝-> 다음이동 후 파이프 시작부분
		
		if(x==N && y==N) { 
			cnt++;//도착
			return;
		}
		
		if(dir==0) {//가로		
			go(x,y+1,0);
			go(x+1,y+1,2);
			
		}
		else if(dir==1)	{//세로
			go(x+1,y,1);
			go(x+1,y+1,2);
		}
		else {//대각선
			go(x,y+1,0);
			go(x+1,y,1);
			go(x+1,y+1,2);
		}
	}
}
