

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        // 아이템의 개수와 배낭의 최대 용량 입력받기
        int n = sc.nextInt();   // 아이템 수
        int k = sc.nextInt();   // 배낭 최대 용량
        
        int[] w=new int [n+1];//무게
        int[] v=new int [n+1];//가치
        		
        //꼭 1부터 시작하는 인덱스여야 하나?
        for(int i=1;i<=n;i++) {
        	w[i]=sc.nextInt();
        	v[i]=sc.nextInt();
        }
        
        int[][] dp=new int[n+1][k+1];// i번째까지의 아이템으로 남은 배낭 용량이 j일때 얻을 수 있는 최대가치
        
        // dp[0][j]와 dp[i][0]은 자동 0이므로 초기값 설정 생략
        
        for(int i=1;i<=n;i++) {
        	for(int j=0;j<=k;j++) {
        		
        		// 아이템 i를 담을 수 없는 경우 (배낭 용량 부족)
        		//j는 배낭의 남은 용량
        		if(j<w[i]) {
        			dp[i][j]=dp[i-1][j];
        		}
        		else {
                    // 아이템 i를 담지 않는 경우와 담는 경우 중 큰 값을 선택
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i]] + v[i]);
                    //아이템 i를 배낭에 담으면, 남은 용량은 j - w[i]
                    //남은 용량에 대해, 이전 아이템들(i-1개)로 얻을 수 있는 최대 가치는 dp[i - 1][j - w[i]]
                    //따라서 i를 담았을떄 dp[i][j]는 현재 아이템 i의 가치 v[i]를 더한값 dp[i - 1][j - w[i]] + v[i]
                }
        		
        	}
        }
       
        System.out.println(dp[n][k]);
        
	}
}
