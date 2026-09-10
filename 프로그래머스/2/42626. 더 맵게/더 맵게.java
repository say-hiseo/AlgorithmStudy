import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int s:scoville) pq.add((long)s);
        int answer = 0;
        while(pq.peek()<K){
            long f = pq.poll();
            long s = pq.poll();
            pq.add(f+s*2);
            answer++;
            if(pq.size()==1) break;
        }
        if(pq.peek()<K) return -1;
        return answer;
    }
}