import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for(int w : works){
            pq.offer(w);
        }
        int time = n;
        while(!pq.isEmpty()&&n-->0){
            int cur = pq.poll()-1;
            if(cur==0) continue;
            pq.offer(cur);
        }
        long answer = 0;
        while(!pq.isEmpty()){
            int w = pq.poll();
            answer+=Math.pow(w,2);
        }
        return answer;
    }
}