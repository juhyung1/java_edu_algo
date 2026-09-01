public class Array07_순차검색 {
	public static void main(String[] args) {
		int[] noSort = { 4, 9, 11, 23, 2, 19, 7 };
		int[] sorted = { 2, 4, 7, 9, 11, 19, 23 };

		System.out.println(sequentialSearch(noSort, 2)); // 4
		System.out.println(sequentialSearch(noSort, 8)); // -1
		System.out.println(sequentialSearchSorted(sorted, 11)); // 4
		System.out.println(sequentialSearchSorted(sorted, 10)); // -1
	}

	// 정렬 여부와 관계없이 사용할 수 있는 순차 검색
	public static int sequentialSearch(int[] arr, int key) {
		return -1;
	}

	// 오름차순으로 정렬된 배열의 순차 검색
	public static int sequentialSearchSorted(int[] arr, int key) {
		return -1;
	}
}
