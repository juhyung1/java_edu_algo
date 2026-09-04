import java.util.Arrays;

/**
 * [LSD 기수 정렬(Radix Sort)]
 *
 * 1의 자리, 10의 자리, 100의 자리처럼 낮은 자릿수부터 차례로 정렬한다.
 * 앞 단계에서 맞춘 순서를 보존해야 전체 값이 올바르게 정렬되므로,
 * 각 자릿수는 반드시 안정 정렬로 처리해야 한다. 이 예제는 카운팅 정렬을 사용한다.
 *
 * 시간 복잡도: O(D * (N + 10)), 추가 공간: O(N + 10)
 * D는 가장 큰 값의 자릿수다. 이 기본 구현은 교안 범위와 같이 0 이상의 정수만 지원한다.
 */
public class Sort04_RadixSort {
	public static void main(String[] args) {
		int[] numbers = { 170, 45, 75, 90, 802, 24, 2, 66 };
		radixSort(numbers);
		System.out.println(Arrays.toString(numbers));
	}
	
	static void radixSort(int[] numbers) {
		// 최댓값 찾기
		int max = numbers[0];
		for(int v : numbers) {
			max = Math.max(max, v);
		}
		
		// 1의 자리, 10의 자리, 100의 자리 등등 정렬 시작
		for(int exp = 1; max/exp > 0; exp *= 10) {
			countingSort(numbers, exp);
		}
		
		
	}

	private static void countingSort(int[] numbers, int exp) {
		int N = numbers.length;
		int[] sortedArr = new int[N];
		int[] count = new int[10]; // 10진수로 할거니까
		
		// 1. 개수를 세자
		for(int i = 0; i < N; i++) {
			int idx = (numbers[i] / exp) % 10;
			count[idx]++;
		}
		
		// 2. 누적합을 하자
		for(int i = 1; i < 10; i++) {
			count[i] += count[i-1];
		}
		
		// 3. 뒤에서부터 배치를 하자
		for(int i = N-1; i >= 0; i--) {
			int idx = (numbers[i] / exp) % 10;
			sortedArr[--count[idx]] = numbers[i];
		}
		
		// 4. 덮자
		for(int i = 0; i < N; i++) {
			numbers[i] = sortedArr[i];
		}
	}
}
