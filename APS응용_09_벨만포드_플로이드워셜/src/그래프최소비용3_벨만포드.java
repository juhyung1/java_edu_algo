
//간선 배열

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 그래프최소비용3_벨만포드 {
	//클래스 정의
	static class Edge {
		int from, to, cost;

		public Edge(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
	}
	static int[] dist; //거리를 저장
	static int V, E;   //정점의 수,간선의
	static List<Edge> edges;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(input2);
		
		V = sc.nextInt();  //시작정점은 0번 이다.
		E = sc.nextInt();
		dist = new int[V];
		edges = new ArrayList<>();
		
		for(int i = 0; i <E ;i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			int cost = sc.nextInt();
			
			//유향
			edges.add(new Edge(from, to, cost));
		}//간선배열 입력 완료
		
		bellmanFord(0);
	}//main
	
	static final int INF = Integer.MAX_VALUE;
	//시작정점을 알려주어야 한다.
	private static void bellmanFord(int st) {
		//dist배열을 무한대값으로 초기화
		Arrays.fill(dist, INF);
		dist[st] = 0; //시작정점을 0으로 세팅
		
		//모든 간선을 (V-1)번 반복 -> 완화(Relaxation)을 진행하겠다.
		for(int i = 0 ; i<V-1; i++) {
			//사이클을 시작하는 곳
			boolean isChange = false;
			for(Edge e: edges) {
				if(dist[e.from] != INF && dist[e.to] > dist[e.from]+ e.cost) {
					dist[e.to]= dist[e.from]+ e.cost; 
					//갱신이 일어났따. -> 변화가 있었다!
					isChange = true;
				}
			}//완화작업 수행 for문
			if(!isChange) {
				//한 사이클이 완료가 되었는데, 해당 boolean값이 여전히 false라면
				//더 이상의 진행은 무의미하다.
				break;
			}
		}//사이클 횟수
		
		//V-1번 완화작업을 수행했다.
		boolean negativeCycle = false;
		for(Edge e : edges) {
			if(dist[e.from]!= INF && dist[e.to]> dist[e.from]+e.cost) {
				//요기안에 들어온다. (값이 작아지네?)
				//음수사이클이 존재한다.
				negativeCycle = true;
				break;
			}
		}
		
		if(negativeCycle) {
			System.out.println("음의 사이클이 발생했다.");
		}else {
			System.out.println(Arrays.toString(dist));
		}
		
		
		
		
		
		
		
		
		
	}



	// 음의 사이클 X
	static String input1 = "6 7\r\n" + "0 1 4\r\n" + "0 2 5\r\n" + "1 3 -2\r\n" + "2 4 8\r\n" + "3 5 7\r\n"
			+ "4 2 -3\r\n" + "4 5 6\r\n" + "";

	// 음의 사이클 O
	static String input2 = "4 4\r\n" + "0 1 5\r\n" + "1 2 -8\r\n" + "2 1 3\r\n" + "2 3 6";
}
