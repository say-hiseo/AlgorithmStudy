import java.util.*;
class Solution {
    static int[] arr;
    public int solution(int n, int[][] costs) {
        if(n==1) return 0;
        arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = i;
        }
        
        PriorityQueue<Points> pq = new PriorityQueue<>();
        for(int i=0;i<costs.length; i++){
            int[] cost = costs[i];
            int s = cost[0];
            int e = cost[1];
            int c = cost[2];
            pq.offer(new Points(c,s,e));
        }
        
        int answer = 0;
        while(!pq.isEmpty()){
            Points p = pq.poll();
            if(!isConnect(p.start, p.end)){
                answer += p.cost;
                union(p.start, p.end);
            }
        }
        return answer;
    }
    
    public static boolean isConnect(int a, int b){
        return find(a)==find(b);
    }
    
    public static int find(int a){
        if(arr[a]==a) return a;
        return arr[a] = find(arr[a]);
    }
    
    public static void union(int a, int b){
        int x = find(a);
        int y = find(b);
        if(x < y){
            arr[y] = x;
        } else {
            arr[x] = y;
        }
    }
    
    static class Points implements Comparable<Points>{
        int cost;
        int start;
        int end;
        
        public Points(int c, int s, int e){
            this.cost = c;
            this.start = s;
            this.end = e;
        }
        
        @Override
        public int compareTo(Points o){
            return this.cost - o.cost;
        }
    }
}