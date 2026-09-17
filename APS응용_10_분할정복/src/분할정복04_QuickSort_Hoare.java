import java.util.Arrays;

public class 분할정복04_QuickSort_Hoare {
	static int[] arr;
	static int N;
	
	public static void main(String[] args) {
		arr = new int[] {69,10,10,10,10,30,2,16,8,31,22};
		N = arr.length;
		quickSort(0, N-1);
		System.out.println(Arrays.toString(arr));
	}
	
	static void quickSort(int L, int R) {
		if(L < R) {
			int pivot = partition(L, R);
			quickSort(L, pivot-1);
			quickSort(pivot+1, R);
		}
	}

	private static int partition(int L, int R) {
		int pivot = arr[L]; //가장 왼쪽의 요소를 피봇이라고 결정
		
		int i = L+1;  //피봇보다 큰 수를 찾기 위해서 쓰는
		int j = R;	  //피봇보다 작거나 같은 수를 찾기 위해서 쓰는
		
		while(i<=j) {
			while(i<=j && arr[i] <= pivot) i++; //i는 피봇보다 큰 수를 찾을 때까지 이동
			while(arr[j]>pivot)j--;//j는 피봇보다 작거나 같은 수를 찾을 때까지 이동
			
			//swap
			if(i<j) {
				int tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
			}
		}
		//pivot을 자기자리를 찾아 가게끔 해주자.
		int tmp = arr[L];
		arr[L] = arr[j];
		arr[j] = tmp;
		
		return j;
	}
	
	
	
	
	
	
	
	
	
	
	
}
