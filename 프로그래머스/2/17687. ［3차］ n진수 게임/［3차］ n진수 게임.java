import java.util.*;
class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        sb.append("01");
        for(int i=2;i<t*m;i++){
            sb.append(Integer.toString(i, n));
        }
        
        StringBuilder answer = new StringBuilder();
        int index = p-1;
        while(t-->0){
            answer.append(sb.toString().charAt(index));
            index += m;
        }
        return answer.toString().toUpperCase();
    }
}