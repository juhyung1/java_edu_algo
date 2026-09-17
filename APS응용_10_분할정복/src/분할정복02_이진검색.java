import java.util.Arrays;

public class 분할정복02_이진검색 {
	static int[] arr;

	public static void main(String[] args) {
		arr = new int[] {2, 4, 7, 9, 11, 19, 23};
		
		int idx = Arrays.binarySearch(arr, 3);
		System.out.println(idx);
	}
	
	static int binarySearchFor(int key) {
		// 배열의 범위를 조절하는 변수 2개
		int L = 0;
		int R = arr.length - 1;
		
		// L과 R이 교차가 되면 멈춘다
		while(L <= R) {
			int mid = (L + R) / 2; // 소수점은 버려진다.
			if(arr[mid] == key) return mid;
			
			else if (arr[mid] > key)  // 왼쪽구간으로 축소
				R = mid - 1;
			
			else 	// 오른쪽구간으로 축소
				L = mid + 1;
		}
		return -1; // 못찾았다.
	}
	
	static int binarySearchRecursive(int L, int R, int key) {
		if(L > R) return -1;
		
		int mid = (L+R) / 2;
		if(arr[mid] == key) return mid;
		
		else if(arr[mid] > key) return binarySearchRecursive(L, mid - 1, key);
		
		else return binarySearchRecursive(mid + 1, R, key);
	}

}
