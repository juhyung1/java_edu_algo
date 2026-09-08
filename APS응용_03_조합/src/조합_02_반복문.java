import java.util.Arrays;

/**
 * 뽑을 개수 R이 3으로 고정된 상황에서 중첩 반복문으로 조합을 만든다.
 *
 * <p>두 번째 인덱스는 첫 번째 인덱스보다 뒤에서, 세 번째 인덱스는 두 번째보다
 * 뒤에서 시작한다. 따라서 항상 i < j < k가 되어 중복과 순서 뒤바뀜이 없다.</p>
 *
 * <p>코드는 짧지만 R이 바뀔 때마다 반복문의 개수도 바꾸어야 하므로,
 * R이 고정된 작은 문제에서만 편리하다.</p>
 */
public class 조합_02_반복문 {

    public static void main(String[] args) {
    	int[] data = {0, 1, 2, 3, 4, 5};
//    	int[] sel = new int[3];
    	int N = data.length;
    	for(int i = 0; i < N-2; i++) {
//    		sel[0] = data[i];
    		for(int j = i + 1; j < N-1; j++ ) {
//    			sel[1] = data[j];
    			for(int k = j + 1; k < N; k++) {
//    				sel[2] = data[k];
    				System.err.printf("%d %d %d %n", data[i], data[j], data[k]);
//    				System.out.println(Arrays.toString(sel));
    			}	// 3
    		}		// 2
    	}			// 1
    }

}
