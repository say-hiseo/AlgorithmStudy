import java.util.*;
class Solution {
    static List<int[]> list;
    public int[][] solution(int n) {
        list = new ArrayList<>();
        hanoi(n,1,3);
        int[][] answer = new int[list.size()][2];
        for(int i=0; i< list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
    
    static void hanoi(int cnt, int start, int end){
        if(cnt==1){
            list.add(new int[]{start, end});
            return;
        }
        int via = 6 - start - end;
        hanoi(cnt-1,start,via);
        list.add(new int[]{start, end});
        hanoi(cnt-1,via,end);
    }
}