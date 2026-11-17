import java.util.*;
class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int wide = w*2+1;
        int start = 1;
        
        for(int s : stations){
            int left = s-w;
            if (start < left) {
                int len = left-start;
                answer += len%wide==0? len/wide : len/wide+1;
                // answer += (len + wide - 1) / wide;   // 올림 나눗셈
            }
            start = s+w+1;
        }
        if(start<=n) {
            int len = n - start + 1;
            answer += (n - start+1)%wide==0? (n - start+1)/wide : (n - start+1)/wide+1;
        }
        return answer;
    }
}