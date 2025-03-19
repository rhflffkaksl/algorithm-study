import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
        int[] one = {1, 2, 3, 4, 5};//5
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5};//8
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};//10
        
        int[] scores = new int[3];
        
       for (int i = 0; i < answers.length; i++) {
            if (answers[i] == one[i % one.length]) scores[0]++;
            if (answers[i] == two[i % two.length]) scores[1]++;
            if (answers[i] == three[i % three.length]) scores[2]++;
        }

        int maxScore = Math.max(scores[0], Math.max(scores[1], scores[2])); // 최고 점수 찾기

        
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if (scores[i] == maxScore) result.add(i + 1);
        }
        
        return result.stream().mapToInt(i -> i).toArray();
    }
}