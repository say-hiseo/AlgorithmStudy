import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        for(int[] r:routes) {
            pq.offer(r);
        }
        int answer = 0;
        int camera = -30001;
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            if(cur[0]<=camera) continue;
            camera = cur[1];
            answer++;
        }
        return answer;
    }
}