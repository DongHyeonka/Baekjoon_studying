public class Main {
    public int solution(int num) {
        int sum = num;
        int temp = num;
        
        while(temp != 0) {
            sum += temp % 10;
            temp /= 10;
        }

        return sum;
    }

    public static void main(String[] args) throws Exception {
        boolean[] isGenerated = new boolean[10001];
        Main T = new Main();
        for(int i = 1; i < 10000; i++) {
            int generatedNum = T.solution(i);
            if(generatedNum < 10000) {
                isGenerated[generatedNum] = true;
            }
        }

        for(int i = 1; i < 10000; i++) {
            if(!isGenerated[i]) {
                System.out.println(i);
            }
        }
    }
}