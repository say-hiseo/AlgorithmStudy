import java.util.*;
class Solution {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int answer = -1;
        int cur = n;
        for(int i=1; i<=enemy.length; i++){
            if(pq.size()<k){
                pq.offer(enemy[i-1]);
            } else {
                pq.offer(enemy[i-1]);
                cur -= pq.poll();
                if(cur<0) {
                    answer = i-1;
                    break;
                }
            }
        }
        if(answer == -1) answer = enemy.length;
        return answer;
    }
}