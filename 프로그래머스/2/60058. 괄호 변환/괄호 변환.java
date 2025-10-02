import java.util.*;

class Solution {
    public String solution(String p) {
        if(p.isEmpty()) {
            return "";
        }
        
        int splitIndex = findSplitIndex(p);
        String u = p.substring(0, splitIndex + 1);
        String v = p.substring(splitIndex + 1);
        
        if(isCorrect(u)) {
            return u + solution(v);
        } else {
            StringBuilder builder = new StringBuilder();
            builder.append('(');
            builder.append(solution(v));
            builder.append(')');
            
            String temp = u.substring(1, u.length() - 1);
            for(char c : temp.toCharArray()) {
                if(c == '(') {
                    builder.append(')');
                } else {
                    builder.append('(');
                }
            }
            return builder.toString();
        }
    }
    
    private int findSplitIndex(String p) {
        int balance = 0;
        for(int i = 0; i < p.length(); i++) {
            if(p.charAt(i) == '(') {
                balance++;
            } else {
                balance--;
            }
            if(balance == 0) {
                return i;
            }
        }
        return -1;
    }
    
    private boolean isCorrect(String str) {
        Stack<Character> stack = new Stack<>();
        for(char c : str.toCharArray()) {
            if(c == '(') {
                stack.push(c);
            } else {
                if(stack.isEmpty() || stack.peek() != '(') {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}