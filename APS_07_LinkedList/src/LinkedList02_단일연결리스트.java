import java.util.NoSuchElementException;

/**
 * 단일 연결 리스트(Singly Linked List)를 직접 구현하는 예제이다.
 *
 * 각 노드는 다음 노드 하나만 가리키므로 head에서 tail 방향으로만 이동할 수 있다.
 * head는 첫 노드를, tail은 마지막 노드를 가리킨다.
 * tail을 함께 관리하면 맨 뒤 삽입을 O(1)에 수행할 수 있다.
 *
 * 핵심 주의 사항
 * - 중간 삽입은 새 노드의 뒤쪽 링크를 먼저 연결하고 앞쪽 링크를 나중에 연결한다.
 * - 첫 노드나 마지막 노드가 바뀌면 head와 tail을 함께 갱신한다.
 * - 삽입·삭제가 끝날 때마다 size도 반드시 갱신한다.
 */
public class LinkedList02_단일연결리스트 {
	static class Node {
		int data;
		Node link;

		Node(int data) {
			this.data = data;
		}
	}

	static class SinglyLinkedList {
		private Node head;
		private Node tail;
		private int size;

		/** 맨 앞 삽입: 별도의 탐색이 없으므로 O(1) */
		void addFirst(int item) {
			Node node = new Node(item); // 노드를 생성했다
			
			// 새로운 노드의 링크는 head로 대체하고 head에 위치를 바꾼다
			node.link = head;
			head = node;
			
			if(size == 0) {
				tail = node;
			}
			size++;
		}

		/** tail을 사용한 맨 뒤 삽입: O(1) */
		void addLast(int item) {
			// 1. 공백리스트
			if(isEmpty()) {
				addFirst(item);
				return;
			}
			// 2. 리스트가 존재하는 경우
			Node node = new Node(item);
			tail.link = node; // 기존 마지막 노드의 링크를 새롭게 생성한 노드와 연결한다
			tail = node;	// 마지막 노드의 위치를 갱신한다
		}

		/**
		 * index 위치에 새 값을 삽입한다.
		 * 위치를 찾는 탐색 때문에 일반적으로 O(N)이다.
		 */
		void add(int index, int item) {
			// index의 값이 유의미한가를 체크, 예외를 발생시키던지 or 각각 포함시키던디
			
			
			// 인덱스가 0이면 addFirst
			if(index == 0) {
				addFirst(item);
				return;
			}
			
			// 인덱스 size 	addLast
			if(index >= size) {
				addLast(item);
				return;
			}
			
			// 선행 노드를 찾아서 변경해야한다
			
			Node preNode = get(index - 1);
			Node node = new Node(item);
			
			node.link = preNode.link;
			preNode.link = node;
			size++;		
		}
		

		/** index번째 값 조회: head부터 index번 이동하므로 O(N) */
		Node get(int index) {
			Node curr = head;
			for(int i = 0; i < index; i++) {
				curr = curr.link;
			}
			return curr;
		}

		/** 맨 앞 삭제: head만 한 칸 옮기므로 O(1) */
		int removeFirst() {
			if(isEmpty()) {
				// 공백상태일 때 지우기 불가능
				throw new NoSuchElementException("리스트가 공백임");
			}
			
			Node target = head;
			head = head.link;
			target.link = null;
			size--;
			
			// head == null 이거나 아래와 같다면.. 원소가 하나도 없는 것
			if(size == 0) {
				tail = null;
			}
			
			return target.data;
		}

		/** index번째 노드 삭제: 선행 노드를 찾는 데 O(N) */
		int remove(int index) {
			// 이상한 범위가 들오는지 체크
			if(index == 0) {
				return removeFirst();
			}
			
			Node preNode = get(index - 1);
//			Node target = get(index);
			Node target = preNode.link;
			preNode.link = target.link;
			
			if(target == tail) {
				tail = preNode; // 타겟이 마지막 노드였다면 tail을 움직인다
			}
			size--;
			target.link = null;		
			return target.data;
		}

//		int size() { 없어도 무방
//			return size;
//		}

		boolean isEmpty() {
			return size == 0;
		}

	}

	public static void main(String[] args) {
		SinglyLinkedList list = new SinglyLinkedList();
	}
}
