import java.util.Arrays;

public class Sort01_BubbleSort {
	public static void main(String[] args) {
		int[] arr = { 56, 78, 67, 42, 25, 210 };

		int N = arr.length; // 길이를 저장할꺼야

		for (int i = N - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				// 오름차순으로 정렬하고자 한다.
				if (arr[j] > arr[j + 1]) {
					// 이슈발생->순서가 어긋남-> swap
					int tmp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = tmp;
					// 자바x Python(가능)
//					arr[j], arr[j+1] = arr[j+1], arr[j];
				}
			} // 한사이클에서 바꿀꺼 다 바꿨어
			System.out.println(Arrays.toString(arr));
		} // 사이클을 의미한다. N-1번 수행으로만 써도 좋고
			// i에 의미를 담아서 써도 좋고 (코드 짜기 나름이다)
	}

}
