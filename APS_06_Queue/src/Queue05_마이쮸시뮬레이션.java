import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 큐를 이용하여 마이쮸 배부 대기열을 그대로 시뮬레이션하는 예제이다.
 *
 * 규칙
 * 1. 줄의 맨 앞 사람이 자신의 차례에 받을 개수만큼 마이쮸를 받는다.
 * 2. 받은 사람은 다음에 한 개 더 받기로 하고 줄의 맨 뒤에 다시 선다.
 * 3. 아직 줄을 서지 않은 새 번호의 사람이 1개를 받기 위해 맨 뒤에 선다.
 * 4. 남은 수가 요청한 수보다 적으면 남은 것을 모두 주고 종료한다.
 *
 * 큐에 저장해야 하는 상태는 사람 번호와 다음에 받을 개수 두 가지이다.
 */
public class Queue05_마이쮸시뮬레이션 {
	static class Person {
		static int pNumber = 1; // 클래스 변수 
		int num;	// 사람의 번호
		int cnt;	// 마이쮸를 가져갈 개수
		
		public Person() {
			this.num = pNumber++;
			this.cnt = 1;
		}
		
		public Person(int num, int cnt) {
			this.num = num;
			this.cnt = cnt;
		}
	}
	
	
	public static void main(String[] args) {
		
		int N = 20;	// 마이쮸 개수
		
		int ans = 0;	// 마지막 인간의 번호
		
		//Q를 통해서 사람을 관리하겠다
		Queue<Person> q = new ArrayDeque<>();
		
		// 관리하고자 하는 값들이 전부 int 형이라 int[]을 넣고 해도됨
		//[0] : number, [1] : cnt 내가 인지하고 있어야함
//		Queue<int[]> q = new ArrayDeque<>();
		
		q.offer(new Person());	// 한 명을 넣어놓고 시작하겠다
		
		// for문 : 반복횟수를 알고있을때 주로 사용
		//while 문 : 조건을 통해서 반복을 할 때 주로 사용
		// 마이쮸가 남아있으면 계속 돌겠다
		
		while(N > 0) {
			Person p = q.poll(); // 사람을 한 명 꺼냄
			
			N -= p.cnt; // 마이쮸를 준다 (개수 감소)
			if(N <= 0) { // 마이쮸를 다 준거
				ans = p.num;
				break;
			}
			
			// 나누어 준 후
			// 1. p의 마이쮸를 가져갈 개수를 1개 늘린다
//			p.cnt++;
//			// 2. p를 다시 줄 세운다
//			q.offer(p);
			q.offer(new Person(p.num, p.cnt+1));
			// 3. 새로운 사람을 데려와서 줄을 세운다
			q.offer(new Person());		
			
		}
		
		
		
		System.out.println("마지막으로 마이쮸를 가져간 친구는 : " + ans);
		}
}
