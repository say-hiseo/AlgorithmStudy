import java.util.*;
class Solution {
    static ArrayList<ArrayList<Integer>> lists;
    static int[][] dp;
    public int solution(int[] sales, int[][] links) {
        int n = sales.length;
        lists = new ArrayList<>();
        for(int i=0; i<n; i++){
            lists.add(new ArrayList<>());
        }
        for(int[] l: links){
            lists.get(l[0]-1).add(l[1]-1);
        }
        dp = new int[n][2];
        dfs(0,sales);
        return Math.min(dp[0][0], dp[0][1]);
    }
    
    static void dfs(int cur,int[] sales){
        dp[cur][1] = sales[cur];
        dp[cur][0] = 0;
        if(lists.get(cur).size()==0) return;
        
        int sum = 0;
        boolean participate = false;
        
        for(int child : lists.get(cur)){
            dfs(child,sales);
            dp[cur][1] += Math.min(dp[child][0],dp[child][1]);
            if(dp[child][0]>dp[child][1]){
                participate = true;
            }
             dp[cur][0] += Math.min(dp[child][0],dp[child][1]);
            sum += dp[child][0];
        }
        
        if(!participate){
            dp[cur][0] = 0;
            int min = Integer.MAX_VALUE;
            for(int child : lists.get(cur)){
                min = Math.min(min, sum-dp[child][0]+dp[child][1]);
            }
            dp[cur][0] += min;
        }
    }
}