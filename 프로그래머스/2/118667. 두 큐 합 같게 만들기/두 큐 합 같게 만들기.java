import java.util.*;

class Solution {
    
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        long sum1 = 0;
        long sum2 = 0;
        
        for(int value : queue1) {
            sum1 += value;
            q1.offer(value);
        }
        
        for(int value : queue2) {
            sum2 += value;
            q2.offer(value);
        }
        
        long total = sum1 + sum2;
        
        if(total % 2 != 0) {
            return -1;
        }
        
        long targetTotal = total / 2;
        
        int answer = 0;
        
        int maxCount = (queue1.length + queue2.length) * 2;
        
        while(sum1 != targetTotal) {
            if(answer > maxCount) {
                return -1;
            }
            
            if(sum1 > targetTotal) {
                int value = q1.poll();
                q2.offer(value);
                sum1 -= value;
                sum2 += value;
            } else {
                int value = q2.poll();
                q1.offer(value);
                sum2 -= value;
                sum1 += value;
            }
            answer++;
        }
        
        return answer;
    }
}