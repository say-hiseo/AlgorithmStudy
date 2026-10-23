import java.util.*;
class Solution {
    public String solution(String number, int k) {
        Stack<Character> st = new Stack<>();
        int cnt = k;
        for(int i=0; i<number.length(); i++){
            char num = number.charAt(i);
            if(st.isEmpty()){
                st.push(num);
                continue;
            }
            if(cnt>0){
                while(!st.isEmpty()&&st.peek()<num&cnt>0){
                    st.pop();
                    cnt--;
                }
            }
            st.push(num);
        }
        while(cnt-- > 0){
            st.pop();
        }
        StringBuilder answer = new StringBuilder();
        while(!st.isEmpty()){
            answer.append(st.pop());   
        }
        return answer.reverse().toString();
    }
}