import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        Map<String, Integer> kakaoMbti = new HashMap<>();
        kakaoMbti.put("R", 0);
        kakaoMbti.put("T", 0);
        kakaoMbti.put("C", 0);
        kakaoMbti.put("F", 0);
        kakaoMbti.put("J", 0);
        kakaoMbti.put("M", 0);
        kakaoMbti.put("A", 0);
        kakaoMbti.put("N", 0);
        
        int n = choices.length;
        for(int i = 0; i < n; i++) {
            String firstType = String.valueOf(survey[i].charAt(0));
            String secondType = String.valueOf(survey[i].charAt(1));
            
            switch(choices[i]) {
                case 1:
                    kakaoMbti.put(firstType, kakaoMbti.get(firstType) + 3);
                    break;
                case 2:
                    kakaoMbti.put(firstType, kakaoMbti.get(firstType) + 2);
                    break;
                case 3:
                    kakaoMbti.put(firstType, kakaoMbti.get(firstType) + 1);
                    break;
                case 4:
                    break;
                case 5:
                    kakaoMbti.put(secondType, kakaoMbti.get(secondType) + 1);
                    break;
                case 6:
                    kakaoMbti.put(secondType, kakaoMbti.get(secondType) + 2);
                    break;
                case 7:
                    kakaoMbti.put(secondType, kakaoMbti.get(secondType) + 3);
                    break;
                default:
                    break;
            }
        }
        
        StringBuilder answer = new StringBuilder();
        
        answer.append(kakaoMbti.get("R") >= kakaoMbti.get("T") ? "R" : "T");
        answer.append(kakaoMbti.get("C") >= kakaoMbti.get("F") ? "C" : "F");
        answer.append(kakaoMbti.get("J") >= kakaoMbti.get("M") ? "J" : "M");
        answer.append(kakaoMbti.get("A") >= kakaoMbti.get("N") ? "A" : "N");
        
        return answer.toString();
    }
}