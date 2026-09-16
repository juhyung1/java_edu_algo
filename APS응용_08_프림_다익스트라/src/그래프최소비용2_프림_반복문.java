import java.util.Arrays;
import java.util.Scanner;

public class 그래프최소비용2_프림_반복문 {
	static String input = "7 11\r\n" + "0 1 32\r\n" + "0 2 31\r\n" + "0 5 60\r\n" + "0 6 51\r\n" + "1 2 21\r\n"
			+ "2 4 46\r\n" + "2 6 25\r\n" + "3 4 34\r\n" + "3 5 18\r\n" + "4 5 40\r\n" + "4 6 51\r\n" + " ";

	public static void main(String[] args) {
		Scanner sc = new Scanner(input);

		int V = sc.nextInt(); // 정점의 개수 (시작 정점 중요, 0부터 시작)
		int E = sc.nextInt(); // 간선의 개수

		// 인접행렬, 인접리스트
		int[][] adjArr = new int[V][V];

		for (int i = 0; i < E; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			int cost = sc.nextInt();

			// 무향 그래프
			adjArr[from][to] = adjArr[to][from] = cost;

		}
		// 필요정보를 초기화
		int[] p = new int[V]; // 어디에서 연걸된 간선인지
		int[] dist = new int[V]; // 거리의 정보를 저장
		boolean[] visited = new boolean[V]; // 트리에 속하는지 안하는지 체크

		Arrays.fill(p, -1);
		Arrays.fill(dist, 5000);

		// 시작 정점 고르기(아무거나 골라도 가능)
		dist[0] = 0;

		int ans = 0;

		// 전체 V번 반복을 수행하면서 정점을 고르겠다(V-1번 해도 가능)
		for (int i = 0; i < V; i++) {
			// 1. 정점 중 방문 x, 가중치 가장 작은 정점을 선택
			int idx = -1;
			int min = Integer.MAX_VALUE;
			for(int j = 0; j < V; j++) {
				if(!visited[j] && dist[j] < min) { // 방문 하지 않았으면서 j가 바라보는 친구가 min보다 작다면
					min = dist[j];
					idx = j;
				}
			} // 정점을 뽑았다
			
			// idx가 방문하지 않았으면서 가장 작은 값의 인덱스를 가지고있어서 방문했다고 수정
			visited[idx] = true;
			
			
			// 2. 이번에 뽑은 정점과 간선이 있는(연결되어 있는) && 방문하지 않은 친구 갱신
			for(int j = 0; j < V; j++) {
				if(!visited[j] && adjArr[idx][j] != 0 && dist[j] > adjArr[idx][j]) // 이번에 연결되어 있는 친구가 더 작다면(min에서 dist[j]로 초기화했는데 이 값보다 adfArr[idx][j]가 더 작다면
					dist[j] = adjArr[idx][j];
				p[j] = idx; // 부모 정보 갱신
			}

		}
		System.out.println(Arrays.toString(dist));
		for(int i = 0; i < V; i++) {
			ans += dist[i];
		}

		System.out.println(ans);
	}

}
