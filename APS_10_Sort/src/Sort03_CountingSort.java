import java.util.Arrays;

/**
 * [카운팅 정렬(Counting Sort)]
 *
 * 값을 직접 비교하지 않고 각 값이 몇 번 나타나는지를 센다.
 * 누적합은 각 값이 정렬 결과에서 차지하는 구간의 끝 위치를 알려 준다.
 * 원본을 뒤에서부터 읽어 결과 배열에 놓으면 같은 값의 원래 순서가 유지된다.
 *
 * 시간 복잡도: O(N + K), 추가 공간: O(N + K)
 * K는 최댓값 자체가 아니라 '최댓값 - 최솟값 + 1'인 값의 범위다.
 *
 *  */
public class Sort03_CountingSort {
	public static void main(String[] args) {
		int[] numbers = { 0, 4, 1, 3, 1, 2, 4, 1 };
		
		System.out.println(Arrays.toString(countingSort(numbers)));
	}
	
	static int[] countingSort(int[] numbers) {
		int N = numbers.length;
		int[] sortedArr = new int[N];
		
		// 1. 가장 큰 값을 찾는다 (문제에서 음수가 나오면 고민해야됨)
		int maxValue = -1;
		for(int i = 0; i < N; i++) {
			if(numbers[i] > maxValue) {
				maxValue = numbers[i];
			}
		}
		
		// 2. count 하기
		int[] count = new int[maxValue + 1]; // 가장 큰 값까지 인덱스로 활용해야되니까
		for(int i = 0 ; i < N; i++) {
//			int idx = numbers[i];
//			count[idx]++;			
			count[numbers[i]]++; // 해당 값을 인덱스로하여 카운팅			
		}
		
		// 3. 누적합 구하기(경계를 나타낸다.)
		for(int i = 1; i < count.length; i++) {
//			count[i] = count[i] + count[i-1];
			count[i] += count[i-1];
		}
		
		// 4. 역방향으로 원본을 순회하면서 정렬
		for(int i = N - 1; i >= 0; i--) {
			int num = numbers[i]; // 해당 값을 정렬 배열에 넣겠다.
			
//			int idx = count[num] - 1; // 정렬된 배열 어디에 넣을건지
//			sortedArr[idx] = num;	// 해당 위치에 해당 값을 넣자
//			count[num]--;
			
			int idx = --count[num]; // 정렬된 배열 어디에 넣을건지
			sortedArr[idx] = num;	// 해당 위치에 해당 값을 넣자
			
			
			// 코딩 체력이 차있는 상태			
//			sortedArr[-count[numbers[i]]] = numbers[i];
		}
		
		return sortedArr;
	}
	
	// 고민하면 좋을것
	// 1. 음수가 들어온다면? 최솟값과 최댓값을 찾아서 옮겨놓고 정렬 진행
	// 2. 값이 0이 아니라 100~200 사이라고 가정 -> 인덱스는 0부터기 때문에 100을 빼고 정렬하고 나중에 100 더하기
}
