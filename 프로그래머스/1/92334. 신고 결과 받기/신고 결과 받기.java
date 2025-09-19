import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int n = id_list.length;
        
        //1. 이름을 인덱스로 맵핑
        Map<String, Integer> id_map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            id_map.put(id_list[i], i);
        }
        
        int report_count = report.length;
        
        // 신고 기록을 중복제거를 위해서 0 또는 1만 저장
        int[][] reportRecord = new int[n][n];
        
        for(int i = 0; i < report_count; i++) {
            String[] parts = report[i].split(" ");
            int reporter = id_map.get(parts[0]);
            int reported = id_map.get(parts[1]);
            
            reportRecord[reporter][reported] = 1;
        }
        
        int[] reported_count = new int[n];
        
        //각 사용자가 받은 신고 횟수 저장
        for(int j = 0; j < n; j++) { // 신고 받는 사람
            for(int i = 0; i < n; i++) { // 주체가 안에 신고자
                reported_count[j] += reportRecord[i][j];
            }
        }
        
        // K번 이상 신고를 받으면 정지 -> 이메일 보내기위한 검증
        boolean[] suspend = new boolean[n];
        for(int i = 0; i < n; i++) {
            if(reported_count[i] >= k) {
                suspend[i] = true;
            }
        }
        
        int[] answer = new int[n]; // 이메일 카운트 계산
        
        for (int i = 0; i < n; i++) {// 신고자에게 메일을 카운트해야되기에 
            for(int j = 0; j < n; j++) {
                if(reportRecord[i][j] == 1 && suspend[j]) {
                    answer[i]++;
                }   
            }   
        }
        
        return answer;
    }
}