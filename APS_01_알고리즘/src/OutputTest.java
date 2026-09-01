
public class OutputTest {
	public static void main(String[] args) {
		
		System.out.print("Hello");
		System.out.print("Hello\n");
		System.out.print("Hello");
		
		System.out.println("World");
		System.out.println("World");
		System.out.println("World");
		
		//escape 문자 \n \t \" \\
		
		//포맷방식
//		System.out.printf();
		//, 이후에 들어갈 변수나 리터럴(값) 순서대로 적는다.
		System.out.printf("%d\n", 10);
		System.out.printf("%d %d\n", 10, 20);
		
		System.out.printf("%o\n", 10); //8진수
		System.out.printf("%x\n", 10); //16진수(소문자)
		System.out.printf("%X\n", 10); //16진수(대문자)
		
		System.out.printf("%4d%4d\n", 10, 20); //4칸확보 오른쪽부터
		System.out.printf("%-4d%-4d\n", 10, 20); //4칸확보 왼쪽부터
		System.out.printf("%04d%04d\n", 11, 22); //4칸확보 오른쪽부터 채울거고 비어있는칸은 0으로 채운다.
		
		System.out.printf("%f\n", 3.14159); //실수를 출력
		System.out.printf("%.3f\n", 3.14159); //실수를 출력 .?자리까지 반올림하여 표현 하겠다.
		
		System.out.printf("%s\n", "안녕하세요.");
		System.out.printf("%c\n", 'A');
		
		
		
		
		
		
		
		
		
	}
}
