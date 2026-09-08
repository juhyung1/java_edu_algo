/**
 * [중첩 반복문으로 만드는 순열]
 *
 * 원소 3개를 모두 나열할 때는 반복문 3개로 각 자리를 직접 채울 수 있다.
 * 앞자리에서 사용한 인덱스와 겹치는 후보는 건너뛰어 같은 원소를 다시 쓰지 않는다.
 *
 * 흐름이 눈에 보인다는 장점이 있지만, N개 중 R개를 나열하려면 반복문도 R개 필요하다.
 * 따라서 입력 크기가 달라지는 일반 문제에는 재귀 방식이 더 적합하다.
 */
public class 순열_01_반복문 {
	public static void main(String[] args) {
		int[] nums = {0, 1, 2};
		
		for(int i = 0; i < nums.length; i++) {
			for(int j = 0; j < nums.length; j++) {
				// 1. i, j가 같다고 continue 하면 안됨(그냥 넘어가버림)
				
				// 2. i, j가 다르면 3번째 자리를 찾는for문을 작성한다
				if(i != j) {
					for(int k = 0; k < nums.length; k++) {
						// 1. i == k && j == k
						// 2. k != i && k != j
						if(k != i && k != j) {
							System.out.printf("%d %d %d\n", nums[i], nums[j], nums[k]);
						}
					}
				}	// 인덱스가 다르면
			}
		}
	}
}
