import java.util.Arrays;

/**
 * 함수 호출이 시스템 스택에 쌓이고 복귀하는 순서를 관찰하는 예제이다.
 *
 * 메서드를 호출하면 매개변수, 지역변수, 복귀 주소 등의 정보가
 * 하나의 스택 프레임(Stack Frame)에 저장된다.
 * 가장 마지막에 호출된 메서드가 가장 먼저 종료되므로 LIFO 구조가 된다.
 */
public class Stack04_함수호출 {
	static int depth = 0; // 실행 흐름을 들여쓰기하기 위한 학습용 변수

	public static void main(String[] args) {
		enter("main");

		int number = 10; // main 프레임에 만들어지는 지역변수
		function1();
		System.out.println(indent() + "main의 number = " + number);

		exit("main");
	}

	public static void function1() {
		enter("function1");

		int number = 100;      // function1만의 별도 지역변수
		int[] numbers = { 1, 2, 3 };
		function2(number, numbers);

		// int 값은 복사되어 전달되므로 function2에서 바꾼 값이 반영되지 않는다.
		System.out.println(indent() + "function1의 number = " + number);
		// 배열의 원소 변경은 같은 배열 객체를 통해 확인할 수 있다.
		System.out.println(indent() + "function1의 배열 = " + Arrays.toString(numbers));

		exit("function1");
	}

	public static void function2(int number, int[] numbers) {
		enter("function2");

		number = 1000;
		numbers[1] = 1000;
		System.out.println(indent() + "function2의 number = " + number);

		exit("function2");
	}

	/** 새 스택 프레임이 쌓이는 모습을 출력한다. */
	private static void enter(String name) {
		System.out.println(indent() + "> " + name + " 호출: 프레임 push");
		depth++;
	}

	/** 메서드가 종료되며 스택 프레임이 제거되는 모습을 출력한다. */
	private static void exit(String name) {
		depth--;
		System.out.println(indent() + "< " + name + " 종료: 프레임 pop");
	}

	private static String indent() {
		return "  ".repeat(depth);
	}
}
