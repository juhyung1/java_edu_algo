import java.util.EmptyStackException;

/**
 * 단일 연결 리스트로 스택(LIFO)을 구현하는 예제이다.
 *
 * 리스트의 맨 앞을 스택의 top으로 사용한다.
 * - push: 맨 앞 삽입과 같으므로 O(1)
 * - pop: 맨 앞 삭제와 같으므로 O(1)
 * - peek: top의 값만 확인하므로 O(1)
 *
 * 배열 스택과 달리 최대 크기를 미리 정할 필요가 없다.
 */
public class LinkedList03_연결스택 {
	static class Node {
		int data;
		Node link;

		Node(int data, Node link) {
			this.data = data;
			this.link = link;
		}
	}

	static class LinkedStack {
		private Node top;
		private int size;

		void push(int item) {
			// 새 노드 아래에 기존 top을 매단 뒤 새 노드를 top으로 만든다.
			top = new Node(item, top);
			size++;
		}

		int pop() {
			if (isEmpty()) {
				throw new EmptyStackException();
			}

			Node target = top;
			top = top.link;
			target.link = null;
			size--;
			return target.data;
		}

		int peek() {
			if (isEmpty()) {
				throw new EmptyStackException();
			}
			return top.data;
		}

		boolean isEmpty() {
			return top == null;
		}

		int size() {
			return size;
		}
	}

	public static void main(String[] args) {
		LinkedStack stack = new LinkedStack();
		stack.push(10);
		stack.push(20);
		stack.push(30);

		System.out.println("peek: " + stack.peek());
		while (!stack.isEmpty()) {
			System.out.println("pop: " + stack.pop());
		}
	}
}
