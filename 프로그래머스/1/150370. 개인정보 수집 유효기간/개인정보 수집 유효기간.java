import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        Map<String, Integer> termMap = new HashMap<>(); 
        for(String term : terms) {
            String[] termsDetail = term.split(" ");
            String firstTerms = termsDetail[0];
            int secondTerms = Integer.parseInt(termsDetail[1]);
            termMap.put(firstTerms, secondTerms);
        }
        
        int todayDays = dateToDay(today);
        
        int n = privacies.length;    
        
        List<Integer> answer = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            String[] parts = privacies[i].split(" ");
            String collectDate = parts[0];
            String termType = parts[1];
            
            int collectDays = dateToDay(collectDate);
            int validMonths = termMap.get(termType);
            int expireDays = addMonths(collectDays, validMonths);
            
            if(todayDays >= expireDays) {
                answer.add(i + 1);
            }
            
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
    
    private int dateToDay(String date) {
        String[] parts = date.split("\\.");
        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);
        
        return year * 12 * 28 + (month - 1) * 28 + (day - 1);
    }
    
    private int addMonths(int days, int months) {
        return days + months * 28;
    }
}