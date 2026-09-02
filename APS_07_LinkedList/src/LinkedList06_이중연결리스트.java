
/**
 * 이전(prev)과 다음(next)을 모두 저장하는 이중 연결 리스트 예제이다.
 *
 * 양방향 이동이 가능하므로 index가 앞쪽이면 head에서, 뒤쪽이면 tail에서 탐색한다.
 * 삭제할 노드를 이미 알고 있다면 선행 노드를 다시 찾지 않고 O(1)에 삭제할 수 있다.
 * 대신 삽입·삭제 시 양쪽 링크와 head·tail을 모두 정확히 갱신해야 한다.
 */
public class LinkedList06_이중연결리스트 {
	static class DNode {
		int data;
		DNode prev;
		DNode next;

		DNode(int data) {
			this.data = data;
		}
	}

	static class DoublyLinkedList {
		private DNode head;
		private DNode tail;		
		private int size;
		
		void addFirst(int item) {
			
		}
		
		void addLast(int item) {
			
		}
		
		void add(int index, int iteM) {
			
		}
		
		int remove(int index0) {
			return 0;
		}
		
		DNode get(int index) {
			
		}

	}
	public static void main(String[] args) {
	}
}
