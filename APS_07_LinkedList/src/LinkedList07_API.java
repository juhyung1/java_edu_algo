import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 자바가 제공하는 java.util.LinkedList의 기본 사용법을 확인하는 예제이다.
 *
 * LinkedList는 내부적으로 head와 tail을 가진 이중 연결 리스트이며,
 * List와 Deque 인터페이스를 모두 구현한다.
 * 리스트, 스택, 큐의 용도로 사용할 수 있지만 목적에 맞는 인터페이스 타입으로 선언한다.
 *
 * ArrayList와 LinkedList 선택 기준
 * - index 조회가 많다면 ArrayList가 유리하다.
 * - 맨 앞 삽입·삭제가 매우 많다면 LinkedList가 유리할 수 있다.
 * - 중간 삽입은 LinkedList도 위치 탐색이 필요하므로 전체적으로 O(N)이다.
 */
public class LinkedList07_API {
	public static void main(String[] args) {
		List<String> lList = new LinkedList<>();
		
		List<String> aList = new ArrayList<>();
		
//		aList.
	}
}
