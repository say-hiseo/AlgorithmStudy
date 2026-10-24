class Solution {
    public int solution(String[] lines) {
        // "2016-09-15 01:00:04.001 2.0s"
        int[] start = new int[lines.length];
        int[] end = new int[lines.length];
        for(int i=0; i<lines.length; i++){
            String l = lines[i];
            String[] str = l.split(" ");
            String[] t = str[1].split(":");
            int time = (Integer.parseInt(t[0])*3600+Integer.parseInt(t[1])*60)*1000+changeMils(t[2]);
            int term = changeMils(str[2]);
            start[i] = time-term+1;
            end[i] = time;
        }
        int answer = 0;
        for(int i=0; i<lines.length;i++){
            int a = end[i];
            int b = a + 999;
            int count = 0;
            for(int j=i; j<lines.length; j++){
                if(a<=end[j]&&start[j]<=b) count++;
            }
            answer = Math.max(answer, count);
        }
        return answer;
    }
    
    static int changeMils(String s){
        s=s.replace("s","");
        String[] str = s.split("\\.");
        int ans = Integer.parseInt(str[0])*1000;
        if(str.length==1)return ans;
        while(str[1].length()<3){
            str[1] += "0";
        }
        return ans+Integer.parseInt(str[1]);
    }
}