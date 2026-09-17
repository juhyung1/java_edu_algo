
public class 분할정복01_거듭제곱 {

	public static void main(String[] args) {

	}

	// C : 밑
	// N : 지수(음수는 없다고 가정)

	static int pow1(int C, int N) {
		int result = 1;
		for (int i = 0; i < N; i++) {
			result *= C;
		}
		return result;
	}

	// 재귀함수 -> 반복문이나 다를바 없다
	static int pow2(int C, int N) {
		if (N == 0)
			return 1;
		return C * pow2(C, N - 1);
	}

	static int pow3(int C, int N) {
		if (N == 0)
			return 1;
		if (N % 2 == 1) {
			return pow3(C, (N - 1) / 2) * pow3(C, (N - 1) / 2);
		} else {

			return pow3(C, N / 2) * pow3(C, N / 2);
		}
	}

	static int pow4(int C, int N) {
		if (N == 0)
			return 1;
		
		int tmp = pow4(C, N/2);
		if(N % 2 == 1) return tmp * tmp * C;
		return tmp*tmp;
		

	}

}
