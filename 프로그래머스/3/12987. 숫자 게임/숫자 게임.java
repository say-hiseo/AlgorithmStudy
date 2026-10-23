import java.util.*;
class Solution {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        int point = 0;
        int index = 0;
        for(int a: A){
            while(index<B.length&&B[index]<=a){
                index++;
            }
            if(index<B.length){
                point++;
                index++;
            }
        }
        return point;
    }
}