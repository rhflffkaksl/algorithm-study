import java.io.*;

public class Solution {
    static int N, answer;
    static int[] queens; // queens[i] = i행에 놓인 퀸의 열 위치

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            queens = new int[N]; // N개의 행에 대해 퀸의 위치 저장
            answer = 0;

            solve(0); // 0번째 행부터 퀸 배치 시작

            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }
        System.out.print(sb);
    }

    // 백트래킹으로 퀸 배치
    static void solve(int row) {
        if (row == N) { // N개의 퀸이 모두 배치된 경우
            answer++;
            return;
        }

        for (int col = 0; col < N; col++) {
            if (isValid(row, col)) { // 현재 (row, col)에 배치 가능한지 확인
                queens[row] = col; // 퀸 배치
                solve(row + 1); // 다음 행으로 이동
            }
        }
    }

    // 현재 위치 (row, col)에 퀸을 배치할 수 있는지 검사
    static boolean isValid(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (queens[i] == col) return false; // 같은 열에 퀸이 존재
            if (Math.abs(row - i) == Math.abs(col - queens[i])) return false; // 대각선 충돌
        }
        return true;
    }
}
