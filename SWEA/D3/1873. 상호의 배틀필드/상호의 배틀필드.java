import java.io.*;
import java.util.*;

public class Solution {
    static int H, W;
    static char[][] map;
    // 방향: U, D, L, R -> dy, dx, 기호
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static char[] dirChar = {'^', 'v', '<', '>'};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            map = new char[H][W];

            int ty = 0, tx = 0, dir = 0;
            // 맵 입력 및 전차 위치·방향 찾기
            for (int i = 0; i < H; i++) {
                String line = br.readLine();
                for (int j = 0; j < W; j++) {
                    char c = line.charAt(j);
                    map[i][j] = c;
                    if (c == '^' || c == 'v' || c == '<' || c == '>') {
                        ty = i; tx = j;
                        if (c == '^') dir = 0;
                        else if (c == 'v') dir = 1;
                        else if (c == '<') dir = 2;
                        else if (c == '>') dir = 3;
                    }
                }
            }

            int N = Integer.parseInt(br.readLine().trim());
            String commands = br.readLine();

            // 명령 처리
            for (char cmd : commands.toCharArray()) {
                if (cmd == 'S') {
                    shoot(ty, tx, dir);
                } else {
                    // 이동 명령
                    int nd = 0;
                    if (cmd == 'U') nd = 0;
                    else if (cmd == 'D') nd = 1;
                    else if (cmd == 'L') nd = 2;
                    else if (cmd == 'R') nd = 3;
                    // 방향 전환
                    map[ty][tx] = dirChar[nd];
                    dir = nd;
                    // 이동 시도
                    int ny = ty + dy[dir], nx = tx + dx[dir];
                    if (0 <= ny && ny < H && 0 <= nx && nx < W && map[ny][nx] == '.') {
                        map[ty][tx] = '.';  // 기존 위치 평지로
                        ty = ny; tx = nx;
                        map[ty][tx] = dirChar[dir];
                    }
                }
            }

            // 결과 출력
            sb.append('#').append(tc).append(' ');
            for (int i = 0; i < H; i++) {
                sb.append(new String(map[i])).append('\n');
            }
        }

        System.out.print(sb);
    }

    // 포탄 발사 처리
    static void shoot(int y, int x, int dir) {
        int cy = y, cx = x;
        while (true) {
            cy += dy[dir];
            cx += dx[dir];
            if (cy < 0 || cy >= H || cx < 0 || cx >= W) break;  // 맵 밖
            if (map[cy][cx] == '*') {  // 벽돌
                map[cy][cx] = '.';
                break;
            } else if (map[cy][cx] == '#') {
                break;  // 강철
            }
        }
    }
}
