import java.util.Arrays;

/**
 * 반복문 안에서 재귀 호출하는, 실전에서 가장 자주 사용하는 조합 구현이다.
 *
 * <p>각 재귀 단계는 현재 자리에 들어갈 원소 하나를 고른다. 다음 호출에 i + 1을
 * 넘기므로 이미 고른 원소와 그 앞쪽 원소는 다시 고르지 않는다. R이 바뀌어도
 * 코드를 고칠 필요가 없고, 반복문의 끝을 조절해 가지치기도 할 수 있다.</p>
 */
public class 조합_03_재귀함수_반복문 {
	static int[] nums = {0, 1, 2, 3, 4};
	static int N, R;
	static int[] sel;

    public static void main(String[] args) {
    	N = nums.length;
    	R = 3;
    	sel = new int[R];
    	combination(0, 0);
    	
    }
    public static void combination(int start, int sidx) {
    	if(sidx == R) { 
    		// 다 뽑았을 경우
    		System.out.println(Arrays.toString(sel));
    		return;
    	}
    	int last = N - R + sidx;
    	
    	for(int i = start; i <= last; i++) {
    		sel[sidx] = nums[i];	// 뽑고 (안뽑고의 개념은 없어짐)
    		combination(i + 1, sidx + 1);
    	}
    	
    	
    }

}
