import java.util.*;

class Solution {
    public int solution(String s) {
        
        Map<String, String> map = new HashMap<>();
        map.put("zero", "0");
        map.put("one", "1");
        map.put("two", "2");
        map.put("three", "3");
        map.put("four", "4");
        map.put("five", "5");
        map.put("six", "6");
        map.put("seven", "7");
        map.put("eight", "8");
        map.put("nine", "9");
        
        int n = s.length();
        
        StringBuilder builder = new StringBuilder();
        StringBuilder answer = new StringBuilder();
        
        for(int i = 0; i < n; i++) {
            char se = s.charAt(i);
            if(Character.isDigit(se)) {
                answer.append(se);
            } else {
                builder.append(se);
                String key = builder.toString();
                if(map.containsKey(key)) {
                    answer.append(map.get(key));
                    builder.setLength(0);
                }
            }
        }
        
        return Integer.parseInt(answer.toString());
    }
}