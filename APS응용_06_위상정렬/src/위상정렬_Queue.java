import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class 위상정렬_Queue {
	public static String[] cook = { "", "재료구매", "양념장만들기", "고기재우기", "고기손질", "제육볶음만들기", "식사", "뒷정리", "채소손질", "밥하기" };

	public static void main(String[] args) {
		Scanner sc = new Scanner(input);

		int V = sc.nextInt(); // 정점의 개수
		int E = sc.nextInt(); // 간선의 개수

		// 인접 행렬
		int[][] adj = new int[V + 1][V + 1]; // 1부터 시작하기 때문
		int[] inDegree = new int[V + 1]; // 진입차수 저장(사전 작업의 수) 1번부터

		for (int i = 0; i < E; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();

			adj[from][to] = 1; // 유향이므로 반대의 경우는 넣지 않는다
			inDegree[to]++; // 진입 이니까 to의 값을 하나 늘린다
		}

		// Q를 이용한 구현
		Queue<Integer> q = new ArrayDeque<>();
		// 1. 시작 정점(진입 차수 0인)을 모두 큐에 넣는다
		for (int i = 1; i < V + 1; i++) {
			if (inDegree[i] == 0) {
				q.add(i);
			} // 재료 구매, 양념장 만들기, 밥하기

			// 2. 큐가 공백상태일때까지 반복
		}
		while (!q.isEmpty()) {
			int curr = q.poll(); // 작업 하나 꺼sorl

			// 꺼낸 노드로 작업을 수행한다
			System.out.println(cook[curr]); // 우리는 심플하게 작업을 출력해보자

			// curr와 인접한 정점을 순회하면서 간선을 제거한다
			for (int i = 1; i < V + 1; i++) {
				// 유향이라서 작성 순서 중요함
				if(adj[curr][i] == 1) {
					adj[curr][i] = 0; // 간선을 제거한다(필요시 수행)
					inDegree[i]--;
					if(inDegree[i] == 0) {
						q.add(i);
					}
				}
			}
			
			

		}

	}

	public static String input = "9 9\r\n" + "1 4\r\n" + "1 8\r\n" + "2 3\r\n" + "4 3\r\n" + "8 5\r\n" + "3 5\r\n"
			+ "5 6\r\n" + "9 6\r\n" + "6 7";

}
