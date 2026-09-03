import java.util.PriorityQueue;

/**
 * [객체의 우선순위 정하기]
 *
 * 정수는 기본 대소 관계가 있지만, 학생 객체는 무엇을 먼저 꺼낼지 직접 정해야 한다.
 * 이 예제의 우선순위는 다음과 같다.
 * 1. 점수가 높은 학생 우선
 * 2. 점수가 같으면 이름이 사전순으로 빠른 학생 우선
 * 3. 점수와 이름이 같으면 번호가 작은 학생 우선
 *
 * Comparator가 음수를 반환하면 첫 번째 인수가 더 앞에 온다.
 * 단순히 b.score - a.score를 사용하면 큰 정수에서 오버플로가 날 수 있으므로
 * Integer.compare를 사용하는 편이 안전하다.
 */
public class Heap03_객체PriorityQueue {
	static class Student implements Comparable<Student>{
		int num;
		String name;
		int score;
		public Student() {
			
		}
		public Student(int num, String name, int score) {
			super();
			this.num = num;
			this.name = name;
			this.score = score;
		}
		@Override
		public String toString() {
			return "Student [num=" + num + ", name=" + name + ", score=" + score + "]";
		}
		@Override
		public int compareTo(Student o) {
			// 반환값이 음수면 (안바꾼다) / 0 (동일) / 양수(바꾼다)
			return this.score - o.score;
			
//			return o.score - this.score; 내림차순
		}
	}
	
	
	public static void main(String[] args) {
		PriorityQueue<Student> heap = new PriorityQueue<>();
		
		heap.offer(new Student(1, "양싸피", 50));
		heap.offer(new Student(2, "김싸피", 150));
		heap.offer(new Student(3, "유싸피", 80));
		
		while(!heap.isEmpty()) {
			System.out.println(heap.poll());
		}
		
//		PriorityQueue<Student> heap2 = new PriorityQueue<Student>();
		
		
	}
}
