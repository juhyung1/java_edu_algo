import java.util.Arrays;
import java.util.Scanner;

public class 그래프최소비용3_플로이드워셜 {
	static final int INF = Integer.MAX_VALUE; // 상수 987654321

	public static void main(String[] args) {
		Scanner sc = new Scanner(input2);
		
		int V = sc.nextInt(); //정점의 수
		int E = sc.nextInt(); //간선의 수
		int[][] dist = new int[V][V]; //시작정점이 0번부터 시작(0으로)
		//초기화 나자신의 비용 0으로 나머지는 전부 INF로 초기화 시킬거에요
		for(int i = 0 ; i<V; i++) {
			for(int j = 0 ; j<V; j++) {
				if( i != j)
					dist[i][j] = INF;
			}
		}//dist 초기화
		
		//가중치를 입력받아서 처리 (유향)
		for(int i = 0 ; i<E; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			int cost = sc.nextInt();
			dist[from][to] = cost;
		}//입력완료
		
		//플로이드워셜 -> 경찰과도둑
		for(int k = 0; k < V; k++) {
			for(int st = 0; st < V; st++) {
				//출발지로부터 경유지까지 갈 수 없다면.... No 의미
				if(dist[st][k] == INF) continue;
				for(int ed = 0; ed<V; ed++) {
					//경유지로부터 도착지까지 갈 수 없다면.... No 의미
					if(dist[k][ed] == INF) continue;
					//갱신한다 -> 
					dist[st][ed] = Math.min(dist[st][ed], dist[st][k]+dist[k][ed]);
				}//도착지
			}//출발지
		}//경유지
		
		//dist 갱신완료
		
		//음수사이클 검사
		boolean negativeCycle = false;
		for(int i = 0 ; i<V; i++) {
			if(dist[i][i] < 0) {
				negativeCycle = true;
				break;
			}
		}
		
		if(negativeCycle) {
			System.out.println("음수 사이클이 존재합니다.!");
		}else {
			for(int[] tmp : dist) {
				System.out.println(Arrays.toString(tmp));
			}
			
//			System.out.println(Arrays.deepToString(dist));
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

	// 음의 사이클X
	static String input1 = "5 9\r\n" + "0 1 3\r\n" + "0 2 8\r\n" + "0 4 -4\r\n" + "1 3 1\r\n" + "1 4 7\r\n"
			+ "2 1 4\r\n" + "3 0 2\r\n" + "3 2 -5\r\n" + "4 3 6\r\n" + "";

	// 음의 사이클O
	static String input2 = "4 5\r\n" + "0 1 1\r\n" + "0 3 4\r\n" + "1 2 1\r\n" + "2 0 -3\r\n" + "3 2 2\r\n" + " \r\n";
}
