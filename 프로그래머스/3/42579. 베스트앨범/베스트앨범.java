import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> gencnt = new HashMap<>();
        Map<String, List<int[]>> songMap = new HashMap<>();

      
        for (int i = 0; i < genres.length; i++) {
            gencnt.put(genres[i], gencnt.getOrDefault(genres[i], 0) + plays[i]);
            
            if (songMap.get(genres[i]) == null) {
                songMap.put(genres[i], new ArrayList<>());
            }
            songMap.get(genres[i]).add(new int[]{i, plays[i]});
        }

    
        List<String> sortgen = new ArrayList<>(gencnt.keySet());
        sortgen.sort((a, b) -> gencnt.get(b) - gencnt.get(a));

        List<Integer> result = new ArrayList<>();

        for (String genre : sortgen) {
            List<int[]> songs = songMap.get(genre);
            songs.sort((a, b) -> b[1] == a[1] ? a[0] - b[0] : b[1] - a[1]);

            result.add(songs.get(0)[0]);
            if (songs.size() > 1) result.add(songs.get(1)[0]);
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}
