import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int n = id_list.length;
        
        Map<String, Integer> idToIndex = new HashMap<>();
        int[] answer = new int[n];
        
        for(int i = 0; i < n; i++) {
            idToIndex.put(id_list[i], i);// 이 시점에서 id에 대한 인덱싱화 진행
        }
        
        Map<String, HashSet<String>> record = new HashMap<>();
        
        for(String id : id_list) {
            record.put(id, new HashSet<>());   
        }
        
        for(String re : report) {
            String[] parts = re.split(" ");
            String from = parts[0];
            String to = parts[1];
            
            int fromToIndex = idToIndex.get(from);
            int toToIndex = idToIndex.get(to);
            
            record.get(to).add(from); // 시작부터 value의 값도 중복을 방지 하기에 동일한 키와 동일한 value가 못들어감
        }
        
        for(String id : id_list) {
            HashSet<String> reporters = record.get(id);
            
            if(reporters.size() >= k) {
                for(String reporter : reporters) {
                    answer[idToIndex.get(reporter)]++;
                }
            }
        }
        
        return answer;
    }
}
// 각 유저는 한 번에 한명의 유저만 신고할 수 있다.
// 신고 횟수 제한은 없다. -> 다른 유저를 계속해서 신고할 수 있다.
// 한 유저를 여러번 신고할 수 있지만 동일한 유저에 대해서는 1번만 신고 처리됨
// 다른 유저의 신고로 인해 특정 이상 신고를 먹으면 이메일 발송됨
// 