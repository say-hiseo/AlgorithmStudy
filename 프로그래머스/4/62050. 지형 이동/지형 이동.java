import java.util.*;
class Solution {
    public int solution(int[][] land, int height) {
        PriorityQueue<Point> pq = new PriorityQueue<>();
        int n = land.length;
        boolean[][] visited = new boolean[n][n];
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        
        int answer = 0;
        pq.add(new Point(0, 0, 0));
        while(!pq.isEmpty()){
            Point p = pq.poll();
            if(visited[p.x][p.y]) continue;
            visited[p.x][p.y] = true;
            answer += p.c;
            
            for(int d=0;d<4;d++){
                int nx = p.x + dx[d];
                int ny = p.y + dy[d];
                        
                if(nx<0||ny<0||nx>=n||ny>=n||visited[nx][ny]) continue;
                        
                int diff = Math.abs(land[p.x][p.y]-land[nx][ny]);
                int nc = diff > height ? diff : 0;
                
                pq.offer(new Point(nc, nx, ny));
            }
        }
        return answer;
    }
    
    static class Point implements Comparable<Point> {
        int c;
        int x;
        int y;
        
        public Point(int c, int x, int y){
            this.c = c;
            this.x = x;
            this.y = y;
        }
        
        @Override
        public int compareTo(Point o){
            return this.c - o.c;
        }
    }
}