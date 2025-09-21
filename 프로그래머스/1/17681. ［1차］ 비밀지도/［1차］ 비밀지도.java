import java.util.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] map = new String[n];
        
        StringBuilder builder = new StringBuilder();
        
        for(int i = 0; i < arr1.length; i++) {
            int temp_arr1 = arr1[i];
            int temp_arr2 = arr2[i];
            
            for(int j = 0; j < arr1.length; j++) {
                int ejin1 = temp_arr1 / (int) Math.pow(2, arr1.length - 1 - j);
                int ejin2 = temp_arr2 / (int) Math.pow(2, arr2.length - 1 - j);
                if(ejin1 != 0) {
                    temp_arr1 = temp_arr1 % (int) Math.pow(2, arr1.length - 1 - j);
                } 
                if(ejin2 != 0) {
                    temp_arr2 = temp_arr2 % (int) Math.pow(2, arr2.length - 1 - j);
                }
                if(ejin1 == 1 || ejin2 == 1) {
                    builder.append("1");
                } else {
                    builder.append("0");
                }
            }
            map[i] = builder.toString();
            builder.setLength(0);
        }
        
        String[] answer = new String[n];
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(map[i].charAt(j) == '1') {
                    builder.append("#");
                } else {
                    builder.append(" ");
                }
            }
            answer[i] = builder.toString();
            builder.setLength(0);
        }
        
        return answer;
    }
}