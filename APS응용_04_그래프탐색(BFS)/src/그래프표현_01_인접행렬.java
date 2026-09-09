import java.util.Arrays;

/**
 * 그래프의 연결 관계를 인접 행렬로 표현한다.
 *
 * <p>adj[a][b]가 true이면 정점 a와 b 사이에 간선이 있다는 뜻이다.
 * 무향 그래프는 a -> b와 b -> a를 모두 저장하므로 행렬이 대각선을 기준으로 대칭이다.</p>
 *
 * <p>장점: 두 정점의 연결 여부를 O(1)에 확인한다.
 * 단점: 간선이 적어도 항상 O(V^2) 공간이 필요하고, 한 정점의 이웃을 찾을 때
 *       행 전체 V칸을 살펴봐야 한다.</p>
 */
public class 그래프표현_01_인접행렬 {

    public static void main(String[] args) {
        int V = 7; // 정점 번호: 0~6
        int[][] edges = {
                {0, 1}, {0, 2}, {0, 5}, {0, 6},
                {3, 4}, {3, 5}, {4, 5}, {4, 6}
        };
        
        int[][] adjArr = new int[V + 1][V + 1];
        for(int[] edge : edges) {
        	int from = edge[0];
        	int to = edge[1];
        	
        	adjArr[from][to] = 1; // 유,무향 전부 간선을 표기(가중치라면 해당 가중치 값으로)
        	adjArr[to][from] = 1; // 무향이면 필수        	
        	
        }
        
        for(int[] tmp : adjArr) {
        	System.out.println(Arrays.toString(tmp));
        }

    }

}
