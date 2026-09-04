import java.util.Arrays;

/**
 * [삽입 정렬(Insertion Sort)]
 *
 * 카드 패를 정리하듯, 현재 값을 왼쪽의 이미 정렬된 구간에 끼워 넣는다.
 * 현재 값을 key에 보관하고, key보다 큰 값들을 한 칸씩 오른쪽으로 민 뒤
 * 비어 있는 위치에 key를 넣는 것이 핵심이다.
 *
 * 특징
 * - 이미 정렬된 배열: O(N)
 * - 역순 배열: O(N^2)
 * - 추가 공간: O(1)
 * - 같은 값은 밀지 않으므로 원래 순서가 유지되는 안정 정렬
 */
public class Sort02_InsertionSort {
	static int[] numbers;
	public static void main(String[] args) {
		numbers = new int[] { 69, 10, 30, 2, 16, 8, 31, 22 };
		
		insertionSort();
		System.out.println(Arrays.toString(numbers));
	}
	
	
	static void insertionSort() {
		// 첫 번째 요소는 이미 정렬이 되었다고 생각
		for(int i = 1; i < numbers.length; i++) {
			int key = numbers[i];	// 내가 이번에 정렬하고 싶은 값
			int position = i - 1;
			
			while(position >= 0 && numbers[position] > key) {
				numbers[position + 1] = numbers[position];
				position--;
			}
			
			numbers[position + 1] = key;
		}
	}
}
