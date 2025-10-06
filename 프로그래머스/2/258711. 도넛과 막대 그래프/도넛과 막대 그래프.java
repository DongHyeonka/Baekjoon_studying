import java.util.*;

class Solution {
    public int[] solution(int[][] edges) {
        
        int maxNode = 0;
        for(int i = 0; i < edges.length; i++) {
            for(int j = 0; j < edges[i].length; j++) {
                maxNode = Math.max(maxNode, edges[i][j]);
            }
        }
        
        // 정점끼리 연결되어있는 부분을 확인해야됨 -> 들어가고 나가는걸 배열로 표시?
        int[] inDegree = new int[maxNode + 1];
        int[] outDegree = new int[maxNode + 1];
        
        for(int[] edge : edges) {
            int from = edge[0]; // 이걸 나오는 vertex로 보고
            int to = edge[1]; // 이걸 들어오는 vertex로 봐보자
            outDegree[from]++; // 나오는 값이 2 이상이면 시작 정점 또는 8자 그래프라고 알 수 잇음
            inDegree[to]++; // 들어오는게 2 이상이고 이 값이 동시에 나오는 값도 2 이상이면 8자 겠지?
        }
        
        // 시작 정점은 나가는게 2 이상이며 들어오는게 없는값인가..?
        // 막대는 근데 마지막에 더이상 연결된게 없어야하는데 이 값이 즉 inner의 값이 0인 값이 있으며 들어오는 값이 1개라면 막대겠지?
        // 팔자는 들어가는거 2이상 나가는거 2
        // 도넛은 어떻게 알지..? -> 생성 정점에서 나가는 간선 - 막대 그래프수 - 8자를 빼면 도넛의 수
        
        
        int vertexNum = 0;
        int donut = 0;
        int stick = 0;
        int eight = 0;
        
        for(int i = 1; i <= maxNode; i++) {
            if(outDegree[i] >= 2 && inDegree[i] == 0) {
                vertexNum = i;
            } else if(outDegree[i] == 0 && inDegree[i] >= 1) {
                stick++;
            } else if(outDegree[i] == 2 && inDegree[i] >= 2) {
                eight++;
            }
        }
        
        if(vertexNum != 0)
            donut = outDegree[vertexNum] - stick - eight;
        
        
        int[] answer = new int[4];
        answer[0] = vertexNum;
        answer[1] = donut;
        answer[2] = stick;
        answer[3] = eight;
        
        return answer;
    }
}
// 엣지를 받았을 때 들어오는 개수와 나가는 개수를 보고 판단
// 생성 정점 번호, 도넛 모양 그래프 수, 막대 모양 그래프 수, 8자 모양 그래프 수
// 1차원 배열로 반환