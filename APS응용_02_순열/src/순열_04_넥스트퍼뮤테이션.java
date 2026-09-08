import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * [Next Permutation]
 *
 * 현재 배열을 사전순으로 바로 다음에 오는 순열로 바꾼다.
 * 1. 뒤에서부터 arr[i-1] < arr[i]인 첫 위치를 찾아 pivot을 정한다.
 * 2. 뒤에서 pivot보다 큰 값을 처음 찾아 교환한다.
 * 3. pivot 뒤의 내림차순 구간을 뒤집어 가장 작은 오름차순 상태로 만든다.
 *
 * 한 번 이동하는 시간은 O(N), 추가 공간은 O(1)이다.
 * 오름차순 정렬 상태에서 시작하면 모든 순열을 사전순으로 빠짐없이 만들 수 있다.
 * 중복 값이 있어도 같은 값 순열은 한 번만 생성되는 것이 큰 장점이다.
 */
public class 순열_04_넥스트퍼뮤테이션 {
	static boolean nextPermutation(int[] numbers) {
		if (numbers.length < 2) {
			return false; // 빈 배열과 원소 하나짜리 배열에는 다음 순열이 없다.
		}

		int suffixStart = numbers.length - 1;
		while (suffixStart > 0 && numbers[suffixStart - 1] >= numbers[suffixStart]) {
			suffixStart--;
		}

		if (suffixStart == 0) {
			return false; // 전체가 내림차순이므로 현재 배열이 마지막 순열이다.
		}

		int pivot = suffixStart - 1;
		int successor = numbers.length - 1;
		while (numbers[successor] <= numbers[pivot]) {
			successor--;
		}
		swap(numbers, pivot, successor);

		// 원래 내림차순이던 뒤쪽을 뒤집으면 가장 작은 오름차순 배치가 된다.
		reverse(numbers, suffixStart, numbers.length - 1);
		return true;
	}

	/** 원본을 변경하지 않고, 중복을 제거한 모든 값 순열을 사전순으로 반환한다. */
	static List<int[]> generateUnique(int[] original) {
		if (original.length > 10) {
			throw new IllegalArgumentException("N! 폭증을 막기 위해 학습용 목록은 N <= 10만 허용합니다.");
		}

		int[] numbers = original.clone();
		Arrays.sort(numbers); // 모든 순열을 생성하려면 반드시 가장 첫 순열에서 시작해야 한다.
		List<int[]> result = new ArrayList<>();
		do {
			result.add(numbers.clone());
		} while (nextPermutation(numbers));
		return result;
	}

	private static void reverse(int[] numbers, int left, int right) {
		while (left < right) {
			swap(numbers, left++, right--);
		}
	}

	private static void swap(int[] numbers, int first, int second) {
		int temp = numbers[first];
		numbers[first] = numbers[second];
		numbers[second] = temp;
	}

	public static void main(String[] args) {
		System.out.println("중복 없는 값 순열:");
		for (int[] permutation : generateUnique(new int[] { 1, 2, 3 })) {
			System.out.println(Arrays.toString(permutation));
		}

		System.out.println("중복 값이 있는 경우:");
		for (int[] permutation : generateUnique(new int[] { 1, 1, 2 })) {
			System.out.println(Arrays.toString(permutation));
		}
	}
}