import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int mock = n;
        int namoji = 0;
        
        Stack<Integer> jinsu = new Stack<>();
        StringBuilder builder = new StringBuilder();
        
        while(mock > 0) {
            namoji = mock % k;
            mock = mock / k;
            jinsu.push(namoji);
        }
        
        while(!jinsu.isEmpty()) {
            String num = jinsu.pop().toString();
            builder.append(num);
        }
        
        String convertedNum = builder.toString();
        
        String[] numbers = convertedNum.split("0");
        
        int answer = findsosu(numbers);
        
        return answer;
    }
    
    private int findsosu(String[] numbers) {
        int count = 0;
        
        for(String s : numbers) {
            if(s == null || s.isEmpty()) {
                continue;
            }
            
            long number = Long.parseLong(s);
            if(isPrime(number)) {
                count++;
            }
        }
        
        return count;
    }
    
    private boolean isPrime(long num) {
        if(num == 0 || num == 1) {
            return false;
        }
        
        if(num == 2) return true;
        
        if(num % 2 == 0) {
            return false;
        }
        
        for(long i = 3; i * i <= num; i+=2) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
// 437674 -> (3진수) 211020101011
// 
