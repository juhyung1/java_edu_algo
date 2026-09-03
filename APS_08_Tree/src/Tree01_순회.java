/**
 * [이진 트리의 재귀 순회]
 *
 * 세 순회 모두 왼쪽 서브트리(L)를 오른쪽 서브트리(R)보다 먼저 방문한다.
 * 차이는 현재 노드(V)를 어느 시점에 처리하느냐뿐이다.
 *
 * - 전위 순회: V L R  (현재 노드를 먼저 처리)
 * - 중위 순회: L V R  (왼쪽과 오른쪽 사이에서 처리)
 * - 후위 순회: L R V  (두 자식을 처리한 뒤 현재 노드를 처리)
 *
 * 모든 노드를 정확히 한 번 방문하므로 시간 복잡도는 O(N)이다.
 * 재귀 호출 스택은 트리 높이 H만큼 사용하므로 공간 복잡도는 O(H)이다.
 */
public class Tree01_순회 {
	// 1차원 배열을 이용한 입력
	// 문자배열의 기본값 \u0000
	static char[] tree = { '\u0000', 'A', 'B', 'C', 'D', 'E', 'F', 'G', '\u0000', '\u0000', 'H', 'I' };
	static int N = tree.length;

	public static void main(String[] args) {
		System.out.println("전위 순회");
		preOrder(1);
		System.out.println();
		System.out.println("중위 순회");
		inOrder(1);
		System.out.println();
		System.out.println("후위 순회");
		postOrder(1);
		
	}	// main
	
	
	
	// 전위순회(VLR)
	// v : 노드의 번호
	public static void preOrder(int v) {
		if(v >= N || tree[v] == '\u0000') {
			return;
		}
		System.out.print(tree[v]);
		preOrder(v * 2);	// 왼쪽 서브트리 탐색
		preOrder(v * 2 + 1); // 오른쪽 서브트리 탐색
		
	}
	
	// 중위순회(LVR)
	// v : 노드의 번호
	public static void inOrder(int v) {
		if (v >= N || tree[v] == '\u0000') {
			return;
		}
		inOrder(v * 2); // 왼쪽 서브트리 탐색
		System.out.print(tree[v]);
		inOrder(v * 2 + 1); // 오른쪽 서브트리 탐색

	}

	// 후위순회(LRV)
	// v : 노드의 번호
	public static void postOrder(int v) {
		if (v >= N || tree[v] == '\u0000') {
			return;
		}
		postOrder(v * 2); // 왼쪽 서브트리 탐색
		postOrder(v * 2 + 1); // 오른쪽 서브트리 탐색
		System.out.print(tree[v]);

	}
	
	
	
	
	
	
	
	
	
	
	
}
