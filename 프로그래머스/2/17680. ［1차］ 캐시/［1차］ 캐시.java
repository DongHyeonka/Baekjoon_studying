import java.util.*;

class Solution {
    public static class LRUCache<K, V> extends LinkedHashMap<K, V> {
        private final int cacheSize;
        
        public LRUCache(int cacheSize) {
            super(16, 0.75f, true);
            this.cacheSize = cacheSize;
        }
        
        @Override
        protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
         return size() > cacheSize;   
        }
    }
    
    public int solution(int cacheSize, String[] cities) {
        
        if(cacheSize == 0) {
            return cities.length * 5;
        }
        
        int answer = 0;
        
        LRUCache<String, Boolean> map = new LRUCache<>(cacheSize);
        
        for(String city : cities) {
            String processedCity = city.toLowerCase();
            
            if(map.containsKey(processedCity)) {
                answer += 1;
            } else {
                answer += 5;
            }
            
            map.put(processedCity, true);
        }
        

        return answer;
    }
}