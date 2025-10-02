import java.util.*;

class Solution {
    public int[] solution(String s) {
        int n = s.length();

        Map<Integer, Integer> map = new HashMap<>();
        
        String temp = "";
        
        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            
            if(Character.isDigit(ch)) {
                temp += ch;
            } else {
                if(temp != "") {
                    int stringToInt = Integer.parseInt(temp);
                    map.put(stringToInt, map.getOrDefault(stringToInt, 0) + 1);
                    temp = "";
                }
            }
        }
        
        int[] answer = map.entrySet().stream()
                            .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed()
                                   .thenComparing(Map.Entry.comparingByKey()))
                            .map(Map.Entry::getKey)
                            .mapToInt(Integer::intValue)
                            .toArray();
        
        return answer;
    }
}