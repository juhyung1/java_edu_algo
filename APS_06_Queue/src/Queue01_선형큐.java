import java.util.NoSuchElementException;

/**
 * 고정 길이 배열로 선형 큐(Linear Queue)를 직접 구현하는 예제이다.
 *
 * 큐는 먼저 넣은 원소를 먼저 꺼내는 FIFO(First-In First-Out) 자료구조이다.
 * - rear: 마지막으로 넣은 원소의 인덱스
 * - front: 마지막으로 꺼낸 원소의 인덱스
 * - 초기 상태: front = rear = -1
 *
 * enQueue는 rear를 증가시킨 뒤 값을 저장하고,
 * deQueue는 front를 증가시킨 뒤 그 위치의 값을 반환한다.
 * 모든 기본 연산은 O(1)이지만, 앞쪽의 빈 공간을 다시 쓰지 못하는 단점이 있다.
 */
public class Queue01_선형큐 {
	
	static class LinearQueue {
		private final int[] queue;
		private int front = -1;
		private int rear = -1;
		
		public LinearQueue() {
			queue = new int[1000];
		}
		
		public LinearQueue(int size) {
			if(size <= 0) throw new RuntimeException("큐의 크기는 1이상이어야한다");
			queue = new int[size];
		}
		
		// 1. 큐에 데이터를 삽입
		void enQueue(int item) {
			// 배열을 이용해서 만들고 있다!(포화 상태를 체크)
			if(rear == queue.length - 1) {
				System.out.println("가득 차있음");
				return;
			}
			
			//rear를 하나 증가시키고 해당 위치에 값을 넣겠다.
			queue[++rear] = item;
		}
		
		
		
		// 2. 큐에 데이터를 삭제(반환, 꺼낸다)
		int deQueue() {
			// 큐 공백상태를 체크한다
			if(front == rear) {
				System.out.println("공백 상태");
				return -1; // 살짝 위험할지도 몰라
				// int 배욜이 아니라 참조형 Integer 배열로 null을 반환하겠다
			}
			return queue[++front];
		}
		
		// 3. 큐에 데이터를 반환(삭제는 하지 않음)
		int peek() {
			if(front == rear) {
				System.out.println("공백 상태");
				throw new NoSuchElementException("큐가 공백상태에요");
			}
			return queue[front+1];
		}
		
		boolean isEmpty() {
			return front ==rear;
		}
		
		boolean isFull() {
			return rear == queue.length-1;
		}
		
		// 실제로 큐에 들어있는 원소의 개수
		int size() {
			return rear - front;
		}
		
	} 
	
	
	
	public static void main(String[] args) {
		LinearQueue queue = new LinearQueue();
		
		queue.enQueue(10);
		queue.enQueue(20);
		queue.enQueue(30);
		System.out.println(queue.deQueue());
		
		
	}
}
