import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int n = privacies.length;
        
        List<Integer> answer = new ArrayList<>();
        
        long currentDay = calculateDay(today); // 일의 수를 반환하겠지?
        
        for(int i = 0; i < n; i++) {
            String[] privacyParts = privacies[i].split(" "); // 일단 분리
            String privacyDay = privacyParts[0];
            String privacyKindTerm = privacyParts[1];
            
            long privacyToDay = calculateDay(privacyDay);
            for(String term : terms) {
                String[] termParts = term.split(" ");
                String kindTerm = termParts[0];
                String period = termParts[1];
                long periodToLong = Long.parseLong(period);
                
                if(privacyKindTerm.equals(kindTerm)) {
                    privacyToDay = privacyToDay + periodToLong * 28;
                    if(currentDay >= privacyToDay) {
                        answer.add(i + 1);
                    }
                }
            }
        }
        
        return answer.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
    
    private long calculateDay(String day) {
        String[] parts = day.split("\\."); // 이거 기억하자 .은 정규식 표현이라 분리가 안된다 [] 로 감싸주든 \\로 앞에 두든
        long year = Long.parseLong(parts[0]);
        long month = Long.parseLong(parts[1]);
        long days = Long.parseLong(parts[2]);
        
        return year * 12 * 28 + month * 28 + days; //총 day 수를 반환함 겁나 커질 것을 대비해 long으로 반환
    }
}
// 시간을 전부 일로 바꿔서 계산