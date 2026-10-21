class Solution {
    public int solution(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        if (n >= 2) dp[2] = 2;
        for(int i=3; i<n+1; i++){
//          맨 오른쪽 끝을 어떻게 채웠나?
//          - 세로 타일 1개를 놓았다 → 왼쪽에 2×(n−1)이 남음
//          - 가로 타일 2개를 위아래로 놓았다 → 왼쪽에 2×(n−2)가 남음
            dp[i] = (dp[i-1]+dp[i-2])%1_000_000_007;
        }
        return dp[n];
    }
}