import java.util.Arrays;

public class 분할정복03_MergeSort {
	static int[] arr;
	static int N;
	static int[] tmp;
	
	public static void main(String[] args) {
		arr = new int[] {69,10,30,2,16,8,31,22};
		N = arr.length;
		tmp = new int[N];
		
		mergeSort(0, N-1);
		System.out.println(Arrays.toString(arr));
	}
	
	static void mergeSort(int L, int R) {
//		if(L >= R) return; //교차했네? 그러면 진행은 없다.
		if(L < R) {
			int mid = (L+R)/2; //중간 위치
			mergeSort(L, mid);
			mergeSort(mid+1, R);
			//결합 병합 코드를 작성한ㄷ.
			merge(L, mid, R);
		}
	}

	private static void merge(int L, int mid, int R) {
		//왼쪽구간의 시작점, 오른쪽 구간의 시작점, 임시배열의 시작점
		int left = L;
		int right = mid+1;
		int idx = L;
		
		//왼쪽구간과 오른쪽구간을 비교하면서 임시 배열을 채우자
		while(left <= mid && right <= R) {
			//오름차순, 안정정렬
			if(arr[left] <= arr[right]) {
				tmp[idx++] = arr[left++];
			}else {
				tmp[idx++] = arr[right++];
			}
		}//한쪽구간은 완료가 되었다.
		
		//나머지구간을 전부다 털자
		//왼쪽이 남은 경우
		if(left <= mid) {
			for(int i = left; i<=mid; i++) {
				tmp[idx++] = arr[i];
			}
		}
		//오른쪽이 남은 경우
		else {
			for(int i = right; i<=R; i++) {
				tmp[idx++] = arr[i];
			}
		}
		
		//임시배열에 정렬된 값들을 원본값에 덮어씌운다.
		for(int i = L; i<=R; i++) {
			arr[i] = tmp[i];
		}
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
