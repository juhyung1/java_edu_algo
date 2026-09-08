import java.util.Arrays;

/**
 * 같은 종류의 원소를 여러 번 선택할 수 있는 중복 조합을 구현한다.
 *
 * <p>일반 조합과 핵심 차이는 다음 재귀 호출의 시작 위치뿐이다.</p>
 * <ul>
 *   <li>일반 조합: combination(i + 1, ...) - 방금 고른 원소는 다시 고르지 않음</li>
 *   <li>중복 조합: combination(i, ...) - 방금 고른 원소도 다시 고를 수 있음</li>
 * </ul>
 *
 * <p>시작 위치를 매번 0으로 되돌리면 [A, B]와 [B, A]가 모두 만들어져
 * 중복 조합이 아니라 중복 순열이 되므로 주의한다.</p>
 */
public class 조합_04_중복조합 {
	static int[] nums = {0, 1, 2 };
	static int N, R;
	static int[] sel;

    public static void main(String[] args) {
    	N = nums.length;
    	R = 2;
    	sel = new int[R];
    	combination(0, 0);
    }
    
    public static void combination(int start, int sidx) {
    	if(sidx == R) { 
    		// 다 뽑았을 경우
    		System.out.println(Arrays.toString(sel));
    		return;
    	}

    	
    	for(int i = start; i < N; i++) {
    		sel[sidx] = nums[i];	// 뽑고 (안뽑고의 개념은 없어짐)
    		combination(i, sidx + 1);
    	}
    	
    	
    }

}
