import java.util.*;

class Solution {
    public static class File implements Comparable<File> {
        String fileName;
        String head;
        int number;
        int index;
        
        public File(String fileName, int index) {
            this.fileName = fileName;
            this.index = index;
            
            int headIndex = 0;
            while(headIndex < fileName.length() && !Character.isDigit(fileName.charAt(headIndex))) {
                headIndex++; // 이 시점에서 값이2가 되려나? 
            }
            this.head = fileName.substring(0, headIndex);
            
            int numberIndex = headIndex;
            while(numberIndex < fileName.length() && Character.isDigit(fileName.charAt(numberIndex))) {
                numberIndex++;
            }
            this.number = Integer.parseInt(fileName.substring(headIndex, numberIndex));
        }
        
        @Override
        public int compareTo(File other) {
            String thisheader = this.head.toLowerCase();
            String otherheader = other.head.toLowerCase();
            
            int headCompareResult = thisheader.compareTo(otherheader);
            if(headCompareResult != 0) {
                return headCompareResult;
            }
            
            int numberCompareResult = Integer.compare(this.number, other.number);
            if(numberCompareResult != 0) {
                return numberCompareResult;
            }
            
            return Integer.compare(this.index, other.index);
        }
    }
    
    public String[] solution(String[] files) {
        int n = files.length;
        
        List<File> fileList = new ArrayList<>();
        
        for(int i = 0; i < n; i++) {
            fileList.add(new File(files[i], i));
        }
        
        Collections.sort(fileList);
        
        String[] answer = new String[n];
        for(int i = 0; i < fileList.size(); i++) {
            answer[i] = fileList.get(i).fileName;
        }
        return answer;
    }
}