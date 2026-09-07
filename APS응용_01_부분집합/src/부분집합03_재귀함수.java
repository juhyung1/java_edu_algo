/**
 * [재귀 함수로 만드는 부분집합]
 *
 * index번째 원소를 '선택하지 않는 경우'와 '선택하는 경우'로 나누어 호출한다.
 * index가 원소 수에 도달하면 모든 선택이 끝났으므로 부분집합 하나가 완성된다.
 *
 * 원소 수가 달라져도 코드 구조가 바뀌지 않고, 중간에 조건을 검사해 가지치기하기 쉽다.
 * 호출 수는 약 2^(N+1)-1, 완성되는 부분집합은 2^N개, 재귀 깊이는 N이다.
 */
public class 부분집합03_재귀함수 {
	static String[] ingredients;
	static int N;
	public static void main(String[] args) {
		ingredients = new String[]{ "단무지", "햄", "오이" };
		N = ingredients.length;
		
		boolean[] sel = new boolean[N];
//		powerset(0, new boolean[N]);
		powerset(0, sel);
	}
	
	
	
	// 재귀함수
	// idx : 현재 고려하고 있는 재료의 위치
	public static void powerset(int idx, boolean[] sel) {
		// base : 더이상 재귀를 호출하지 않도록
		if(idx == N) {
			// 김밥 재료 선정 완료
			for(int i = 0; i < N; i++) {
				if(sel[i]) {
					System.out.print(ingredients[i]);
				}
			}
			System.out.println(":김밥");
			return;
		}		
		// recursive : 재귀 호출 (2회 : 재료를 넣어다/안넣었다.)
		sel[idx] = true;
		powerset(idx + 1, sel); // 재료를 넣은 경우
		
		sel[idx] = false;
		powerset(idx + 1, sel); // 재료를 안넣은 경우
	}
}
