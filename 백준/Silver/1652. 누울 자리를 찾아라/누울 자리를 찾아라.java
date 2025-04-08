import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		char[][] arr=new char[n][n];
		int h=0; //가로
		int v=0; //세로
		
		for(int i=0;i<n;i++) {
			int cnt=0;
			String s=sc.next();
			for(int j=0;j<n;j++) {
				arr[i][j]=s.charAt(j);
				//가로를 세봐요
				
				if(arr[i][j]=='X' ) {
					if(cnt>=2) h++;
					cnt=0;
				}else if(j==n-1) {
					cnt++;
					if(cnt>=2) h++;
				}else cnt++;
			}
		}
		
		for(int i=0;i<n;i++) {
			int cnt=0;
			for(int j=0;j<n;j++) {
				//세로를 세봐요
			
				if(arr[j][i]=='X' ) {
					if(cnt>=2) v++;
					cnt=0;
				}else if(j==n-1) {
					cnt++;
					if(cnt>=2) v++;
				}else cnt++;
			}
		}
			
			System.out.println(h+" "+v);
		}
		
		
	}

	


