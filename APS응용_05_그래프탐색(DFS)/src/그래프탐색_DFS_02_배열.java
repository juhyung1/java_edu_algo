/**
 * 2차원 미로를 재귀 DFS로 탐색하여 입구에서 출구까지 한 경로를 찾는다.
 * 0은 통로, 1은 벽이며 탐색 방향은 PDF와 같은 상, 우, 하, 좌 순서이다.

 * <p>DFS는 경로의 존재 여부와 실제 경로 하나를 찾을 수 있지만, 처음 발견한 경로가
 * 최단 경로라는 보장은 없다. 최단 이동 횟수가 필요하면 가중치가 없는 미로에서는
 * BFS를 사용한다. 각 칸을 최대 한 번 방문하므로 시간과 공간은 O(행 * 열)이다.</p>
 */
public class 그래프탐색_DFS_02_배열 {
	// 상하좌우 
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static int N;	// 2차원 정사각 미로의 한 변의 길이(R, C)
	static int[][] maze;
	static boolean[][] visited; // 방문 처리
	static boolean ans;	// 탈출 여부
	public static void main(String[] args) {
		N = 8;
    	maze = new int[][] {
    		{0, 0, 1, 1, 1, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 0, 1, 1, 1, 1},
            {1, 1, 1, 0, 1, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 1, 1, 1, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 0, 0},
            {1, 1, 1, 1, 1, 1, 1, 0}
            };
            
        visited = new boolean[N][N]; // 원본을 벽으로 바꾸면서 진행하겠다
        ans = false;
        
        dfs(0,0);
        System.out.println(ans);
				
	}
	
	static void dfs(int r, int c) {
		if(r == N-1 && c == N-1) {
			ans = true;
			return;
		}
		visited[r][c] = true; // 해당위치 방문했다
		
		// 4방향 탐색
		for(int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			// 다음 좌표가 유의미한가
			if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
			if(maze[nr][nc] == 1 || visited[nr][nc]) continue;
			
			dfs(nr, nc);
		}
	}
	
	
	
}
