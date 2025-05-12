import java.util.*;

public class Solution {
    // 빈 공간을 나타내는 직사각형 클래스
    static class Rect {
        int w, h;
        Rect(int w, int h) { this.w = w; this.h = h; }
    }

    // 하나의 M×M 타일과 그 위의 빈 공간 관리 클래스
    static class Stock {
        List<Rect> free;  // 남은 빈 공간 사각형 목록
        Stock(int M) {
            free = new ArrayList<>();
            free.add(new Rect(M, M));
        }
        // 한 변 길이 s짜리 정사각형을 배치하려 시도
        boolean pack(int s) {
            int bestIdx = -1, bestArea = Integer.MAX_VALUE;
            // 가능한 빈 공간들 중 최소 면적의 것을 골라 배치
            for (int i = 0; i < free.size(); i++) {
                Rect r = free.get(i);
                if (r.w >= s && r.h >= s) {
                    int area = r.w * r.h;
                    if (area < bestArea) {
                        bestArea = area;
                        bestIdx = i;
                    }
                }
            }
            if (bestIdx < 0) return false;  // 못 넣으면 실패
            Rect r = free.remove(bestIdx);
            // 가로 절단(오른쪽 잔여)과 세로 절단(아래 잔여)
            if (r.w - s > 0) free.add(new Rect(r.w - s, r.h));
            if (r.h - s > 0) free.add(new Rect(s, r.h - s));
            return true;  // 배치 성공
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            Integer[] sizes = new Integer[N];
            for (int i = 0; i < N; i++) {
                int Si = sc.nextInt();
                sizes[i] = 1 << Si;  // 2^Si 크기의 정사각형
            }
            // 큰 것부터 배치하기 위해 내림차순 정렬
            Arrays.sort(sizes, Collections.reverseOrder());

            List<Stock> stocks = new ArrayList<>();
            for (int s : sizes) {
                boolean placed = false;
                // 기존에 산 타일들에 순차 탐색하며 배치 시도
                for (Stock stk : stocks) {
                    if (stk.pack(s)) {
                        placed = true;
                        break;
                    }
                }
                // 못 넣으면 새 타일 구매
                if (!placed) {
                    Stock newStk = new Stock(M);
                    newStk.pack(s);
                    stocks.add(newStk);
                }
            }

            System.out.println("#" + tc + " " + stocks.size());
        }
        sc.close();
    }
}
