import java.util.*;
class Solution {
    public int solution(int N, int number) {
        if (N == number) return 1;
        
        Set<Integer>[] dp = new Set[9];
        dp[1] = new HashSet<>();
        dp[1].add(N);
        
        for(int i=2; i<9; i++){
            dp[i] = new HashSet<>();
            
            int concat = 0;
            for (int c = 0; c < i; c++) {
                concat = concat * 10 + N;
            }
            dp[i].add(concat);
            
            for(int j=1; j<i; j++){
                for (int a : dp[j]) {
                    for (int b : dp[i - j]) {
                        dp[i].add(a + b);
                        dp[i].add(a - b);
                        dp[i].add(a * b);
                        if (b != 0) dp[i].add(a / b);
                    }
                }
            }
            
            if(dp[i].contains(number)) return i;
        }
        return -1;
    }
}