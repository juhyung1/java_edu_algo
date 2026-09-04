import java.util.Arrays;

/**
 * [선택 정렬(Selection Sort)]
 *
 * 정렬되지 않은 구간에서 가장 작은 값을 골라 그 구간의 맨 앞과 교환한다.
 * i번째 반복이 끝나면 0번부터 i번까지의 값이 최종 위치에 확정된다.
 *
 * 특징
 * - 입력 상태와 관계없이 비교 횟수가 거의 같다: O(N^2)
 * - 한 회전에 교환은 최대 한 번: 전체 교환 횟수는 N-1번 이하
 * - 배열 내부에서 정렬하므로 추가 공간은 O(1)
 * - 멀리 떨어진 두 원소를 교환하므로 불안정 정렬
 */
public class Sort01_SelectionSort {
	public static void main(String[] args) {
		// numbers를 static으로 올려버리면
		int[] numbers = { 64, 25, 10, 22, 11 };
		
		// 직접 선택정렬을 구현하면 numbers가 요기 있기 때문에
		selectionSort(numbers);
		
		System.out.println(Arrays.toString(numbers));
	}	// main
	
	
	// 오름차순
	static void selectionSort(int[] numbers) {
		for(int i = 0; i < numbers.length - 1; i++) { // 마지막은 정렬할 필요 없어서 -1
			// i번째 위치를 정렬하고 싶다. (해당 위치가 가장 작다고 가정)
			int minIdx = i;
			
			for(int j = i+1; j < numbers.length; j++) {
				if(numbers[j] < numbers[minIdx]) {
					minIdx = j;	// 가장 작은 값의 인덱스로 갱신
				}
			}	// 해당 사이클에서 가장 작은 값을 뽑아오는 for문
			
			if(minIdx != i) { // 이것이 꼭 좋다라고 할 수는 없다
			
			// minIdx와 i를 스왑한다.
			int tmp = numbers[minIdx];
			numbers[minIdx] = numbers[i];
			numbers[i] = tmp;
			}
			
		}	// 사이클 횟수
		
	}	// sort
}
