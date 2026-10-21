import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, PriorityQueue<Music>> map = new HashMap<>();
        Map<String, Integer> count = new HashMap<>();
        for(int i=0; i<genres.length; i++){
            count.put(genres[i], count.getOrDefault(genres[i], 0)+plays[i]);
            map.put(genres[i], map.getOrDefault(genres[i], new PriorityQueue<Music>()));
            map.get(genres[i]).add(new Music(i, plays[i]));
        }
        
        List<String> genre = new ArrayList<>(count.keySet());
        genre.sort((a, b) -> count.get(b) - count.get(a));
        List<Integer> list = new ArrayList<>();
        for(String g: genre){
            PriorityQueue<Music> pq = map.get(g);
            list.add(pq.poll().index);
            if(!pq.isEmpty()) list.add(pq.poll().index);
        }
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
    
     class Music implements Comparable<Music>{
        int index;
        int play;
         
        public Music(int i, int p){
            this.index = i;
            this.play = p;
        }
        
        @Override
        public int compareTo(Music o){
            if(o.play == this.play) return this.index - o.index;
            return o.play - this.play;
        }
    }
}