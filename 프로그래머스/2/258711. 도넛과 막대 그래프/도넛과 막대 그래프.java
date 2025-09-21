import java.util.*;

class Solution {
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];
        
        Map<Integer, Integer> indegree = new HashMap<>();
        Map<Integer, Integer> outdegree = new HashMap<>();
        
        for(int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            outdegree.put(from, outdegree.getOrDefault(from, 0) + 1);
            indegree.put(to, indegree.getOrDefault(to, 0) + 1);
        }
        
        int createdVertex = 0;
        int donutCount = 0;
        int barCount = 0;
        int eightCount = 0;
        
        Set<Integer> vertices = new HashSet<>(outdegree.keySet());
        vertices.addAll(indegree.keySet());
        
        for(int vertex : vertices) {
            int in = indegree.getOrDefault(vertex, 0);
            int out = outdegree.getOrDefault(vertex, 0);
            
            if(in == 0 && out >= 2) {
                createdVertex = vertex;
            } else if(out == 0) {
                barCount++;
            } else if(in >= 2 && out == 2) {
                eightCount++;
            }
        }
        
        int totalGraphs = outdegree.getOrDefault(createdVertex, 0);
        donutCount = totalGraphs - barCount - eightCount;
        
        answer[0] = createdVertex;
        answer[1] = donutCount;
        answer[2] = barCount;
        answer[3] = eightCount;
        
        return answer;
    }
}