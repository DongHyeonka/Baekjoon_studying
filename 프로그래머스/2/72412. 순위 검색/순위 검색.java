import java.util.*;

class Solution {
    
    Map<String, List<Integer>> allInfo = new HashMap<>();
    
    public int[] solution(String[] info, String[] query) {
        
        for(String s : info) {
            dfs("", 0, s.split(" "));
        }
        
        for(String key : allInfo.keySet()) {
            Collections.sort(allInfo.get(key));
        }
        
        int n = query.length;
        int[] answer = new int[n];
        
        for(int i = 0; i < n; i++) {
            String[] condition = query[i].replaceAll(" and ", " ").split(" ");
            String key = condition[0] + condition[1] + condition[2] + condition[3];
            
            int score = Integer.parseInt(condition[4]);
            
            answer[i] = binarySearch(key, score);
        }
        
        return answer;
    }
    
    private int binarySearch(String key, int score) {
        if(!allInfo.containsKey(key)) {
            return 0;
        }
        
        List<Integer> scores = allInfo.get(key);
        int start = 0;
        int end = scores.size() - 1;
        
        while(start <= end) {
            int mid = (start + end) / 2;
            if(scores.get(mid) < score) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        
        return scores.size() - start;
    }
    
    private void dfs(String key, int depth, String[] infoParts) {
        if(depth == 4) {
            if(!allInfo.containsKey(key)) {
                allInfo.put(key, new ArrayList<>());
            }
            allInfo.get(key).add(Integer.parseInt(infoParts[4]));
            return;
        }
        
        dfs(key + infoParts[depth], depth + 1, infoParts);
        dfs(key + "-", depth + 1, infoParts);
    }
}