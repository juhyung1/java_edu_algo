import java.util.Arrays;

/**
 * [중첩 반복문으로 만드는 부분집합]
 *
 * 원소마다 '포함하지 않음(0)'과 '포함함(1)' 두 경우를 반복문으로 표현한다.
 * 흐름이 눈에 보이므로 처음 개념을 익힐 때 좋지만, 원소가 N개면 반복문도 N개가 필요하다.
 * 이 예제는 그 한계를 분명히 보이기 위해 PDF와 같이 원소 4개 전용으로 작성한다.
 */
public class 부분집합01_반복문 {
	public static void main(String[] args) {
		String[] ingredients = { "단무지", "햄", "오이", "지단" };
		
		int[] sel = new int[ingredients.length];
		// boolean[] sel 이면 넣었다 안넣었다 true/false -> 추후에
		
		
		for(int a = 0; a < 2; a++) {
			sel[0] = a;
			for(int b = 0; b < 2; b++) {
				sel[1] = b;
				for(int c = 0; c <= 1; c++) {
					sel[2] = c;
					for(int d = 0; d <= 1; d++) {
						sel[3] = d;
						// 재료를 모두 골랐으니 김밥을 만들어서 확인해보자
						
						
//						for(int i = 0; i < ingredients.length; i++) {
//							if(sel[i] == 1) {
//								System.out.print(ingredients[i]);
//							}
//							System.out.println(":김밥");
//						}
						
						System.out.println(Arrays.toString(sel));
						
						
						
					}	// 네 번째 재료를 고려
				}	// 세 번째 재료를 고려
			}	// 두 번째 재료를 고려
		}	// 첫 번째 재료를 고려
		
		
		
	}
}
