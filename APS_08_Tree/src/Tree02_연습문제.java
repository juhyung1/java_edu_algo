import java.util.Scanner;

public class Tree02_연습문제 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int ans = 0;
			
			int V = sc.nextInt();	// 정점의 개수
			// 이후에 V-1개의 간선이 주어지는데 ... 한 줄로 주어진다
			// 간선을 보면 0번부터 시작하는 경우가 있다
			// 13	/	간선을 쭉 보니 노드 13번이 등장한다더라
			
			
			// 2차원 배열을 이용하여 저장하겠다
			int[][] tree = new int[V+1][3];	// V+1의 의미는 V번 까지는 쓰겠다
			// [0] : 왼자 , [1] : 오자, [2] : 부모
			
			for(int i = 0; i < V-1; i++) {
				// 부모-자식 순서로 입력됨
				int p = sc.nextInt();
				int c = sc.nextInt();
				
				// 이번 문제 왼자부터 채우고 오자를 채운다
				if(tree[p][0] == 0) {	// 왼자가 없다면
					tree[p][0] = c;		// 왼자 저장
				}
				else {
					tree[p][1] = c;		// 오자 저장
				}
				
				// 부모의 정보를 저장
				tree[c][2] = p;
			}	// tree 입력 완
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		}	// tc	
	}	// main
	
	
}
