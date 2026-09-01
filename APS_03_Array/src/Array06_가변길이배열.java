public class Array06_가변길이배열 {
	public static void main(String[] args) {
		// 각 행의 길이가 달라도 된다.
		int[][] arr = {
				{ 1, 2, 3, 4 },
				{ 5, 6 },
				{ 7, 8, 9 }
		};

		// 1. 행 우선 순회: 각 행의 실제 길이를 사용
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
		}

		// 2. 열 우선 순회를 위해 가장 긴 행의 길이를 찾는다.
		int maxC = 0;
		for(int i = 0; i < arr.length; i++) {
			maxC = Math.max(maxC, arr[i].length);
		}
		
		// 2가지 방식으로 구현 가능
		// 2-1 if문을 이용해서 허락을 구하는 방식
		
		
		// 2-2 try-catch문을 이용해서 용서를 구하는 방식
		
		
		
		
	}
}
