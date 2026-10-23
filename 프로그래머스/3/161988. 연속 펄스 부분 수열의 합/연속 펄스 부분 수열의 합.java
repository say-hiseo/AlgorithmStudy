class Solution {
    public long solution(int[] sequence) {
        int n = sequence.length;
        long[] sum1 = new long[n];
        long[] sum2 = new long[n];
        
        int num = 1;
        long answer1 = Long.MIN_VALUE;
        long answer2 = Long.MIN_VALUE;
        long min1 = 0;
        long min2 = 0;
        for(int i=0; i<n; i++){
            sum1[i] = sequence[i]*(long)num;
            sum2[i] = sequence[i]*(long)(num*-1);
            
            if(i!=0){
                sum1[i] += sum1[i-1];
                sum2[i] += sum2[i-1];
            }
            
            answer1 = Math.max(answer1, sum1[i]-min1);
            answer2 = Math.max(answer2, sum2[i]-min2);
            
            min1 = Math.min(min1, sum1[i]);
            min2 = Math.min(min2, sum2[i]);
            
            num *= -1;
        }
        
        
        return Math.max(answer1, answer2);
    }
}