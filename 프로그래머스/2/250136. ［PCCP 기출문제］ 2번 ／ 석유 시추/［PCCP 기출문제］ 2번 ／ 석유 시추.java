import java.util.*;
class Solution {
    public int solution(int[][] land) {
        int n = land.length;
        int m = land[0].length;
        
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,-1,1};
        boolean[][] visited  = new boolean[n][m];
        
        int[] colSum = new int[m];
        int[] lastId = new int[m];
        Arrays.fill(lastId, -1);
        int id = 0;
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(land[i][j]== 1 && !visited[i][j]){
                    Queue<int[]> oil = new ArrayDeque<>();
                    Queue<int[]> q = new ArrayDeque<>();
                    q.offer(new int[]{i,j});
                    visited[i][j] = true;
                    int cnt = 0;
                    while(!q.isEmpty()){
                        int[] cur = q.poll();
                        oil.offer(cur);
                        for(int k=0; k<4; k++){
                            int nx = cur[0]+dx[k];
                            int ny = cur[1]+dy[k];
                            
                            if(nx<0||ny<0||nx>=n||ny>=m||visited[nx][ny]||land[nx][ny]==0) continue;
                            
                            visited[nx][ny] = true;
                            q.offer(new int[]{nx,ny});
                        }
                        cnt++;
                    }
                    
                    while(!oil.isEmpty()){
                        int[] cur = oil.poll();
                        int col = cur[1];
                        if(lastId[col] != id){
                            colSum[col] += cnt;
                            lastId[col] = id;
                        }
                    }
                    id++;
                }
            }
        }
        
        int answer = 0;
        for(int s : colSum) answer = Math.max(answer, s);
        return answer;
    }
}