import java.util.Arrays;

/**
 * 조합을 "현재 원소를 뽑는다 / 뽑지 않는다"의 두 갈래 재귀로 구현한다.
 *
 * <p>조합은 순서를 구분하지 않는다. 예를 들어 [상추, 패티]와 [패티, 상추]는
 * 같은 조합이다. 이 코드는 원본 배열을 왼쪽에서 오른쪽으로 한 번만 살펴보므로
 * 같은 원소들을 순서만 바꾸어 다시 뽑지 않는다.</p>
 *
 * <p>모든 결과를 실제로 만드는 시간은 적어도 결과 개수 C(N, R)에 비례한다.
 * 선택 배열과 호출 스택에는 O(R), O(N)의 추가 공간이 필요하다.</p>
 */
public class 조합_01_재귀함수 {
	static String[] 재료 = {"상추", "패티", "토마토", "치즈"};
	static int N, R;
	static String[] 뽑은;

    public static void main(String[] args) {
    	N = 재료.length;
    	R = 2;		// 몇 개 뽑을건지
    	뽑은 = new String[R];
    	
    	combination(0, 0);
    }
    
    // idx : 재료(데이터) index
    // sidx : 뽑을 배열의 index
    static void combination(int idx, int sidx) {
    	if(sidx == R) {
    		// 다 뽑았다면
    		System.out.println(Arrays.toString(뽑은));
    		return;
    	}
    	
//    	else if
    	if(idx == N) {
    		// 판단할 수 있는 재료가 더이상 존재하지 않는다
    		return;
    	}
    	
    	뽑은[sidx] = 재료[idx];
    	// 1. 재료를 뽑은 경우
    	combination(idx+1, sidx+1);
    	
    	// 2. 재료를 뽑지 않은 경우
    	combination(idx+1, sidx);  	
    	
    }
}
