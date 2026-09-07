/**
 * [비트 연산자와 비트 마스크]
 *
 * &  : 두 비트가 모두 1일 때 1
 * |  : 하나라도 1이면 1
 * ^  : 서로 다르면 1
 * ~  : 모든 비트를 반전
 * << : 왼쪽 이동, 오른쪽은 0으로 채움
 * >> : 산술 오른쪽 이동, 왼쪽은 부호 비트로 채움
 * >>>: 논리 오른쪽 이동, 왼쪽은 항상 0으로 채움
 *
 * 1 << index는 index번째 비트만 켜진 마스크다.
 * 하나의 int로 32개의 O/X 상태를 관리할 수 있다.
 */
public class 비트연산자01_기본 {
	static boolean isBitSet(int number, int index) {
		checkIndex(index);
		return (number & (1 << index)) != 0;
	}

	static int setBit(int number, int index) {
		checkIndex(index);
		return number | (1 << index);
	}

	static int clearBit(int number, int index) {
		checkIndex(index);
		return number & ~(1 << index);
	}

	static int toggleBit(int number, int index) {
		checkIndex(index);
		return number ^ (1 << index);
	}

	static String toBinary(int value, int width) {
		if (width < 1 || width > Integer.SIZE) {
			throw new IllegalArgumentException("표시할 비트 수는 1~32여야 합니다.");
		}
		String binary = Integer.toBinaryString(value);
		if (binary.length() > width) {
			binary = binary.substring(binary.length() - width);
		}
		return "0".repeat(width - binary.length()) + binary;
	}

	private static void checkIndex(int index) {
		if (index < 0 || index >= Integer.SIZE) {
			throw new IllegalArgumentException("비트 인덱스는 0~31이어야 합니다: " + index);
		}
	}

	public static void main(String[] args) {
		int first = 5;  // 0101
		int second = 3; // 0011

		System.out.println("5 & 3  = " + (first & second));
		System.out.println("5 | 3  = " + (first | second));
		System.out.println("5 ^ 3  = " + (first ^ second));
		System.out.println("~5     = " + ~first);
		System.out.println("5 << 1 = " + (first << 1));
		System.out.println("5 >> 1 = " + (first >> 1));
		System.out.println("-8 >>> 1 = " + (-8 >>> 1));

		int states = 0;
		states = setBit(states, 1);    // 1번 상태 켜기
		states = setBit(states, 3);    // 3번 상태 켜기
		states = toggleBit(states, 1); // 1번 상태 뒤집기: 켜짐 -> 꺼짐
		System.out.println("상태 비트: " + toBinary(states, 8));
		System.out.println("3번 상태: " + isBitSet(states, 3));
	}
}
