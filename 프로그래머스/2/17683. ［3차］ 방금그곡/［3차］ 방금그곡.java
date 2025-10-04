import java.util.*;

class Solution {
    public static class MusicInfo {
        String startTime;
        String endTime;
        int playTime;
        String musicTitle;
        String musicInfo;
        
        public MusicInfo(String startTime, String endTime, String musicTitle, String musicInfo) {
            this.startTime = startTime;
            this.endTime = endTime;
            int time = calculateTime(startTime, endTime);
            this.playTime = time;
            this.musicTitle = musicTitle;
            
            StringBuilder extendMusicInfo = new StringBuilder();
            for(int i = 0; i < time; i++) {
                extendMusicInfo.append(musicInfo.charAt(i % musicInfo.length()));
            }
            this.musicInfo = extendMusicInfo.toString();
        }
        
        private int calculateTime(String startTime, String endTime) {
            String[] startParts = startTime.split(":");
            String[] endParts = endTime.split(":");
            
            int startHour = Integer.parseInt(startParts[0]);
            int startMin = Integer.parseInt(startParts[1]);
            int endHour = Integer.parseInt(endParts[0]);
            int endMin = Integer.parseInt(endParts[1]);
            
            int resultStartHour = startHour * 60 + startMin;
            int resultEndMin = endHour * 60 + endMin;
            
            return resultEndMin - resultStartHour;
        }

    }
    
    public String solution(String m, String[] musicinfos) {
        m = replaceSharp(m);
        
        int n = musicinfos.length;
        
        List<MusicInfo> result = new ArrayList<>();
        
        for(int i = 0; i < n; i++) {
            String[] parts = musicinfos[i].split(",");
            parts[3] = replaceSharp(parts[3]);
            result.add(new MusicInfo(parts[0], parts[1], parts[2], parts[3]));
        }
        
        int k = 0;
        String answer = "(None)";
        int maxPlayTime = -1;
        
        for(int i = 0; i < n; i++) {
            String musicInfo = result.get(i).musicInfo;
            
            if(musicInfo.contains(m)) {
                if(result.get(i).playTime > maxPlayTime) {
                    answer = result.get(i).musicTitle;
                    maxPlayTime = result.get(i).playTime;
                }
            }
        }

        return answer;
    }
    
    private String replaceSharp(String melody) {
        return melody.replaceAll("C#", "c")
            .replaceAll("D#", "d")
            .replaceAll("F#", "f")
            .replaceAll("G#", "g")
            .replaceAll("A#", "a")
            .replaceAll("B#", "b");
    }
}