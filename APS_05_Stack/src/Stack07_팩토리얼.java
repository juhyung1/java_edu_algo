/**
 * 팩토리얼을 재귀적으로 계산하는 예제이다.
 *
 * n! = n * (n - 1)!이라는 관계를 이용해 같은 모양의 더 작은 문제로 줄인다.
 * 0!과 1!은 1이므로 재귀 호출의 Base case가 된다.
 *
 * 시간 복잡도: n부터 1까지 한 번씩 호출하므로 O(N)
 * 공간 복잡도: 호출 스택에 최대 N개의 프레임이 쌓이므로 O(N)
 */
public class Stack07_팩토리얼 {
	public static void main(String[] args) {
		System.out.println(factorial(3));
		System.out.println(factorial2(3));
	}

	public static long factorial(int n) {
		
		// if(n < 0) n이 음수가 들어오면 예외를 발생시키겠다! -> 안전하게 짜기위해선 이 로직을 사용해야할지도?
		// Base : 1! = 1 , 0! = 1
		if(n == 1) {
			return 1;
		}		
		
		// Recursive
		return n * factorial(n-1);
	}
	
	public static long factorial2(int n) {
		long ans = 1;
		
		for(int i = 1; i <= n; i++) {
			ans *= i;
		}
		
		return ans;
	}
	
	
}
