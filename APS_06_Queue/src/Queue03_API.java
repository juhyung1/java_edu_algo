import java.util.*;

/**
 * 자바가 제공하는 Queue 인터페이스와 ArrayDeque 구현체의 사용 예제이다.
 *
 * Queue는 인터페이스이므로 new Queue<>()로 직접 객체를 만들 수 없다.
 * 일반적인 알고리즘 문제에서는 ArrayDeque를 구현체로 많이 사용한다.
 *
 * 권장 메서드
 * - offer(e): 뒤에 삽입, 실패하면 false
 * - poll(): 앞에서 삭제 및 반환, 비어 있으면 null
 * - peek(): 앞의 값 확인, 비어 있으면 null
 *
 * add/remove/element도 같은 역할을 하지만 실패 시 예외를 발생시킨다.
 */
public class Queue03_API {
	public static void main(String[] args) {
		Queue<Integer> queue1 = new LinkedList<>();
		Queue<Integer> queue2 = new ArrayDeque<>();
		
		// 값 추가
//		queue1.offer(10);
//		queue1.add(20);
		
		// 값 확인
		System.out.println(queue1.peek());
		System.out.println(queue1.element());
//		queue1.peek();
//		queue1.element();
		
		// 값 삭제(반환)
		queue1.poll();
		queue1.remove();
		
		queue1.isEmpty();
		queue1.size();
		
		
		
		
		
	}
}
