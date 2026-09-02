/**
 * 연결 리스트를 배우기 전에 자바의 참조(reference)와 노드(Node)를 확인하는 예제이다.
 *
 * 자바의 참조형 변수에는 객체 자체가 아니라 힙에 만들어진 객체의 위치가 저장된다.
 * 따라서 Node b = a;는 노드를 복사하는 코드가 아니다.
 * a와 b가 같은 노드를 함께 가리키게 만드는 코드이다.
 *
 * 노드는 연결 리스트의 한 칸이며 두 필드를 가진다.
 * - data: 실제로 보관할 값
 * - link: 다음 노드를 가리키는 참조
 */
public class LinkedList01_참조와노드 {
	static class Node {
		int data;
		Node link;
		
		// 기본생성자
		public Node() {			
		}
		// 생성자 오버로딩
		public Node(int data) {
			this.data = data;
//			this.link = null; 참조형 필드는 기본값이 null이기 때문에 따로 선언 안해도됨
		}
		
	}

	public static void main(String[] args) {
		Node a = new Node();
		a.data = 100;
		
		Node b = a;
		
		b.data = 1000;
		
		System.out.println(a.data);	// 1000
		
		Node first = new Node(10);
		Node second = new Node(20);
		first.link = second;
		
		System.out.println(first.link.data); // first의 링크를 따라갔더니 20 (40번째줄과 연결)
	}
}
