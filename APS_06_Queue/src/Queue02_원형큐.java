/**
 * 배열의 끝과 처음을 연결하여 사용하는 원형 큐(Circular Queue) 예제이다.
 *
 * 인덱스가 배열의 끝을 지나면 나머지 연산으로 0번 위치로 돌아온다.
 * - 다음 인덱스 = (현재 인덱스 + 1) % 배열 길이
 * - 공백 상태: front == rear
 * - 포화 상태: (rear + 1) % 배열 길이 == front
 *
 * 비어 있는 상태와 가득 찬 상태를 구분하기 위해 배열 한 칸을 항상 비워 둔다.
 * 따라서 길이가 N인 배열에는 최대 N-1개의 원소를 저장할 수 있다.
 */
public class Queue02_원형큐 {
	static class CircularQueue {
		private final String[] queue = new String[100];
		private int front = 0;
		private int rear = 0;
		
		void enQueue(String item) {
			if(isFull()) {
				System.out.println("가득 차있음");
				return;
			}
			//rear가 순환 이동하게끔 값을 변경
			rear = (rear + 1) % queue.length;
			queue[rear] = item;
		}
		
		String deQueue() {
			if(isEmpty()) {
				System.out.println("가득 차있음");
				return null;
			}
			
			// front를 순환이동 시킨 후 꺼낸다
			front = (front + 1) % queue.length;
			return queue[front];
		}
		
		String peek() {
			if(isEmpty()) {
				return null;
			}
			return queue[(front + 1) % queue.length];
		}
		
		boolean isFull() {
			// rear를 순환이동시킨 값이 front와 동일하다면... 이건 가득 차 있는거야
			// 한칸을 비워두는 방식
			return (rear + 1) % queue.length == front;
		}
		
		boolean isEmpty() {
			return front == rear;
		}
		
		int size() {
			return (rear - front + queue.length) % queue.length; 
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
	}
}
