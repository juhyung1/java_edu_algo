import java.util.Scanner;

public class InputTest {
	public static void main(String[] args) {
		// 표준 입출력을 위해서 Scanner 객체를 생성한다.
		Scanner sc = new Scanner(System.in);

		// 알고리즘 문제를 풀때 주로 사용하는 스캐너 메서드
		// 1. nextInt();
		// 2. next();
		// 3. nextLine(); //비권장
		// 번외) 문자 1개를 입력받는 방법 char를 받는 방법은 없다
		// 문자열로 받아서 한개를 뜯어서 char에 저장하는 형태를 이용해야함.

		// 정수를 입력 받기
//		int N = sc.nextInt(); //정수1개를 입력을 받는 메서드
//		System.out.println(N);

		// 정수가 여러개 들어온다. 공백을 이용하든 개행을 이용하든 구분 없이 입력가능
//		int R = sc.nextInt();
//		int C = sc.nextInt();
//		System.out.println(R+","+C);

		// 문자열 입력받자
//		String str = sc.next(); //공백기준으로 한단어를 입력 받는다.
//		System.out.println(str);

//		String str1 = sc.next();
//		String str2 = sc.next();
//		System.out.println(str1 + str2);

//		String str3 = sc.nextLine(); //한줄을 통으로 읽어버리니 공백과 개행을 구분한다.
//		String str4 = sc.nextLine();
//		System.out.println(str3);
//		System.out.println(str4);

		// 입력
		// 10
		// 양명균
		int age = sc.nextInt();
		sc.nextLine();
		String name = sc.nextLine();
//		String name = sc.next();

		System.out.println(name + ":" + age);

	}// main
}
