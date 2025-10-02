import java.util.*;

class Solution {
    public long solution(String expression) {
        char[][] priority = {
            {'*', '+', '-'},
            {'*', '-', '+'},
            {'+', '*', '-'},
            {'+', '-', '*'},
            {'-', '+', '*'},
            {'-', '*', '+'},
        };
        
        int n = expression.length();
        
        List<Long> originalNums = new LinkedList<>();
        List<Character> originalOps = new LinkedList<>();
        
        String temp = "";
        
        for(int i = 0; i < n; i++) {
            char ch = expression.charAt(i);
            if(Character.isDigit(ch)) {
                temp += ch;
            } else {
                originalNums.add(Long.parseLong(temp));
                originalOps.add(ch);
                temp = "";
            }
        }
        
        originalNums.add(Long.parseLong(temp));
        
        long max_abs = 0;
        
        for(int i = 0; i < priority.length; i++) {
            int pn = priority[i].length;
            
            List<Long> nums = new ArrayList<>(originalNums);
            List<Character> ops = new ArrayList<>(originalOps);
            
            for(int j = 0; j < pn; j++) {
                
                for(int k = 0; k < ops.size(); k++) {
                    if (ops.get(k) == priority[i][j]) {
                        long num1 = nums.get(k);
                        long num2 = nums.get(k + 1);
                        long result = calculate(num1, num2, ops.get(k));

                        nums.remove(k + 1);
                        nums.set(k, result);
                        ops.remove(k);
                        k--;
                    }
                }
            }
            
            long max = Math.abs(nums.get(0));
            if(max > max_abs) {
                max_abs = max;
            }
        }
        
        return max_abs;
    }
    
    private long calculate(long num1, long num2, char ops) {
        if(ops == '*') {
            return num1 * num2;
        } else if(ops == '+') {
            return num1 + num2;
        } else {
            return num1 - num2;
        }
    }
}