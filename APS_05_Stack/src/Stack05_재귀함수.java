/**
 * 재귀함수의 호출과 복귀 과정을 확인하는 예제이다.
 *
 * 재귀함수는 일반적으로 두 부분으로 구성된다.
 * 1. Base case: 더 이상 자신을 호출하지 않고 멈추는 종료 조건
 * 2. Recursive case: 문제를 한 단계 작게 만들어 자신을 다시 호출하는 부분
 *
 * 재귀 호출을 거듭할수록 반드시 Base case에 가까워져야 한다.
 * 그렇지 않으면 호출 프레임이 계속 쌓여 StackOverflowError가 발생한다.
 */
public class Stack05_재귀함수 {
	public static void main(String[] args) {
		countDown(10);
	}
	
	
	public static void countDown(int num) {
		System.out.println(num);
		// 무한 호출을 해버렸다
//		countDown(num);
		
		
		// 1. Base case
		if(num == 0) {
			System.out.println("카운팅이 완료가 되었다");
			return;
		}
		
		
		// 2. recursive case
		countDown(num-1);
		
		
		
		
		
		
		
		
	}

}
