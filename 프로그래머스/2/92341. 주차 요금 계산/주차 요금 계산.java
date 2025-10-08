import java.util.*;

class Solution {
    int defaultTime;
    int defaultFee;
    int exceedTime;
    int exceedFee;
    List<Integer> answer;
    
    public int[] solution(int[] fees, String[] records) {
        this.defaultTime = fees[0];
        this.defaultFee = fees[1];
        this.exceedTime = fees[2];
        this.exceedFee = fees[3];
        
        Map<String, Integer> cargo = new HashMap<>();
        Map<String, String> inoutCheck = new HashMap<>();
        Map<String, Integer> totalTime = new TreeMap<>();
        answer = new ArrayList<>();
        
        // 5961 -> 0000 -> 0148
        
        for(String record : records) {
            String[] parts = record.split(" ");
            String time = parts[0];
            String carNum = parts[1];
            String type = parts[2];
            
            if(type.equals("IN")) {
                inoutCheck.put(carNum, type); // In으로 타입이 저장
                int inTime = calculate(time);
                cargo.put(carNum, inTime);
            } else if(type.equals("OUT")) { // 동일한 키로 out으로 변경이 되어야함 나중에 이 값이 없고 in만 존재하는 상황이 생긴다면 그때 23시 59분으로 처리하도록 해주자고
                inoutCheck.put(carNum, type); // 이떄 다시 out으로 바꿀거임
                int outTime = calculate(time); // 나올 때 시간을 계산
                int inTime = cargo.get(carNum); // 이 시점에 in으로 들어갔던 시간이 있을거임
                int diffTime = outTime - inTime;
                totalTime.put(carNum, totalTime.getOrDefault(carNum, 0) + diffTime);
                cargo.put(carNum, outTime);
            }
        }
        
        // 이 시점이 되면 totalTime에는 전체 시간이 들어있을거고 만약에 In만 있는게 있다면 그거 만큼 추가적으로 계산 해줘야됨 23시 59분으로 처리
        int outTime = calculate("23:59");
        for(String key :cargo.keySet()) {
            int inTime = cargo.get(key);
        
            int diffTime = outTime - inTime;
            if(inoutCheck.get(key).equals("IN")) {
                totalTime.put(key, totalTime.getOrDefault(key, 0) + diffTime);
            } // 여기서 in으로 남게 되는 타입에 대해서 시간 다 처리
        }
        
        // 이제 이 시점이 되면 모든 시간 처리가 끝났고 totalTime을 계산해서 하루에 내야되는 금액을 계산하면 된다.
        
        for(String key :totalTime.keySet()) {
            int totalTimes = totalTime.get(key);
            int totalFee = 0;
            if(totalTimes > defaultTime) {
                totalFee += defaultFee;
                double diffTime = (double) (totalTimes - defaultTime);
                totalFee += (Math.ceil(diffTime / exceedTime) * exceedFee); //딱 나눠 떨어지지 않으면 올림
                answer.add(totalFee);
            } else {
                totalFee += defaultFee;
                answer.add(totalFee);
            }
        }
        
        
        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
    
    private int calculate(String time) {
        String[] parts = time.split(":");
        int hour = Integer.parseInt(parts[0]);
        int min = Integer.parseInt(parts[1]);
        
        return hour * 60 + min;
    }
}
// 주차 후 출차 내역이 없다면 23:59에 출차된것으로 간주
// 일단 분으로 바꾸는 함수
// 누적 시간이 기본 시간 이하라면 기본 요금 청구 
// 기본 시간을 초과한다면 기본 요금에 더해서 초과한 시간에 대해서 단위시간마다 단위 요금을 청구
// 단위 시간으로 나누어 떨어지지 않으면 올림 ceil 처리
// a 보다 작지 않은 올림 처리
