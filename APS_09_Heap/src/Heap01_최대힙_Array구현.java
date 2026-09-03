import java.util.NoSuchElementException;

/**
 * [배열로 직접 구현하는 최대 힙(Max Heap)]
 *
 * 힙은 다음 두 조건을 모두 만족한다.
 * 1. 모양 규칙: 마지막 레벨을 제외하고 꽉 차며, 마지막 레벨은 왼쪽부터 채운다.
 * 2. 값 규칙: 최대 힙에서는 모든 부모 값이 자식 값보다 크거나 같다.
 *
 * 완전 이진 트리에는 중간 빈칸이 없으므로 배열에 차례대로 저장할 수 있다.
 * 이 예제는 계산식을 단순하게 만들기 위해 0번 칸을 비우고 1번부터 사용한다.
 * - 부모: i / 2
 * - 왼쪽 자식: i * 2
 * - 오른쪽 자식: i * 2 + 1
 *
 * offer: O(log N), peek: O(1), poll: O(log N), 공간: O(N)
 */
public class Heap01_최대힙_Array구현 {
	static class MaxHeap {
		private int[] heap = new int [20];	// int 자료형을 이용하여 heap을 구성하겠다
		private int size;
		
		// 1. offer (heap push)
		void offer(int item) {
			// 우리는 따로 구현은 안할거지만...
			// 만약 꽉 차있다면 두배로 늘려서 넣을 수 있게 세팅도 가능하다
			
			heap[++size] = item;
			
			int child = size;
			// 루트의 자식까지만..
			while(child > 1) {
				int parent = child / 2; // 정수 자료형 -> 소수점 버려짐
				if(heap[parent] >= heap[child]) {
					// 부모와 자식의 규칙이 만족스럽다
					break;
				}
				swap(parent, child);
//				swap(child, parent); 상관없다
				
//				if(heap[parent] < heap[child]) {
//					// swap()을 해야한다
//				}
				
				child = parent;
				
			}
			
		}	// offer
		
		// 2. peek루트 값을 반환
		// 힙이 공백인지 아닌지 확인을 해야한다
		int peek() {
			if(size == 0) throw new NoSuchElementException("힙이 비어있다");
			return heap[1];
		}
		
		// 3. poll (heap pop)
		int poll() {
			if(size == 0) throw new NoSuchElementException("힙이 비어있다");
			int maxValue = heap[1];	// 루트 값을 꺼내고
			
			heap[1] = heap[size--];	// 힙의 마지막 원소를 루트에 올려놓는다
			
			int parent = 1; // 초기에는 루트값부터 내려가면서 비교
			while(parent * 2 <= size) { // 왼쪽 자식이 있으면 자식이 하나 이상 존재한다
				int child = parent * 2;	// 자식의 번호를 왼자로 세팅
				
				// 오자가 존재하면서, 왼자랑 비교를 했더니 더 우선순위에 적합하다
				if(child+1 <= size && heap[child] < heap[child+1]) {
					child = child+1;
				}
				//////////////////////////////////////////////
				// child는 왼자나 오자 상관 없이 둘 중 더 베스트인 노드번호가 들어있다
				
				if(heap[parent] >= heap[child]) {
					break;	// 부모가 더 크거나 같으면 갱신할 필요가 없다
				}
				// 위치를 swap
//				swap(parent, child);
				swap(child, parent);
				
			}	//while
			
			return maxValue;
		}
		
		
		// a, b는 인덱스
		public void swap(int a, int b) {
			int tmp = heap[a];
			heap[a] = heap[b];
			heap[b] = tmp;
		}		
	}		// heap class	
	
	public static void main(String[] args) {
		MaxHeap heap = new MaxHeap();
		
		int[] nums = {20, 15, 19, 4, 13, 11, 79};
		for(int num : nums) {
			heap.offer(num);
		}
		
		while(heap.size > 0) {
			System.out.println(heap.poll());
		}
		
	}
}
