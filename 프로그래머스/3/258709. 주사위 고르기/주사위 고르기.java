import java.util.*;

class Solution {
    int maxWins = -1;
    int[] answer;
    int N;
    int[][] Dice;
    
    public int[] solution(int[][] dice) {
        this.N = dice.length;
        this.Dice = dice;
        answer = new int[N / 2];
        
        combinationDfs(0, 0, new int[N / 2]);
        
        return answer;
    }
    
    private void combinationDfs(int start, int depth, int[] combinationA) {
        if(depth == N / 2) {
            int[] combinationB = getCombinationB(combinationA);
            
            List<Integer> sumA = new ArrayList<>();
            calculateSumDfs(0, 0, combinationA, sumA);
            
            List<Integer> sumB = new ArrayList<>();
            calculateSumDfs(0, 0, combinationB, sumB);
           
            Collections.sort(sumB);
            int currentWins = 0;
            
            for(int scoreA : sumA) {
                currentWins += binarySearch(sumB, scoreA);
            }
            
            if(currentWins > maxWins) {
                maxWins = currentWins;
                for(int i = 0; i < N / 2; i++) {
                    answer[i] = combinationA[i] + 1;
                }
            }
            
            return;
        }
        
        for(int i = start; i < N; i++) {
            combinationA[depth] = i;
            combinationDfs(i + 1, depth + 1, combinationA);
        } 
    }
    
    private void calculateSumDfs(int depth, int currentSum, int[] combination, List<Integer> sumList) {
        if(depth == N / 2) {
            sumList.add(currentSum);
            return;
        }
        
        int currentDieIndex = combination[depth];
        for(int value : Dice[currentDieIndex]) {
            calculateSumDfs(depth + 1, currentSum + value, combination, sumList);
        }
    }
    
    private int[] getCombinationB(int[] combinationA) {
        int[] combinationB = new int[N / 2];
        boolean[] isA = new boolean[N];
        
        for(int indexA : combinationA) {
            isA[indexA] = true;
        }
        
        int bIndex = 0;
        
        for(int i = 0; i < N; i++) {
            if(!isA[i]) {
                combinationB[bIndex++] = i;
            }
        }
        
        return combinationB;
    }
    
    private int binarySearch(List<Integer> sortedList, int target) {
        int low = 0;
        int high = sortedList.size();
        
        while(low < high) {
            int mid = low + (high - low) / 2;
            if(sortedList.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        
        return low;
    }
}