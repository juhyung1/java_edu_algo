/**
 * 하노이의 탑을 재귀적으로 해결하는 예제이다.
 *
 * n개의 원판을 출발 기둥에서 도착 기둥으로 옮기는 과정
 * 1. 위쪽 n-1개를 출발 기둥에서 보조 기둥으로 옮긴다.
 * 2. 가장 큰 n번 원판을 출발 기둥에서 도착 기둥으로 옮긴다.
 * 3. 보조 기둥의 n-1개를 도착 기둥으로 옮긴다.
 *
 * 이동 횟수는 2^N - 1이며 시간 복잡도는 O(2^N)이다.
 * 재귀 호출의 최대 깊이는 N이므로 호출 스택 공간은 O(N)이다.
 */
public class Stack09_하노이탑 {
	static int moveCount;

	public static void main(String[] args) {
		int N = 3;
		hanoi(N, 'A', 'B', 'C');
		System.out.println("총 이동 횟수: " + moveCount);
	}

	/**
	 * @param n    옮겨야 할 원판 수
	 * @param from 출발 기둥
	 * @param via  보조 기둥
	 * @param to   도착 기둥
	 */
	public static void hanoi(int n, char from, char via, char to) {
		if (n <= 0) {
			throw new IllegalArgumentException("원판 수는 1 이상이어야 합니다.");
		}

		// Base case: 원판이 하나라면 출발 기둥에서 도착 기둥으로 바로 이동
		if (n == 1) {
			move(n, from, to);
			return;
		}

		// 1. 위쪽 n-1개를 보조 기둥으로 이동
		hanoi(n - 1, from, to, via);

		// 2. 가장 큰 n번 원판을 도착 기둥으로 이동
		move(n, from, to);

		// 3. 보조 기둥에 있는 n-1개를 도착 기둥으로 이동
		hanoi(n - 1, via, from, to);
	}

	private static void move(int disk, char from, char to) {
		moveCount++;
		System.out.printf("원판 %d: %c -> %c%n", disk, from, to);
	}
}

