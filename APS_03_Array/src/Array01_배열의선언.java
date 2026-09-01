import java.util.Arrays;

public class Array01_배열의선언 {
	public static void main(String[] args) {
		// 배열을 선언하기 위해 필요한 3가지
		// 1. 자료형, 2. 배열이름, 3. 길이
		int[] nums = new int[6]; // 0으로 채워진 6칸짜리 배열

		// 배열의 초기화
		int[] nums1 = new int[] { 1, 2, 3, 4, 5 };
		int[] nums2 = { 6, 7, 8, 9, 10 };

		// 배열의 길이와 인덱스 접근
		int N = nums.length;
		nums[0] = 10;
		int idx = 4;
		nums[idx] = 20;

		System.out.println(N);
		System.out.println(Arrays.toString(nums));
		System.out.println(Arrays.toString(nums1));
		System.out.println(Arrays.toString(nums2));

		////////////////////////////////////////////////////////////
		// b = a는 값 복사가 아니라 같은 배열을 바라보는 것!
		int[] a = { 5, 2, 9, 1 };
		int[] b = a;
		int[] c = a.clone();
		int[] d = Arrays.copyOf(a, a.length);
		int[] e = Arrays.copyOfRange(a, 1, 3); // 1번 이상, 3번 미만

		b[0] = 100;
		System.out.println(Arrays.toString(a)); // b를 바꾸면 a도 바뀐다.
		System.out.println(Arrays.toString(c)); // 값 복사라서 바뀌지 않는다.
		System.out.println(Arrays.toString(d));
		System.out.println(Arrays.toString(e));

		Arrays.fill(d, -1);
		Arrays.sort(a);
		System.out.println(Arrays.toString(d));
		System.out.println(Arrays.toString(a));
	}
}
