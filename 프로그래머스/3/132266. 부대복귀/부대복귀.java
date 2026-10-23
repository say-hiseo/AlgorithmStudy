import java.util.*;
class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        for(int i=0; i<=n; i++){
            lists.add(new ArrayList<>());
        }
        for(int[] r:roads){
            lists.get(r[0]).add(r[1]);
            lists.get(r[1]).add(r[0]);
        }
        int m = sources.length;
        int[] dist = new int[n+1];
        Arrays.fill(dist, -1);
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(destination);
        boolean[] visited = new boolean[n+1];
        visited[destination] = true;
        int d = 0;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                int cur = q.poll();
                dist[cur] = d;
                for(int next : lists.get(cur)){
                    if(visited[next]) continue;
                    q.offer(next);
                    visited[next] = true;
                }
            }
            d++;
        }
        int[] answer = new int[m];
        for(int i=0; i<m; i++){
            answer[i] = dist[sources[i]];
        }
        return answer;
    }
    
    
}