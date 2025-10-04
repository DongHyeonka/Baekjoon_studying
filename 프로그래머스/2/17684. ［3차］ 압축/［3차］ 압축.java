import java.util.*;

class Solution {
    public int[] solution(String msg) {
        Map<String, Integer> dict = new HashMap<>();
        
        int nextIndex = 1;
        for(char c = 'A'; c <= 'Z'; c++) {
            dict.put(String.valueOf(c), nextIndex++);
        }
        
        int n = msg.length();
        int i = 0;
        
        List<Integer> answer = new ArrayList<>();
        
        while(i < n) {
            String w = "";
            int j = i;
            
            while(j < n && dict.containsKey(msg.substring(i, j + 1))) {
                j++;          
            }
            w = msg.substring(i, j);
            
            answer.add(dict.get(w));
            
            if(j < n) {
                char c = msg.charAt(j);
                dict.put(w + c, nextIndex++);
            }
            
            i += w.length();
        }
        
        return answer.stream()
                    .mapToInt(Integer::intValue)
                    .toArray();
    }
}