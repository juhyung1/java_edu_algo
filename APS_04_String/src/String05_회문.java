public class String05_회문 {
	public static void main(String[] args) {
		String[] words = { "level", "racecar", "기러기", "토마토", "hello" };
		
		for(String word : words) {
//			System.out.println(reverseFor(word));
			System.out.println(reverseStringBuilder(word));
		}
	}
	
	// 뒤에서부터 읽어오자
	public static String reverseFor(String str) {
		String tmp = "";
		for(int i = str.length()-1; i >= 0; i--) {
			tmp += str.charAt(i);
		}
		
		return tmp;
	}
	
	// Stringbuilder reverse 메서드 활용
	public static String reverseStringBuilder(String str) {
		StringBuilder sb = new StringBuilder();
		sb.append(str);
		sb.reverse();
		return sb.toString();
		
		
//		return new StringBuilder(str).reverse().toString();		
	}
	
	// swap 방식
	public static String reverseSwap(String str) {
		char[] ch = str.toCharArray();
		
		int N = ch.length;
		for(int i = 0; i < N/2; i++) {
			char tmp = ch[i];
			ch[i] = ch[N-1-i];
			ch[N-1-i] = tmp;
		}
		return new String(ch);
	}
 
}
