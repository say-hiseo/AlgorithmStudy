import java.util.*;
class Solution {
    static ArrayList<ArrayList<Integer>> lists;
    static int[][] dp;
    public int solution(int n, int[][] lighthouse) {
        lists = new ArrayList<>();
        for(int i=0; i<n+1; i++){
            lists.add(new ArrayList<>());
        }
        for(int[] l: lighthouse){
            lists.get(l[0]).add(l[1]);
            lists.get(l[1]).add(l[0]);
        }
        dp = new int[n+1][2];
        dfs(1,0);
        return Math.min(dp[1][0], dp[1][1]);
    }
    
    static void dfs(int cur, int parent){
        dp[cur][0] = 0;
        dp[cur][1] = 1;
        
        for(int next : lists.get(cur)){
            if(next == parent) continue;
            dfs(next, cur);
            dp[cur][0] += dp[next][1];
            dp[cur][1] += Math.min(dp[next][0], dp[next][1]);
        }
    }
}