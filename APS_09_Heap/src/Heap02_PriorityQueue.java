import java.util.Collections;
import java.util.PriorityQueue;

/**
 * [java.util.PriorityQueue 사용법]
 *
 * PriorityQueue는 내부적으로 힙을 사용한다.
 * - 기본 생성자: 값이 작은 원소부터 나오는 최소 힙
 * - Collections.reverseOrder(): 값이 큰 원소부터 나오는 최대 힙
 *
 * offer와 poll은 O(log N), peek는 O(1)이다.
 * 중요한 주의점: for문이나 toString으로 본 내부 순서는 정렬 결과가 아니다.
 * 우선순위에 따른 순서는 poll로 하나씩 꺼낼 때만 보장된다.
 */
public class Heap02_PriorityQueue {
	public static void main(String[] args) {
		int[] nums = {20, 15, 19, 4, 13, 11};
		
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		
		for(int num : nums) {
			minHeap.offer(num);
			maxHeap.offer(num);
		}
		
		while(!minHeap.isEmpty()) {
			System.out.println(minHeap.poll());
		}
		System.out.println("----------------------------");
		while(!maxHeap.isEmpty()) {
			System.out.println(maxHeap.poll());
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
