import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int n = board.length;
        
        Map<Integer, Stack<Integer>> map = new HashMap<>();
        for(int i = 1; i <= n; i++) {
            map.put(i, new Stack<>());
        }
        
        for(int i = n - 1; i >= 0; i--) {
            for(int j = 1; j <= n; j++) {
                if(board[i][j - 1] != 0) {
                    map.get(j).push(board[i][j - 1]);   
                }
            }
        }
        
        Stack<Integer> result = new Stack<>();
        int answer = 0;
        
        for(int move : moves) {
            if (map.get(move).isEmpty()) {
                continue;
            }
            int doll = map.get(move).pop();
            
            if(!result.isEmpty() && result.peek() == doll) {
                result.pop();
                answer += 2;
            } else {
                result.push(doll);   
            }
        }
        return answer;
    }
}