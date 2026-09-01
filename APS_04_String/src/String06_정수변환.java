public class String06_정수변환 {
	public static void main(String[] args) {
		// Java에서 제공하는 메서드
		String tmp = "-1234";
		int num = Integer.parseInt(tmp);
		System.out.println(num); // 숫자
		
		String strNum = String.valueOf(num);
		System.out.println(strNum); // 문자열
		
		
		String strNum2 = 123+""; // 심플한 방법
//		System.out.println(1234+"");	// 문자열
	}

	// atoi: 문자열 -> 정수
	public static int atoi(String strNumber) {
		return 0;
	}

	// itoa: 정수 -> 문자열
	public static String itoa(int number) {
		return null;
	}
}
