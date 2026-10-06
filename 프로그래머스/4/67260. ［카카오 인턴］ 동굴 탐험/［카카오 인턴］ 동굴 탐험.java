import java.util.*;
class Solution {
    public boolean solution(int n, int[][] path, int[][] order) {
        int[] preVisited = new int[n];
        Map<Integer,Integer> map = new HashMap<>();
        for(int[] o:order){
            preVisited[o[1]]++;
            map.put(o[0],o[1]);
        }
        if(preVisited[0] > 0) return false;
        
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        for(int i=0;i<n;i++){
            lists.add(new ArrayList<>());
        }
        for(int[] p:path){
            lists.get(p[0]).add(p[1]);
            lists.get(p[1]).add(p[0]);
        }
        
        boolean answer = true;
        boolean[] visited = new boolean[n];
        boolean[] waiting = new boolean[n];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(0);
        visited[0] = true;
        
        int after0 = map.getOrDefault(0, -1);
        if(after0 != -1) preVisited[after0]--;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-->0){
                int cur = queue.poll();
                ArrayList<Integer> curList = lists.get(cur);
                for(int i=0; i<curList.size(); i++){
                    int next = curList.get(i);
                    if(visited[next]) continue;
                    if(preVisited[next]>0) {
                        waiting[next] = true;
                        continue;
                    }
                    visited[next] = true;
                    queue.offer(next);
                    int after = map.getOrDefault(next,-1);
                    if(after != -1){
                        preVisited[after]--;
                        if(preVisited[after]==0 && waiting[after]){
                            visited[after] = true;
                            queue.offer(after);
                        }
                    }
                }
            }
        }
        for(boolean v: visited) {
            if(!v) return false;
        }
        return answer;
    }
}