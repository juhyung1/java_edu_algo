import java.util.Arrays;

public class String03_메서드 {
	public static void main(String[] args) {
		String str = "Hello World";

		System.out.println(str.length());              	// 11
		System.out.println(str.charAt(1));              // e
		System.out.println(str.substring(0, 5));        // Hello
		System.out.println(str.contains("World"));      // true
		System.out.println(str.equals("hello world")); 	// false
		System.out.println(str.indexOf("World"));       // 6
		System.out.println(str.indexOf("SSAFY"));       // -1
		
		String str2 = "one,tow,three";
		String[] strArr = str2.split(",");
		System.out.println(Arrays.toString(strArr));
		
		char[] charArr = str2.toCharArray();
		System.out.println(Arrays.toString(charArr));

	}
}
