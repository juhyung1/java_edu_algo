public class Array02_배열의순회 {
	public static void main(String[] args) {
		int[] arr = { 0, 1, 2, 3, 4, 5, 6 };
		int N = arr.length;

		// 1. 정방향 순회: 왼쪽 -> 오른쪽
		for (int i = 0; i < N; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();

		// 2. 역방향 순회: 반복문을 조절
		for (int i = N - 1; i >= 0; i--) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();

		// 3. 역방향 순회: 인덱스를 조절
		for (int i = 0; i < N; i++) {
			System.out.print(arr[N - 1 - i] + " ");
		}
		System.out.println();

	}
}
