
public class 패턴매칭_01_KMP {

	public static void main(String[] args) {
		String text = "ABABABACABAABABACACA";
		String pattern = "ABABACA";

		kmp(text, pattern);
	}
	
	// 패턴을 i까지 잘라서 만든 부분 문자열의 접두사와 접미사가 일치하는 최대
	static int[] getPi(String pt) {
		// 실패 함수, 점프테이블
		int[] pi = new int[pt.length()];
		
		int j = 0; // 길이 저장
		for(int i = 1; i < pt.length(); i++) {
			// 일치하지 않는다면
			while(j > 0 && pt.charAt(i) != pt.charAt(j)) {
				j = pi[j - 1];
			}		
			
			
			// 일치 한다면
			if(pt.charAt(i) == pt.charAt(j)) {
				pi[i] = ++j;
			}
		}
		
		// 실은 3중 for문으로 작성할 수 있지만...
		
		return pi;
	} // getPi
	
	// t : 본문, p : 패턴
	static void kmp(String t, String p) {
		int[] pi = getPi(p); // 실패함수 가져왔다
		
		int j = 0; // 패턴의 인덱스
		for(int i = 0; i < t.length(); i++) {
			// 1. 다를 때
			while(j > 0 && t.charAt(i) != p.charAt(j)) {
				j = pi[j - 1];
			}
			
			// 2. 같을 때
			if(t.charAt(i) == p.charAt(j)) {
				// 2-1 j가 끝에 도달했다면
				if(j == p.length()-1) {
					// 도달했다라고 하는 것은 찾았어 하고 종료해도됨
					System.out.println("찾았다! " + (i-j) + "에서 찾았다!");
					j = pi[j];				
				}
				// 2-2. j가 중간이라면
				else {
					++j;
				}
				
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
