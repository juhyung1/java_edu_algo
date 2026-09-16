import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 그래프최소비용2_프림2_우선순위뷰 {
	static String input = "7 11\r\n" + "0 1 32\r\n" + "0 2 31\r\n" + "0 5 60\r\n" + "0 6 51\r\n" + "1 2 21\r\n"
			+ "2 4 46\r\n" + "2 6 25\r\n" + "3 4 34\r\n" + "3 5 18\r\n" + "4 5 40\r\n" + "4 6 51\r\n" + " ";
	
	static class Edge implements Comparable<Edge> {
		int v, cost;

		public Edge(int v, int cost) {
			this.v = v;
			this.cost = cost;
		}
		

		@Override
		public int compareTo(Edge o) {
			return this.cost - o.cost;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(input);

		int V = sc.nextInt(); // 정점의 개수 (시작 정점 중요, 0부터 시작)
		int E = sc.nextInt(); // 간선의 개수

		// 인접행렬, 인접리스트
		List<Edge>[] adjList = new ArrayList[V];
		
		for(int i = 0; i < V; i++) {
			adjList[i] = new ArrayList<>();
		}	// 인접리스트 널포인트 에러 방지용 초기화

		for (int i = 0; i < E; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			int cost = sc.nextInt();

			// 무향 그래프
			adjList[from].add(new Edge(to, cost));
			adjList[to].add(new Edge(from, cost));

		}
		// 필요정보를 초기화
		boolean[] visited = new boolean[V]; // 트리에 속하는지 안하는지 체크
		int ans = 0;
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		int pick = 0;
		pq.add(new Edge(0,0));
		
		while(pick < V) {
			Edge e = pq.poll();
			if(visited[e.v]) continue;
			
			visited[e.v]= true;
			pick++;
			ans += e.cost;
			
			// e.v와 인접한 간선을 전부 다 PQ에 넣는다.
			// 인접리스트
			pq.addAll(adjList[e.v]);
		}
		System.out.println(ans);

	}

}
