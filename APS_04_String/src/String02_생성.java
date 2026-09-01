public class String02_생성 {
	public static void main(String[] args) {
		// 1. 리터럴 사용 -> String Pool의 같은 객체를 재사용
		String str1 = "Hello";
		String str2 = "Hello";
		System.out.println(str1 == str2);       // T
		System.out.println(str1.equals(str2));  // T

		// 2. new 연산자 사용 -> 힙에 새로운 객체 생성
		String str3 = new String("Hello");
		System.out.println(str1 == str3);       // F
		System.out.println(str1.equals(str3));  // T

		// 문자열 비교는 객체의 주소가 아니라 내용을 비교하는 equals() 사용!
		String input = new String("SSAFY");
		System.out.println(input.equals("SSAFY"));

	}
}
