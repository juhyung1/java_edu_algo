public class Array04_2차원배열의순회 {
	public static void main(String[] args) {
		int[][] arr = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		int N = arr.length;
		int M = arr[0].length;

		// 1. 행 우선 순회
		System.out.println("행 우선 순회");
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(arr[i][j] + " ");
			}
		}
		System.out.println();

		// 2. 열 우선 순회
		System.out.println("열 우선 순회");
		for (int j = 0; j < M; j++) {
			for (int i = 0; i < N; i++) {
				System.out.print(arr[i][j] + " ");
			}
		}
		System.out.println();

		// 3. 지그재그 순회
		System.out.println("지그재그 순회");
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int c = j + (M - 1 - 2 * j) * (i % 2);
				System.out.print(arr[i][c] + " ");
			}
		}
		System.out.println();

		// 4. 오른쪽 아래에서 왼쪽 위로 역순 순회
		System.out.println("역순 순회");
		for (int i = N - 1; i >= 0; i--) {
			for (int j = M - 1; j >= 0; j--) {
				System.out.print(arr[i][j] + " ");
			}
		}
		System.out.println();

		// 5. 테두리만 순회
		System.out.println("테두리 순회");
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (i == 0 || i == N - 1 || j == 0 || j == M - 1) {
					System.out.print(arr[i][j] + " ");
				}
			}
		}
		System.out.println();
	}
}
