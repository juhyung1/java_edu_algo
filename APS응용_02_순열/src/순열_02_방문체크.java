import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * [재귀 + 방문 배열로 만드는 N개 중 R개 순열]
 *
 * depth번째 자리에 놓을 후보를 차례대로 확인한다.
 * used[index]가 true이면 앞자리에서 이미 사용한 원소이므로 건너뛴다.
 * 재귀 호출이 끝나 돌아오면 used[index]를 false로 복구해야 다른 갈래에서 다시 쓸 수 있다.
 *
 * 서로 다른 N개 중 R개를 순서 있게 뽑는 경우의 수는 N! / (N-R)!이다.
 * 결과를 실제 배열 목록으로 저장하므로 출력 크기 자체에 비례하는 메모리가 필요하다.
 */
public class 순열_02_방문체크 {
	static int N, R;
	static int[] nums, result;
	static boolean[] used;
	static List<int[]> list;
	public static void main(String[] args) {
		
		N = 4;
		R = 4;
		nums = new int[] {0,1,2,3};
		result = new int[R];
		used = new boolean[N];
		
		list = new ArrayList<>();
		permutation(0);
		
		for(int[] arr : list) {
			System.out.println(Arrays.toString(arr));
		}
		
		
	}
	
	// depth : 재귀의 깊이, 내가 현재 고르고 있는 인덱스 값(result의 인덱스)
	public static void permutation(int depth) {
		if(depth == R) { // 순열 완성됐다		
//			System.out.println(Arrays.toString(result));
			list.add(result);
			return;
		}
		
		// 순열을 작성
		for(int i = 0; i < N; i++) {
			if(used[i]) continue; // 이미 사용한 인덱스는 넘어가기
			
			result[depth] = nums[i];
			used[i] = true;
			permutation(depth+1);
			used[i] = false;
		}
		
	}
}
