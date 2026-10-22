import java.util.*;
class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n][m];
        for(int i=0; i<n; i++) dp[i][0] = 1;
        for(int j=0; j<m; j++) dp[0][j] = 1;
        for(int[] p: puddles){
            dp[p[1]-1][p[0]-1] = -1;
            if(p[1]-1==0){
                for(int k=p[0];k<m;k++) dp[0][k] = -1;
            } else if(p[0]-1==0){
                for(int k=p[1];k<n;k++) dp[k][0] = -1;
            }
        }
        for(int i=1; i<n; i++){
            for(int j=1; j<m; j++){
                if(dp[i][j]==-1) continue;
                if(dp[i-1][j]==-1 && dp[i][j-1]==-1){
                    dp[i][j] = 0;
                } else if(dp[i-1][j]==-1){
                    dp[i][j] = dp[i][j-1];
                } else if(dp[i][j-1]==-1){
                    dp[i][j] = dp[i-1][j];
                } else dp[i][j] = (dp[i-1][j]+dp[i][j-1])%1_000_000_007;
            }
        }
        return dp[n-1][m-1];
    }
}