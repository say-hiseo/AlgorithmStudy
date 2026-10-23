import java.util.*;
class Solution {
    public int[] solution(String[] gems) {
        Set<String> set = new HashSet<>();
        for(String g: gems){
            set.add(g);
        }
        int total = set.size();
        int[] answer = new int[]{1,total};
        if(gems.length == total) return answer;
        
        
        int left = 0;
        int right = total-1;
        Map<String, Integer> check = new HashMap<>();
        
        for(int i=left; i<=right; i++){
            check.put(gems[i], check.getOrDefault(gems[i],0)+1);
        }
        if(check.size()==total) return answer;
        
        answer = new int[]{1,gems.length};
        while(left<right){
            if(check.size()>=total || right==gems.length-1){
                if(check.get(gems[left])==1){
                    check.remove(gems[left]);
                } else {
                    check.put(gems[left], check.getOrDefault(gems[left],0)-1);
                }
                left++;
            } else if(right<gems.length-1){
                right++;
                check.put(gems[right], check.getOrDefault(gems[right],0)+1);
            }
            
            if(check.size()==total && (answer[1]-answer[0]>right-left)){
                answer = new int[]{left+1, right+1};
            }
        }
        return answer;
    }
}