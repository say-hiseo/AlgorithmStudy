class Solution {
    public int solution(int N, int[][] road, int K) {
        int[][] dist = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
                if(i==j) dist[i][j] = 0;
				else dist[i][j] = K+1;
			}
		}
        for(int[] r : road){
            dist[r[0]][r[1]] = Math.min(dist[r[0]][r[1]], r[2]);
            dist[r[1]][r[0]] = Math.min(dist[r[0]][r[1]], r[2]);
        }
        
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
				}
			}
		}
        
        int cnt = 0;
        for (int i = 1; i <=N; i++) {
            if(dist[1][i]<=K) cnt++;
        }
        
        return cnt;
    }
}