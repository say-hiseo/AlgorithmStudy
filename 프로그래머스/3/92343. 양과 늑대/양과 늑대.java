import java.util.*;
class Solution {
    static ArrayList<ArrayList<Integer>> lists;
    static int answer;
    static int[] information;
    public int solution(int[] info, int[][] edges) {
        lists = new ArrayList<>();
        information = info;
        for(int i=0; i<info.length; i++){
            lists.add(new ArrayList<>());
        }
        for(int[] e : edges){
            lists.get(e[0]).add(e[1]);
        }
        answer = info[0]==0? 1 : 0;
        dfs(answer,info[0]==1? 1 : 0,new ArrayList<>(lists.get(0)));
        return answer;
    }
    
    static void dfs(int sheep, int wolf, ArrayList<Integer> cur){
        answer = Math.max(answer, sheep);
        // 방문한 뒤의 상태 검사
        if(sheep <= wolf) return;
        for(int c : cur){ // 다음에 c를 방문한다면?
            ArrayList<Integer> next = new ArrayList<>(cur);
            next.remove(Integer.valueOf(c));
            for(int n : lists.get(c)) next.add(n);
            if(information[c]==0) dfs(sheep+1, wolf, next);
            else dfs(sheep, wolf+1, next);
        }
    }
}