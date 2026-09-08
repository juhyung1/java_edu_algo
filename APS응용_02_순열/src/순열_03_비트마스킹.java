import java.util.Arrays;

/**
 * [재귀 + 비트마스킹으로 만드는 N개 중 R개 순열]
 *
 * boolean[] 대신 int의 각 비트로 원소 사용 여부를 저장한다.
 * - visited & (1 << i): i번 원소가 이미 사용됐는지 확인
 * - visited | (1 << i): i번 원소를 사용 처리한 새 상태
 *
 * visited는 기본형 값으로 전달되므로 재귀 호출에서 돌아온 뒤 별도 복구가 필요하지 않다.
 * 표현만 다를 뿐 방문 배열 방식과 생성 결과 및 시간 복잡도는 같다.
 */
public class 순열_03_비트마스킹 {
	public static void main(String[] args) {
		int[] nums = {0,1,2};
		int N = nums.length;
		int R = N;
		int[] result = new int[R];
		int visited = 0;
		
		permutation(nums, N, R, 0, visited, result);
	}
	
	// nums : 원본 배열
	// N 전체 원소의 수, R 내가 뽑고자 하는 수
	// depth : result의 인덱스
	// visited : boolean 배열 대신 사용 체크하기 윟마
	// reulst : 뽑은 결과를 저장하는 배열
	public static void permutation(int[] nums, int N, int R, int depth, int visited, int[] result) {
		if(depth == N) {
			System.out.println(Arrays.toString(result));
			return;
		}
		
		for(int i = 0; i < N; i++) { // nums.length
			// 방문 체크를 통해 이미 사욯안 자릿값 이라면 버리기
			if( (visited & (1<<i)) != 0) continue;
			
			
			result[depth] = nums[i];
			permutation(nums, N, R, depth+1, visited | (1 << i), result);
			// 원상복구
		}
		
	}
}
