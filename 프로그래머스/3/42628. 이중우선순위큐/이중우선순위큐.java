import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>((a,b)->b-a);
        for(String o: operations){
            String[] str = o.split(" ");
            int num = Integer.parseInt(str[1]);
            switch(str[0]){
                case "I":
                    minQueue.add(num);
                    maxQueue.add(num);
                    break;
                case "D":
                    if(num==-1){
                        Integer obj = minQueue.poll();
                        maxQueue.remove(obj);
                    } else {
                        Integer obj = maxQueue.poll();
                        minQueue.remove(obj);
                    }
                    break;
            }
        }
        if(maxQueue.isEmpty()) return new int[]{0,0};
        return new int[]{maxQueue.poll(),minQueue.poll()};
    }
}