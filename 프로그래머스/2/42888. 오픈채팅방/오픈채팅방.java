import java.util.*;

class Solution {
    private static class ActionLog {
        String uid;
        String action;
        
        public ActionLog(String uid, String action) {
            this.uid = uid;
            this.action = action;
        }
    }
    
    public String[] solution(String[] record) {
        Map<String, String> userMap = new HashMap<>();
        List<ActionLog> actionMap = new ArrayList<>();
        // 젤 중요한 부분 정보와 행위 정보를 나눠서 저장해야됨
        
        int n = record.length;
        
        for(int i = 0; i < n; i++) {
            String[] parts = record[i].split(" ");
            if(parts[0].equals("Enter")) {
                String action = parts[0];
                String id = parts[1];
                String nickname = parts[2];
                userMap.put(id, nickname);
                actionMap.add(new ActionLog(id, action));
            } else if(parts[0].equals("Leave")) {
                String action = parts[0];
                String id = parts[1];
                actionMap.add(new ActionLog(id, action));
            } else {
                String id = parts[1];
                String nickname = parts[2];
                userMap.put(id, nickname);
            }
        }
        
        List<String> answer = new ArrayList<>();
        for(ActionLog log : actionMap) {
            String nickname = userMap.get(log.uid);
            if(log.action.equals("Enter")) {
                answer.add(nickname + "님이 들어왔습니다.");
            } else {
                answer.add(nickname + "님이 나갔습니다.");
            }
        }
        
        return answer.toArray(new String[0]);
    }
}
