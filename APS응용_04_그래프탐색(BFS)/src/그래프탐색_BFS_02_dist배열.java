import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * 2차원 미로에서 거리 배열을 이용해 최단 길이를 구한다.
 * 0은 통로, 1은 벽이며 상·하·좌·우로만 이동한다.
 *
 * <p>distance[r][c]는 시작 칸부터 해당 칸까지의 이동 횟수이다.
 * -1은 아직 방문하지 않았다는 뜻으로 사용하므로 별도의 visited 배열이 필요 없다.
 * 각 칸은 최대 한 번 큐에 들어가며 시간·공간 복잡도는 모두 O(행 * 열)이다.</p>
 */
public class 그래프탐색_BFS_02_dist배열 {
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
    public static void main(String[] args) {
    	int N = 8;
    	int[][] maze = new int[][] {
    		{0, 0, 1, 1, 1, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 0, 1, 1, 1, 1},
            {1, 1, 1, 0, 1, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 1, 1, 1, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 0, 0},
            {1, 1, 1, 1, 1, 1, 1, 0}
            };
    	int[][] dist = new int[8][8];
    	// (0,0), (N-1, N-1) 까지 갈 수 있는가?
    	for(int[] tmp : dist) {
    		Arrays.fill(tmp, -1);
    	}
    	
    	Queue<int[]> q = new ArrayDeque<>();
    	q.add(new int[] {0, 0});
    	dist[0][0] = 0;
    	
    	while(!q.isEmpty()) {
    		int[] curr = q.poll();
    		int r = curr[0];
    		int c = curr[1];
    		
    		if(r == N-1 && c == N-1) {
    			System.out.println(dist[N-1][N-1]);
    			break;
    		}
    		
    		for(int i = 0; i < 4; i++) {
    			int nr = r + dr[i];
    			int nc = c + dc[i];
    			
    			// 1. 범위 체크(항상 먼저 수행할 것)
    			if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
    			// 2. 벽 체크
    			if(maze[nr][nc] == 1) continue;    			
    			// 3. 방문 체크
    			if(dist[nr][nc] != -1) continue;
    			
    			dist[nr][nc] = dist[r][c] + 1;
    			q.add(new int[] {nr, nc});
    		}
    	}
    	
    	
    }


  

}
