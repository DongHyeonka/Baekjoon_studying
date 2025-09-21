import java.util.*;

class Solution {
    public int solution(String dartResult) {
        int n = dartResult.length();
        
        int answer = 0;
        
        Stack<Integer> calculator = new Stack<>();
        
        for(int i = 0; i < n; i++) {
            char currentChar = dartResult.charAt(i);
            
            if(Character.isDigit(currentChar)) {
                int score = 0;
                
                if(currentChar == '1' && dartResult.charAt(i + 1) == '0') {
                    score = 10;
                    i++;
                } else {
                    score = Character.getNumericValue(currentChar);
                }
                calculator.push(score);
            } else {
                int temp;
                if(currentChar == 'S') {
                    continue;
                } else if(currentChar == 'D') {
                    temp = calculator.pop();
                    calculator.push((int) Math.pow(temp, 2));
                } else if(currentChar == 'T') {
                    temp = calculator.pop();
                    calculator.push((int) Math.pow(temp, 3));
                } else if(currentChar == '*') {
                    int current = calculator.pop();
                    if(!calculator.isEmpty()) {
                        int before = calculator.pop();
                        calculator.push(before * 2);   
                    }
                    calculator.push(current * 2);
                } else if(currentChar == '#') {
                    temp = calculator.pop();
                    calculator.push(temp * (-1));
                }
            }
        }
        
        while(!calculator.isEmpty()) {
            answer += calculator.pop();
        }
        
        return answer;
    }
}