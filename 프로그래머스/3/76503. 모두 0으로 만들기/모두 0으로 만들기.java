import java.util.*;
class Solution {
    public long solution(int[] a, int[][] edges) {
        long sum = 0;
        boolean flag = true;
        for(long s : a) {
            if(s!=0) flag = false;
            sum += s;
        }
        if(flag) return 0;
        if(sum != 0) return -1;
        
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        for(int i=0; i<a.length; i++){
            lists.add(new ArrayList<>());
        }
        for(int[] e : edges){
            lists.get(e[0]).add(e[1]);
            lists.get(e[1]).add(e[0]);
        }
        
        int[] degree = new int[a.length];
        Queue<Integer> q = new ArrayDeque<>();
        for(int i=0; i<a.length; i++){
            ArrayList<Integer> list = lists.get(i);
            degree[i] = list.size();
            if(degree[i]==1) q.offer(i);
        }
        
        long[] cost = new long[a.length];
        for(int i=0; i<a.length; i++){
            cost[i] = a[i];
        }

        long answer = 0;
        boolean[] visited = new boolean[a.length];
        while(!q.isEmpty()){
            int cur = q.poll();
            if(visited[cur]) continue;
            visited[cur] = true;
            answer += Math.abs(cost[cur]);
            for(int next : lists.get(cur)){
                if(visited[next]) continue;
                cost[next] += cost[cur];
                cost[cur] = 0;
                degree[next]--;
                if(degree[next] == 1){
                    q.offer(next);
                }
            }
        }
        return answer;
    }
}