import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int N, int[] stages) {
        Map<Integer, Double> map = new HashMap<>();
        
        List<Integer> stage = Arrays.stream(stages)
                                    .boxed()
                                    .collect(Collectors.toList());
        
        for(int i = 1; i <= N; i++) {
            final int currentStage = i;
            long countToRemove = stage.stream().filter(s->s == currentStage).count();
            Double failure;
            if(stage.size() != 0) {
                 failure = (double) countToRemove / stage.size();
            } else {
                failure = 0.0;
            }
            map.put(i, failure);
            stage.removeIf(s -> s == currentStage);
        }
        
        List<Integer> sortedKeysByStream = map.entrySet().stream()
                .sorted(Map.Entry.<Integer, Double>comparingByValue(Comparator.reverseOrder())
                       .thenComparing(Map.Entry.comparingByKey()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        int[] answer = sortedKeysByStream.stream()
                .mapToInt(Integer::intValue)
                .toArray();
        return answer;
    }
}