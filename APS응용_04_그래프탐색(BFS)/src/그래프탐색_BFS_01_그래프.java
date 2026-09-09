import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/**
 * 인접 리스트와 큐를 이용해 무향 그래프를 너비 우선 탐색(BFS)한다.
 *
 * <p>BFS는 시작 정점에서 가까운 정점부터 방문한다. 먼저 들어온 정점을 먼저
 * 꺼내는 FIFO 큐를 사용하며, 모든 간선 비용이 같을 때 처음 도착한 경로가
 * 최단 경로가 된다.</p>
 *
 * <p>중요: 방문 표시는 큐에서 꺼낼 때가 아니라 큐에 넣는 순간 한다.
 * 그래야 여러 정점이 같은 이웃을 발견해도 그 이웃이 큐에 한 번만 들어간다.
 * 인접 리스트를 사용한 시간 복잡도는 O(V + E), 추가 공간은 O(V)이다.</p>
 */
public class 그래프탐색_BFS_01_그래프 {

    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	
    	int V = sc.nextInt();
    	int E = sc.nextInt();
    	
    	int[][] adjArr = new int[V + 1][V + 1];
    	
    	for(int i = 0; i < E; i++) {
    		int from = sc.nextInt();
    		int to = sc.nextInt();
    		adjArr[from][to] = adjArr[to][from] = 1;
    	}
    	
    	boolean[] visited = new boolean[V+1];
    	
    	// 시작 정점을 넣어두고 BFS 탐색을 진행해보자
    	// FIFO 구조가 필요했고
    	Queue<Integer> q = new ArrayDeque<>();
    	q.add(1);
    	visited[1] = true;
    	
    	while(!q.isEmpty()) {
    		int curr = q.poll();
    		System.out.println(curr);
    		// 인접하면서 방문하지 않은 정점들을 큐에 넣는다
    		for(int i = 1; i < V+1; i++) {
    			if(!visited[i] && adjArr[curr][i] == 1) {
    				q.add(i);
    				visited[i] = true;
    			}
    		}
    	}


        
        

    }

}
