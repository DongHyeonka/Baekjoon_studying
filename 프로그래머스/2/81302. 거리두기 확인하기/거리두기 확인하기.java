import java.util.*;

class Solution {
    private static final int[] dx = {0, 0, 1, -1};
    private static final int[] dy = {1, -1, 0, 0};
    
    public int[] solution(String[][] places) {
        int n = places.length;
        int[] answer = new int[n];
        
        for(int i = 0; i < n; i++) {
            answer[i] = isDistanced(places[i]);
        }
        
        return answer;
    }
    
    private int isDistanced(String[] room) {
        for(int i = 0; i < room.length; i++) {
            for(int j = 0; j < room.length; j++) {
                if(room[i].charAt(j) == 'P') {
                    if(!checkRound(i, j, room))
                        return 0;
                }
            }
        }
        return 1;
    }
    
    private boolean checkRound(int i, int j, String[] room) {
        for(int k = 0; k < 4; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];
            
            if(isValid(nx, ny, room.length) && room[nx].charAt(ny) == 'P') {
                return false;
            }
        }
        
        for(int k = 0; k < 4; k++) {
            int nx = i + dx[k] * 2;
            int ny = j + dy[k] * 2;
            
            if(isValid(nx, ny, room.length) && room[nx].charAt(ny) == 'P') {
                int midnx = i + dx[k];
                int midny = j + dy[k];
                
                if (room[midnx].charAt(midny) != 'X') {
                    return false;
                }
            }
        }
        
        int[] dx = {-1, -1, 1, 1};
        int[] dy = {-1, 1, -1, 1};
        
        for(int k = 0; k < 4; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];
            
            if(isValid(nx, ny, room.length) && room[nx].charAt(ny) == 'P') {
                if(room[i].charAt(ny) != 'X' ||room[nx].charAt(j) != 'X') {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private boolean isValid(int i, int j, int length) {
        return i >= 0 && i < length && j < length && j >= 0;
    }
}
