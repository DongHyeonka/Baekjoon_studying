import java.util.*;

class Solution {
    String STR1;
    String STR2;
    
    public int solution(String str1, String str2) {
        this.STR1 = str1.toLowerCase();
        this.STR2 = str2.toLowerCase();
        
        List<String> str1List = new ArrayList<>();
        List<String> str2List = new ArrayList<>();
        
        int n1 = str1.length();
        int n2 = str2.length();
        
        for(int i = 0; i + 1 < n1; i++) {
            String subStr1 = STR1.substring(i, i+2);
            if(subStr1.matches("^[a-z]{2}$")) {
                str1List.add(subStr1);
            }
        }
        
        for(int i = 0; i + 1 < n2; i++) {
            String subStr2 = STR2.substring(i, i+2);
            if(subStr2.matches("^[a-z]{2}$")) {
                str2List.add(subStr2);
            }
        }
        
        int sn1 = str1List.size();
        int sn2 = str2List.size();
        
        double usado;
        
        if(sn1 == 0 || sn2 == 0) {
            usado = 1;
        }
        
        List<String> crosList = new ArrayList<>();
        List<String> sumList = new ArrayList<>(str2List);
        
        for(String s : str1List) {
            if(sumList.remove(s)) {
                crosList.add(s);
            }
        }
        
        int union = sn1 + sn2 - crosList.size();
        
        if(union == 0) {
            usado = 1;
        } else {
           usado = (double) crosList.size() / union;
        }
        
        int answer = (int) (usado * 65536);
        return answer;
    }
}
// 문제의 입력에 대한 값을 2글자씩 끈기 -> 
// 모두 소문자로 변환 후 진행
// 이후 ab+와 같은 값이 들어오면 + 버리기
// 유사도 출력시 65536을 곱한 값 -> 소수점 수 버리기