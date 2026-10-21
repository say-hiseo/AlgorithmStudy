class Solution {
    public int solution(int[][] triangle) {
        int n = triangle.length;
        int[][]dp = new int[n][];
        for(int i=0; i<n;i++){
            dp[i] = new int[triangle[i].length];
        }
        dp[0][0] = triangle[0][0];
        for(int i=1; i<n; i++){
            int m = triangle[i].length;
            for(int j=0; j<m; j++){
                if(j==0) dp[i][j] = dp[i-1][0]+triangle[i][0];
                else if(j==m-1) dp[i][j] = dp[i-1][m-2]+triangle[i][m-1];
                else dp[i][j] = Math.max(dp[i-1][j-1]+triangle[i][j], dp[i-1][j]+triangle[i][j]);
            }
        }
        int answer = -1;
        for(int last = 0; last<triangle[n-1].length;last++)
            answer = Math.max(answer, dp[n-1][last]);
        return answer;
    }
}