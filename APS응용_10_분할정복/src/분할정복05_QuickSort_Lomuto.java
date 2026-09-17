import java.util.Arrays;

public class 분할정복05_QuickSort_Lomuto {
	static int[] arr;
	static int N;
	
	public static void main(String[] args) {
		arr = new int[] {69,10,10,10,10,30,2,16,8,31,22};
		N = arr.length;
		quickSort(0, N-1);
		System.out.println(Arrays.toString(arr));
		
		Arrays.sort(arr);
		
	}
	
	static void quickSort(int L, int R) {
		if(L >= R) return;
		int pivot = partition(L, R);
		quickSort(L, pivot-1);
		quickSort(pivot+1, R);
		
	}

	private static int partition(int L, int R) {
		int pivot = arr[R]; //가장 오른쪽의 요소를 피봇이라고 결정
		
		int i = L - 1; //작거나 같은 값들의 경계
		for(int j = L; j < R; j++) {
			if(arr[j] <= pivot) {
				i++;
				int tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
			}
		}//경계가 결정이 됨
		
		int tmp = arr[i+1];
		arr[i+1] = arr[R];
		arr[R] = tmp;
		
		return i+1;
	}
	
	
	
	
	
	
	
	
	
	
	
}
