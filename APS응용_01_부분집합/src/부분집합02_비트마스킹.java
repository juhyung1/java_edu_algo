/**
 * [비트마스킹으로 만드는 부분집합]
 *
 * N비트 정수 하나가 부분집합 하나를 나타낸다.
 * j번째 비트가 1이면 elements[j]를 포함하고, 0이면 포함하지 않는다.
 * 0부터 (1 << N)-1까지 순회하면 공집합부터 전체 집합까지 정확히 2^N개가 나온다.
 *
 * 모든 부분집합을 실제 List로 저장하면 O(N * 2^N) 메모리가 필요하다.
 * 이 학습용 메서드는 실수로 지나치게 큰 결과를 만들지 않도록 N을 20 이하로 제한한다.
 */
public class 부분집합02_비트마스킹 {
	public static void main(String[] args) {
		String[] ingredients = { "단무지", "햄", "오이" };
		
		int N = ingredients.length;
		
		for(int i = 0; i < (1 << N); i++) {
			// 속재료를 확인한다
			for(int j = 0; j < N; j++) { // 재료는 N개 존재하기 때문
				if( (i & (1<<j)) != 0) {
					System.out.print(ingredients[j]);
				}
			}
			System.out.println(":김밥");	
			
		}	// 부분 집합 i 반복문
	}
}
