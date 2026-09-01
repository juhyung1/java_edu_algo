import java.util.Stack;

/**
 * 스택으로 소괄호(), 중괄호{}, 대괄호[]의 짝을 검사한다.
 *
 * 핵심 아이디어
 * 1. 여는 괄호는 나중에 만날 닫는 괄호와 비교하기 위해 push한다.
 * 2. 닫는 괄호를 만나면 가장 최근의 여는 괄호를 pop하여 짝을 비교한다.
 * 3. 전체 검사가 끝났을 때 스택이 비어 있어야 모든 괄호가 짝을 찾은 것이다.
 *
 * 시간 복잡도: 문자열 길이를 N이라 할 때 O(N)
 * 공간 복잡도: 여는 괄호만 N개인 최악의 경우 O(N)
 */
public class Stack03_괄호검사 {
	public static void main(String[] args) {
		String[] examples = {
				"()()",
				"{(())}",
				"[{}()]",
				"(()",
				")(",
				"([)]",
				"if ((i == 0) && (j == 0))"
		};

		for (String expression : examples) {
			System.out.printf("%-30s -> %b%n", expression, check(expression));
		}
	}

	public static boolean check(String expression) {
		return false;
	}

}
