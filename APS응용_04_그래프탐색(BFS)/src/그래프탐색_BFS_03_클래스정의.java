import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * 큐에 좌표와 거리를 함께 저장해 미로의 최단 길이를 구한다.
 *
 * <p>Pos 객체 하나가 행, 열, 시작점부터의 거리를 함께 가진다. 흐름이 직관적이고
 * 별도의 거리 배열이 필요 없지만, 같은 칸을 다시 넣지 않기 위한 visited 배열은
 * 사용해야 한다. 방문 표시는 반드시 큐에 넣는 순간 수행한다.</p>
 */
public class 그래프탐색_BFS_03_클래스정의 {
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static class Pos{
		int r, c, dist;

		public Pos(int r, int c, int dist) {
			this.r = r;
			this.c = c;
			this.dist = dist;
		}		
	}
	
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
        boolean[][] visited = new boolean[N][N];
           
        Queue<Pos> q = new ArrayDeque<>();
        
    	q.add(new Pos(0, 0, 0));
    	visited[0][0] = true;
    	
    	while(!q.isEmpty()) {
    		Pos curr = q.poll();
    		
    		if(curr.r == N-1 && curr.c == N-1) {
    			System.out.println(curr.dist);
    			break;
    		}
    		
    		for(int i = 0; i < 4; i++) {
    			int nr = curr.r + dr[i];
    			int nc = curr.c + dc[i];
    			
    			// 1. 범위 체크(항상 먼저 수행할 것)
    			if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
    			// 2. 벽 체크
    			if(maze[nr][nc] == 1) continue;    			
    			// 3. 방문 체크
    			if(visited[nr][nc]) continue;
    			
    			visited[nr][nc] = true;
    			q.add(new Pos(nr, nc, curr.dist+1));
    		}
    	}
    }

}
