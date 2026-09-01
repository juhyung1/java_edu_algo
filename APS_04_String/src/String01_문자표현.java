public class String01_문자표현 {
	public static void main(String[] args) {
		// char 2byte (기본 자료형) / Character(참조 자료형)
		char ch = 'A';
		System.out.println(ch);
		int i = ch;
		System.out.println(i);
		
		System.out.println(ch+1); // 'B' 를 기대했지만 정수형으로 형변환
		
		System.out.println((char)(ch+1));
		
		
		char ch2 = 'A' + 1;
		System.out.println(ch2);
		
		
		char ch3 = '5'; // 숫자 5로 바꾸고싶다
		int i2 = (int)ch3;	// 아스키코드의 값이 출력이된다.
		System.out.println(i2-48);	// 문자 '0'이 48이라서 빼면 숫자5가 나옴
		
		System.out.println('5'-'0');
		
		
		
		
		
	}
}
