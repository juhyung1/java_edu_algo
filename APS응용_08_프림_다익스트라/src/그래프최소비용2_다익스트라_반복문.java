import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 그래프최소비용2_다익스트라_반복문 {
	static class Edge {
		int v, cost;

		public Edge(int v, int cost) {
			this.v = v;
			this.cost = cost;
		}
	}
	
	static int V, E;	// 정점의 수, 간선의 수
	static List<Edge>[] adjList;	// 인접 리스트
	static int[] dist;	// 거리 저장
	static boolean[] visited;	// 방문했는지 안했는지 체크
	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(input);
		
		V = sc.nextInt();
		E = sc.nextInt();
		
		adjList = new ArrayList[V];	// 시작 정점이 0번부터
		for(int i = 0; i < V; i++) {
			adjList[i] = new ArrayList<>();
		}	// 인접리스트 초기화
		
		dist = new int[V];
		Arrays.fill(dist,  INF);
		visited = new boolean[V];
		
		for(int i = 0; i < E; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			int cost = sc.nextInt();
			
			// 유향
			adjList[from].add(new Edge(to, cost));
		}
		dijkstra(0);
		System.out.println(Arrays.toString(dist));
		
		// 다익스트라는 시작정점이 중요함
	}	// main
	
	public static void dijkstra(int start) {
		dist[start] = 0;	// 시작 정점의 거리값을 0으로
		for(int i = 0; i < V; i++) {
			// 1. 방문하지 않았으면서 dist가 가장 작은 값
			int min = INF;
			int idx = -1;
			for(int j = 0; j < V; j++) {
				if(!visited[j] && dist[j] < min) {
					min = dist[j];
					idx = j;
				}
			}	// 방문하지 않았으면가 가장 작은 값의 인덱스
			
			visited[idx] = true;
			
			// 2. 갱신 A -> B 경로 중 중간에 X가 있다
			// 시작 정점 -> X : dist[idx] + X -> 도착정점(e.cose)
			for(Edge e : adjList[idx]) {
				// 방문 X, 갱신할 여지가 있다.
				if(!visited[e.v] && dist[e.v] > dist[idx]+e.cost) {
					dist[e.v]= dist[idx] + e.cost; 
				}
			}
			
		} // 다익스트라 for문
	}
	
	
	
	static String input = "6 11\r\n"
			+ "0 1 4\r\n"
			+ "0 2 2\r\n"
			+ "0 5 25\r\n"
			+ "1 3 8\r\n"
			+ "1 4 7\r\n"
			+ "2 1 1\r\n"
			+ "2 4 4\r\n"
			+ "3 0 3\r\n"
			+ "3 5 6\r\n"
			+ "4 3 5\r\n"
			+ "4 5 12\r\n"
			+ "";
}
