/**
 * 그래프의 간선을 (시작 정점, 끝 정점, 가중치) 객체 배열에 그대로 저장한다.
 *
 * <p>공간은 간선 수 E에 비례한다. 전체 간선을 순서대로 검사하는 알고리즘에는
 * 편리하지만, 특정 정점의 이웃을 찾으려면 모든 간선을 훑어야 하므로 O(E)가 든다.
 * 무향 그래프라도 간선 자체는 한 번만 저장하고, 사용할 때 양쪽 끝을 동일하게 본다.</p>
 */
public class 그래프표현_03_간선배열 {
	static class Edge {
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		
	}


    public static void main(String[] args) {
        int[][] rawEdges = {
                {0, 1, 1}, {0, 2, 1}, {0, 5, 1}, {0, 6, 1},
                {4, 3, 1}, {5, 3, 1}, {5, 4, 1}, {6, 4, 1}
        };
        
        // 정점의 수, 간선의 수가 주어지고ㅓ
        // 이후에 간선들이 쭉 나열된다
        int E = 8;
        
        Edge[] edges = new Edge[E];
        
        for(int i = 0; i < E; i++) {
        	int from = rawEdges[i][0];
        	int to = rawEdges[i][1];
        	int weight = rawEdges[i][2];
        	edges[i] = new Edge(rawEdges[i][0], rawEdges[i][1], rawEdges[i][2]);
        }
    }
}
