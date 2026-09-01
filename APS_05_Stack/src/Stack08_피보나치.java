import java.util.Arrays;

/**
 * 피보나치 수를 단순 재귀와 메모이제이션 재귀로 계산하는 예제이다.
 *
 * fib(n) = fib(n - 1) + fib(n - 2)
 * fib(0) = 0, fib(1) = 1
 *
 * 단순 재귀는 같은 값을 여러 번 다시 계산하여 호출 수가 지수적으로 증가한다.
 * 메모이제이션은 한 번 계산한 결과를 배열에 저장하여 각 값을 한 번만 계산한다.
 */
public class Stack08_피보나치 {
	static int[] fiboCount = new int[100];

	public static void main(String[] args) {
//		System.out.println(fibo(20));
//		System.out.println(Arrays.toString(fiboCount));
		System.out.println(memoFibo(50));
	}

	/** 중복 호출이 발생하는 기본 재귀 구현 */
	public static long fibo(int n) {
		fiboCount[n]++;
		// n이 음수가 아니다. 라는 것은 보장
		if (n <= 1) {
			return n;
		}
		return fibo(n-1) + fibo(n-2);
	}
	
	static long[] memo = new long[100];
	static {
		// 확실하게 하자
		Arrays.fill(memo, -1);
		memo[0] = 0;
		memo[1] = 1;
	}
	


	/** 계산한 결과를 memo 배열에서 재사용하는 재귀 구현 */
	public static long memoFibo(int n) {
//		if(n >= 2 && memo[n] == 0) {
		if(memo[n] == 1) {
			memo[n] = memoFibo(n-1) + memoFibo(n-2);
		}
		
		return memo[n];
	}
}
