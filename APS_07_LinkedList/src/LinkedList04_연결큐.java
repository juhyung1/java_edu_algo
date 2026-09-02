import java.util.NoSuchElementException;

/**
 * 단일 연결 리스트로 큐(FIFO)를 구현하는 예제이다.
 *
 * front는 첫 노드를, rear는 마지막 노드를 가리킨다.
 * - enQueue: rear 뒤에 새 노드를 붙이므로 O(1)
 * - deQueue: front 노드를 꺼내므로 O(1)
 *
 * 마지막 원소를 꺼낸 뒤에는 front뿐 아니라 rear도 null로 바꿔야 한다.
 * 이 처리를 빠뜨리면 rear가 이미 제거된 노드를 계속 가리키게 된다.
 */
public class LinkedList04_연결큐 {
	static class Node {
		int data;
		Node link;

		Node(int data) {
			this.data = data;
		}
	}

	static class LinkedQueue {
		private Node front;
		private Node rear;
		private int size;

		void enQueue(int item) {
			Node node = new Node(item);

			if (isEmpty()) {
				// 첫 원소라면 앞과 뒤가 같은 노드를 가리킨다.
				front = node;
			} else {
				// 기존 마지막 노드 뒤에 새 노드를 붙인다.
				rear.link = node;
			}
			rear = node;
			size++;
		}

		int deQueue() {
			if (isEmpty()) {
				throw new NoSuchElementException("큐가 비어 있습니다.");
			}

			Node target = front;
			front = front.link;
			target.link = null;
			size--;

			if (front == null) {
				// 마지막 원소를 꺼낸 경우 rear도 반드시 정리한다.
				rear = null;
			}
			return target.data;
		}

		int peek() {
			if (isEmpty()) {
				throw new NoSuchElementException("큐가 비어 있습니다.");
			}
			return front.data;
		}

		boolean isEmpty() {
			return front == null;
		}

		int size() {
			return size;
		}
	}

	public static void main(String[] args) {
		LinkedQueue queue = new LinkedQueue();
		queue.enQueue(10);
		queue.enQueue(20);
		queue.enQueue(30);

		System.out.println("peek: " + queue.peek());
		while (!queue.isEmpty()) {
			System.out.println("deQueue: " + queue.deQueue());
		}

		// 완전히 비운 뒤 다시 넣어도 front와 rear가 정상적으로 설정된다.
		queue.enQueue(100);
		System.out.println("다시 삽입 후 peek: " + queue.peek());
	}
}
