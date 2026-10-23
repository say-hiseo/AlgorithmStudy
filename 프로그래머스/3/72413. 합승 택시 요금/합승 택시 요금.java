import java.util.*;
class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int[][] map = new int[n+1][n+1];
        int INF = 100_000_000;
        for(int[] m : map){
            Arrays.fill(m,INF);
        }
        for(int[] f : fares){
            map[f[0]][f[1]] = f[2];
            map[f[1]][f[0]] = f[2];
        }
        for(int k=1; k<=n; k++){
            for(int i=1; i<=n; i++){
                for(int j=1; j<=n; j++){
                    if(i==j) map[i][j] = 0;
                    map[i][j] = Math.min(map[i][j], map[i][k]+map[k][j]);
                }
            }
        }
        
        int answer = map[s][a] + map[s][b];
        for(int k=1; k<=n; k++){
            answer = Math.min(answer, map[s][k]+map[k][a]+map[k][b]);
        }
        return answer;
    }
}