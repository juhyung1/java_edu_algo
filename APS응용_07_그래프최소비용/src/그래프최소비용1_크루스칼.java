import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 그래프최소비용1_크루스칼 {
	static int V, E; // 정점의 수, 간선의 수
	static int[] p;	// 대표를 저장할 배열
	
	// 간선 배열
	static class Edge implements Comparable<Edge> {
		int from, to, cost; // 출발지, 도착지, 비용

		public Edge(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
		
		// 가중치(비용) 기준으로 오름차순
		@Override
		public int compareTo(그래프최소비용1_크루스칼.Edge o) {
			return this.cost - o.cost;
		}
	}
	
	
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(input);
		
		V = sc.nextInt();
		E = sc.nextInt();
		Edge[] edges = new Edge[E];
		
		int[][] edges2 = new int[E][3]; // [0] 출발, [1] 도착, [2]비용
		
		for(int i = 0; i < E; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			int cost = sc.nextInt();
			
			// 간선의 정보들을 저장
			edges[i] = new Edge(from, to, cost);
//			edges2[i] = new int[] {sc.nextInt(), sc.nextInt(), sc.nextInt()};
		}
		
		// 1. 가중치 기준으로 정렬
		Arrays.sort(edges);	// 클래스에 Comparable 구현해두어서 별 문제 없음
//		Arrays.sort(edges2, new Comparator<int[]>() {
//
//			@Override
//			public int compare(int[] o1, int[] o2) {
//				return o1[2] - o2[2];
//			}
//		});
		
		// 2. 각 대표 집합을 만들자
		p = new int[V]; // V 괜찮나?(시작 정점을 확인)
		for(int i = 0; i < V; i++) {
//			makeSet(i);
			p[i] = i;
		}
		
		// 3. 간선을 뽑겠다(V-1)개
		int ans = 0;
//		int pick = 0;
		// while, for
//		while(pick < V-1)
		for(int i = 0, pick = 0; i < E && pick < V-1; i++) {
//			int from = edges[i].from;
//			int to = edges[i].to;
//			
//			if(findSet(from) != findSet(to)) {
//				union(from,to);
//				pick++;
//				ans += edges[i].cost;
//			}
			
			int px = findSet(edges[i].from);
			int py = findSet(edges[i].to);
			if(px != py) {
//				union(px, py);
				p[py] = px;
				pick++;
				ans += edges[i].cost;
			}
			
		}	// 크루스칼 완성
		
		for(int i = 0; i < V; i++) {
			findSet(i);
		} // 막판 갱신(필요시)
		
		// 4. V-1개의 간선이 뽑혔다면 종료(정답 출력)
		System.out.println(ans);
		System.out.println(Arrays.toString(p));
		
		
		
		
		
		
	}
	
	private static void union(int x, int y) {
		// rank를 고려하지는 않았다.
		// x, y가 대표라는 보장이 없다
		p[findSet(y)] = findSet(x);
		// x, y가 대표라는 보장이 있다.
//		p[y] = x;
		
	}

	// 나의 대표를 반환하면 된다.
	private static int findSet(int x) {
//		if(x == p[x]) return x;
//		else return findSet(p[x]);
//		
//		if(x != p[x]) 
//			return findSet(p[x]);
//		return x;
		
		
		// 경로 압축
		if (x != p[x])
			p[x] = findSet(p[x]);
		return p[x];
	}
	
	
	
	
	
	
	
	
	
	
	
	

	private static void makeSet(int i) {
		p[i] = i;
//		rank[i] = 0;
	}

	static String input = "7 11\r\n"
			+ "0 1 32\r\n"
			+ "0 2 31\r\n"
			+ "0 5 60\r\n"
			+ "0 6 51\r\n"
			+ "1 2 21\r\n"
			+ "2 4 46\r\n"
			+ "2 6 25\r\n"
			+ "3 4 34\r\n"
			+ "3 5 18\r\n"
			+ "4 5 40\r\n"
			+ "4 6 51\r\n"
			+ " ";

}
