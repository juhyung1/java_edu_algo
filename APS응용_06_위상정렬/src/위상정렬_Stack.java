import java.util.*;

public class 위상정렬_Stack {
	public static String[] cook = { "", "재료구매", "양념장만들기", "고기재우기", "고기손질", "제육볶음만들기", "식사", "뒷정리", "채소손질", "밥하기" };
	
	public static boolean[] visited;	// 방문 체크
	public static Stack<Integer> ans;	// 작업 순서를 담을 스택
	public static List<Integer>[] adjList;	// 인접리스트
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(input);

		int V = sc.nextInt(); // 정점의 개수
		int E = sc.nextInt(); // 간선의 개수
		
		visited = new boolean[V+1];	// 시작번호 1부터
		int[] inDegree = new int[V+1];	// 시작 위치를 결정하려고
		ans = new Stack<>();
		adjList = new ArrayList[V+1];
		for(int i = 1; i < V+1; i++) {
			adjList[i] = new ArrayList<>();
//			adjList2.add(new ArrayList<>());
		}
		
		for(int i = 0; i < E; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			
			inDegree[to]++;
			adjList[from].add(to);
//			adjList2.get(from).add(to);
		}
		
		for(int i =1 ; i < V+1; i++) {
			if(inDegree[i] == 0) {
				dfs(i);
			}
		}	// 작업 수행 완료
		
		// 작업 순서 출력
		while(!ans.isEmpty()) {
			System.out.println(cook[ans.pop()]);
		}

	}

	public static void dfs(int curr) {
		visited[curr] = true;	// 방문처리 -> 작업을 수행한 것은 아님!!
		
		// 인접행렬일때는 모든 정점을 반복문을 돌리면서 인접한지 조건을 걸어음
		// 인접리스트는 편하다
		for(int to : adjList[curr]) {
			// 인접한 친구들만 반복문이 돌게 되어있어서 조건문이 생략
			if(!visited[to]) {
				dfs(to);
			}			
		}
		
		// curr로 할 수 있는 작업을 전부 다 했다면
		ans.push(curr);
		
	}

	public static String input = "9 9\r\n" + "1 4\r\n" + "1 8\r\n" + "2 3\r\n" + "4 3\r\n" + "8 5\r\n" + "3 5\r\n"
			+ "5 6\r\n" + "9 6\r\n" + "6 7";

}
