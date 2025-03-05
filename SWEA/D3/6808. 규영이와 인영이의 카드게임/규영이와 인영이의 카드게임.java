
import java.util.Scanner;

public class Solution {
	static int[] gyu; // 규영이 카드
    static int[] inyoung,input; // 인영이 카드
    static boolean[] used; 
    
    static int winCount, loseCount; // 승패 카운트
    
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			
			//순열+백트래킹!!
			gyu = new int[9];
            boolean[] isUsed = new boolean[19];
			
			for(int i=0;i<9;i++) {
				gyu[i] = sc.nextInt();
                isUsed[gyu[i]] = true;
			}
		
			 // 인영이 카드 찾기
            inyoung = new int[9];
            int index = 0;
            for (int i = 1; i <= 18; i++) {
                if (!isUsed[i]) {
                    inyoung[index++] = i;
                }
            }
            
            used = new boolean[9];
            winCount = 0;
            loseCount = 0;
            input=new int[9];
            bt(0);
        
            System.out.println("#"+tc+" "+ winCount + " " + loseCount);
		}
	}
	
	static void bt(int cnt) {
		if(cnt==9) {
			play();
			return;
		}
		for(int i=0;i<9;i++) {
			if(!used[i]) {
				used[i]=true;
				input[cnt]=inyoung[i];
				bt(cnt+1);
				used[i]=false;
				
			}
		}
	}
	static void play() {
		int gyuSc=0,inyoungSc=0;
		
		for(int i=0;i<9;i++) {
			if(gyu[i]>input[i]) gyuSc+=gyu[i]+input[i];
			else inyoungSc+=gyu[i]+input[i];
		}
		
		 if (gyuSc > inyoungSc) winCount++;
	        else if (gyuSc < inyoungSc) loseCount++;
	}
}