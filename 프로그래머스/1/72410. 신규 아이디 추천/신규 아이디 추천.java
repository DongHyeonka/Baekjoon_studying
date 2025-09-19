import java.util.*;

class Solution {
    public String solution(String new_id) {
        int n = new_id.length();
        
        StringBuilder builder = new StringBuilder();
        
        // 1단계 대문자가 있으면 소문자로 바꾸기
        for(int i = 0; i < n; i++) {
            char ch = new_id.charAt(i);
            
            if(Character.isUpperCase(ch)) {
                builder.append(Character.toLowerCase(ch));
            } else {
                builder.append(ch);   
            }
        }
        
        String new_id_1 = builder.toString();
        builder.setLength(0);
        
        // 2단계 알파벡 소문자, 숫자, 빼기, 밑줄, 마침표를 제외한 모든 문자 제거
        for(int i = 0; i < new_id_1.length(); i++) {
            char ch = new_id_1.charAt(i);
            if(Character.isLowerCase(ch) || Character.isDigit(ch) || ch == '-' || ch == '_' || ch == '.') {
                builder.append(ch);
            }
        }
        
        String new_id_2 = builder.toString();
        builder.setLength(0);
        
        // 3단계 마침표가 2번 이상 연속된 부분을 하나로 치환
        for (int i = 0; i < new_id_2.length(); i++) {
            char ch = new_id_2.charAt(i);
            if(ch == '.' && builder.length() > 0 && builder.charAt(builder.length() - 1) == '.') {
                continue;
            }
            builder.append(ch);
        }
        
        String new_id_3 = builder.toString();
        builder.setLength(0);
        
        // 4단계 . 처음과 끝 제거
        for (int i = 0; i < new_id_3.length(); i++) {
            char ch = new_id_3.charAt(i);
            if(ch == '.' && i == 0) {
                continue;
            }
            if(ch == '.' && i == new_id_3.length() - 1) {
                continue;
            }
            builder.append(ch);
        }
        
        String new_id_4 = builder.toString();
        
        if(new_id_4.length() == 0) {
            new_id_4 = "a";   
        }
            
        builder.setLength(0);
        builder.append(new_id_4);
        
        if(builder.length() >= 16) {
            builder.setLength(15);
        }
        
        while(builder.length() > 0 && builder.charAt(builder.length() - 1) == '.') {
            builder.setLength(builder.length() - 1);
        }
        
        while(builder.length() <= 2) {
            if(builder.length() == 0) {
                builder.append('a');
            } else {
                builder.append(builder.charAt(builder.length() - 1));   
            }
        }
        
        return builder.toString();
    }
}