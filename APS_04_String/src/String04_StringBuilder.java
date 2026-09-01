public class String04_StringBuilder {
	public static void main(String[] args) {
		// String은 이어 붙일 때마다 새로운 객체가 만들어진다.
		String str = "";
		for (int i = 0; i < 5; i++) {
			str += i;
		}
		System.out.println(str);

		// StringBuilder는 하나의 객체를 계속 수정한다.
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 5; i++) {
			sb.append(i);
		}
		System.out.println(sb);
	}
}
