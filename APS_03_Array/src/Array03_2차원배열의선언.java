import java.util.Arrays;

public class Array03_2차원배열의선언 {
	public static void main(String[] args) {
		// 2행 4열 크기의 2차원 배열
		int[][] arr = new int[2][4];
		arr[0][0] = 1;
		arr[1][3] = 8;

		// 값을 직접 넣어서 초기화
		int[][] scores = {
				{ 90, 80, 85, 100 },
				{ 100, 80, 75, 60 },
				{ 50, 90, 100, 100 }
		};

		System.out.println("행의 수: " + scores.length);
		System.out.println("0번 행의 열 수: " + scores[0].length);
		System.out.println("2행 3열의 값: " + scores[1][2]);
		System.out.println(Arrays.deepToString(arr));
		System.out.println(Arrays.deepToString(scores));
	}
}
