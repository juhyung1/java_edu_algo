import java.util.Scanner;
import java.util.Stack;

/**
 * 무향 그래프를 깊이 우선 탐색(DFS)하는 두 가지 방법을 비교한다.
 *
 * <p>DFS는 한 방향으로 갈 수 있는 데까지 들어간 뒤 막히면 이전 갈림길로
 * 되돌아온다. 재귀 함수는 JVM의 시스템 스택을 사용하고, 반복문 방식은
 * 직접 만든 LIFO 스택을 사용한다.</p>
 *
 * <p>사이클이 있는 그래프에서는 visited가 없으면 같은 정점을 계속 오가며
 * 탐색이 끝나지 않는다. 인접 리스트를 사용하면 시간 복잡도는 O(V + E),
 * 방문 배열과 스택을 포함한 추가 공간은 O(V)이다.</p>
 */


public class 그래프탐색_DFS_01_그래프 {
	static int V, E;
	static int[][] adjArr;		// 인접행렬
	static boolean[] visited;	// 방문 배열

    public static void main(String[] args) {
    	Scanner sc = new Scanner(input);
    	V = sc.nextInt();
    	E = sc.nextInt();
    	
    	adjArr = new int[V + 1][V + 1]; // 정점의 번호가 1번부터 시작이기 때문
    	visited = new boolean[V + 1];
    	
    	for(int i = 0; i < E; i++) {
    		int from = sc.nextInt();
    		int to = sc.nextInt();
    		
    		adjArr[from][to] = adjArr[to][from] = 1;	// 무향이기때문
    	}
//    	dfs(1);
    	dfsStack(1);
    }
    static void dfs(int v) {
    	visited[v] = true;	// 방문했다
    	System.out.println(v);	// 작업 수행
    	
    	for(int i = 1; i < V+1; i++) {
    		// 인접하면서 방문하지 않았으면
    		if(adjArr[v][i] == 1 && !visited[i]) {
    			dfs(i);
    		}
    	}
    	
    }
    
    static void dfsStack(int v) {
    	Stack<Integer> stack = new Stack<>();
    	
    	stack.push(v);	// 시작 정점 넣기
    	visited[v] = true;
    	
    	while(!stack.isEmpty()) {
    		int curr = stack.pop();
    		System.out.println(curr);
    		
    		for(int i = 1; i <= V; i++) {
    			if(adjArr[curr][i] == 1 && !visited[i]) {
    				stack.push(i);
    				visited[i] = true;
    			}
    		}
    	}
    }
    
    static String input = "7 9\r\n"
    		+ "1 2\r\n"
    		+ "1 3\r\n"
    		+ "1 6\r\n"
    		+ "2 4\r\n"
    		+ "2 7\r\n"
    		+ "3 4\r\n"
    		+ "4 7\r\n"
    		+ "5 6\r\n"
    		+ "5 7";
}
