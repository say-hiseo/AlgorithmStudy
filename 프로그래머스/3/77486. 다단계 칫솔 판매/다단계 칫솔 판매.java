import java.util.*;
class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        Map<String, Person> map = new HashMap<>();
        for(int i=0; i<enroll.length; i++){
            map.put(enroll[i], new Person(i, referral[i]));
        }
        int[] answer = new int[enroll.length];
        for(int i=0; i<seller.length; i++){
            String sell = seller[i];
            int money = amount[i]*100;
            while(map.containsKey(sell)){
                Person p = map.get(sell);
                int next = (int)(money*0.1);
                int cur = money - next;
                answer[p.index] += cur;
                money = next;
                sell = p.parent;
                if(next==0) break;
            }
            
        }
        return answer;
    }
    
    static class Person {
        int index;
        String parent;
        
        public Person (int i, String p){
            this.index = i;
            this.parent = p;
        }
    }
}