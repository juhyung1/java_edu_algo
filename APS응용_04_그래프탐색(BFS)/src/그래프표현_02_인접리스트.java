import java.util.ArrayList;
import java.util.List;

/**
 * 각 정점이 자신의 이웃 목록만 보관하는 인접 리스트 표현이다.
 *
 * <p>정점 V개와 간선 E개인 무향 그래프에서 공간 복잡도는 O(V + E)이다.
 * 실제 문제처럼 정점은 많고 간선은 듬성한 희소 그래프에 가장 흔히 사용한다.
 * 특정 정점의 모든 이웃을 살펴보는 시간은 그 정점의 차수에 비례한다.</p>
 */
public class 그래프표현_02_인접리스트 {

    public static void main(String[] args) {
    	int V = 7; // 정점 번호: 0~6
    	
        int[][] edges = {
                {0, 1}, {0, 2}, {0, 5}, {0, 6},
                {3, 4}, {3, 5}, {4, 5}, {4, 6}
        };
        
        List<Integer> [] adjList = new ArrayList[V];
        for(int i = 0; i < V; i++) {
        	adjList[i] = new ArrayList<>();
        }
        
        for(int[] edge : edges) {
        	int from = edge[0];
        	int to = edge[1];
        	
        	adjList[from].add(to);
        	adjList[to].add(from);
        }
        
        for(List<Integer> list: adjList) {
        	System.out.println(list);
        }
        
        
    }

}
