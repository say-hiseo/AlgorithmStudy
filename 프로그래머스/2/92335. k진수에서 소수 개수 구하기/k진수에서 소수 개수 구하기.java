import java.util.*;
import java.math.*;
class Solution {
    public int solution(int n, int k) {
        String bn = Long.toString(n,k);
        String[] sosus = bn.split("0");
        int answer = 0;
        for(String s : sosus) {
            if(s.equals("") || s.equals("1")) continue;
            long number = Long.parseLong(s);
            if(isSosu(number)) answer++;
        }
        return answer;
    }
    
    public static boolean isSosu(long num){
        for(int i=2; i <= Math.sqrt(num); i++){
            if(num%i==0) return false;
        }
        return true;
    }
}