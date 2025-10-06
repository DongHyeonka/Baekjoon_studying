import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int n = friends.length;
        
        Map<String, Integer> mapToIndex = new HashMap<>();
        for (int i = 0; i < n; i++) {
            mapToIndex.put(friends[i], i);
        } // 친구를 인덱스로 설정
        
        int[][] record = new int[n][n];
        int[] giverCount = new int[n];
        int[] receiverCount = new int[n];
        
        for(String gift : gifts) {
            String[] parts = gift.split(" ");
            String giver = parts[0];
            String receiver = parts[1];
            
            int giverIndex = mapToIndex.get(giver);
            int receiverIndex = mapToIndex.get(receiver);
            
            giverCount[giverIndex]++;// 준거에 대한 개수 카운트
            receiverCount[receiverIndex]++;// 받은 거에 대한 개수 카운트
            record[giverIndex][receiverIndex]++; // 주고 받은 개수에 대한 카운트
        }
        
        int[] giftGisu = new int[n]; // 선물 지수를 보고 다음달에 선물을 받을지 카운트
        
        // 선물 지수 계산
        for(int i = 0; i < n; i++) {
            giftGisu[i] = giverCount[i] - receiverCount[i];
        }
        
        int[] result = new int[n];
        
        for(int i = 0; i < n; i++) { // 준 사람
            for(int j = i + 1; j < n; j++) { // 받은 사람
                if(record[i][j] > record[j][i]) { // i가 더 많이 준 경우
                    result[i]++;
                } else if(record[i][j] < record[j][i]) {
                    result[j]++;
                } else {
                    if(giftGisu[i] > giftGisu[j]) {
                        result[i]++;
                    } else if(giftGisu[i] < giftGisu[j]) {
                        result[j]++;
                    }
                }
            }
        }
        
        int answer = 0;
        for(int res : result) {
            if(res > answer) {
                answer = res;
            }
        }
        
        return answer;
    }
}
// 선물 지수는 이번달까지 자신이 친구들에게 준 선물의 수 - 받은 선물의 수
// 두 사람이 준 선물 지수가 같으면 주고받지 않는다.
// 주고 받은 적이 없거나 같으면 b가 a에게 선물 하나 받는다.
