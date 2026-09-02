import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 덱(Deque, Double-Ended Queue)의 양쪽 삽입·삭제를 확인하는 예제이다.
 *
 * 덱은 앞과 뒤에서 모두 원소를 넣고 뺄 수 있다.
 * - 한쪽으로 넣고 반대쪽에서 꺼내면 큐(FIFO)
 * - 한쪽으로 넣고 같은 쪽에서 꺼내면 스택(LIFO)
 *
 * 중간 원소에 직접 접근하는 자료구조가 아니라 양 끝을 통해서만 접근한다.
 */
public class Queue04_Deque {
	public static void main(String[] args) {
		Deque<String> dq = new ArrayDeque<>();
		
		dq.addFirst("김예진");
		dq.addFirst("김태현");
		dq.addLast("김영효");
		
		System.out.println(dq);
		
		
		
		
	}
}
