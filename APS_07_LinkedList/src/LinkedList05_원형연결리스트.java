
/**
 * 마지막 노드가 null 대신 첫 노드를 가리키는 원형 연결 리스트 예제이다.
 *
 * tail 하나만 관리하면 첫 노드는 tail.link로 얻을 수 있다.
 * 마지막과 처음이 이어져 있으므로 어느 노드에서 시작해도 전체를 순환할 수 있다.
 * 라운드 로빈, 반복 재생, 회전 대기열 등에 활용된다.
 *
 * 주의: null을 만날 수 없으므로 시작 노드로 돌아왔는지 확인하지 않으면 무한 루프가 된다.
 */
public class LinkedList05_원형연결리스트 {
	static class Node {
		int data;
		Node link;

		Node(int data) {
			this.data = data;
		}
	}

	static class CircularLinkedList {

	}

	public static void main(String[] args) {
	}
}
