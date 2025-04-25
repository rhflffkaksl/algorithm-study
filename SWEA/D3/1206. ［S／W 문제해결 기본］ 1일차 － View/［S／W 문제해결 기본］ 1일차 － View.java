import java.io.IOException;
import java.util.Scanner;

class Solution {

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        for (int tc = 1; tc <= 10; tc++) {
	            int N = sc.nextInt();
	            int[] buildings = new int[N];

	            for (int i = 0; i < N; i++) {
	                buildings[i] = sc.nextInt();
	            }

	            int result = 0;

	            // i: 2 ~ N-3 (양쪽 2칸은 항상 0이므로 탐색 X)
	            for (int i = 2; i < N - 2; i++) {
	                int left1 = buildings[i - 1];
	                int left2 = buildings[i - 2];
	                int right1 = buildings[i + 1];
	                int right2 = buildings[i + 2];

	                int maxNeighbor = Math.max(Math.max(left1, left2), Math.max(right1, right2));

	                if (buildings[i] > maxNeighbor) {
	                    result += buildings[i] - maxNeighbor;
	                }
	            }

	            System.out.println("#" + tc + " " + result);
	        }
	    }
	
}


