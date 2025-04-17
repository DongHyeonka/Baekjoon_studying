import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bufferedReader.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        
        String dna = bufferedReader.readLine();
        
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int[] minCounts = new int[4];
        for (int i = 0; i < 4; i++) {
            minCounts[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        
        char[] init = {'A', 'C', 'G', 'T'};
        Map<Character, Integer> requiredCounts = new HashMap<>();
        for (int i = 0; i < init.length; i++) {
            requiredCounts.put(init[i], minCounts[i]);
        }
        
        int result = 0;
        Map<Character, Integer> currentCounts = new HashMap<>();
        for (char c : init) {
            currentCounts.put(c, 0);
        }
        
        for (int i = 0; i < m; i++) {
            char currentChar = dna.charAt(i);
            currentCounts.put(currentChar, currentCounts.get(currentChar) + 1);
        }
        
        boolean satisfiesCondition = true;
        for(Map.Entry<Character, Integer> entry : requiredCounts.entrySet()) {
            char key = entry.getKey();
            int value = entry.getValue();
            if(currentCounts.get(key) < value) {
                satisfiesCondition = false;
                break;
            }
        }

        if(satisfiesCondition) {
            result++;
        }

        for (int i = m; i < n; i++) {
            char outChar = dna.charAt(i - m);
            currentCounts.put(outChar, currentCounts.get(outChar) - 1);
            
            char inChar = dna.charAt(i);
            currentCounts.put(inChar, currentCounts.get(inChar) + 1);

            satisfiesCondition = true;
            for(Map.Entry<Character, Integer> entry : requiredCounts.entrySet()) {
                char key = entry.getKey();
                int value = entry.getValue();
                if(currentCounts.get(key) < value) {
                    satisfiesCondition = false;
                    break;
                }
            }

            if(satisfiesCondition) {
                result++;
            }
        }
        
        System.out.println(result);
    }
}