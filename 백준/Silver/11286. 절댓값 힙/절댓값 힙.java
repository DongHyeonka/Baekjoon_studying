import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        Comparator<Integer> comparator = (a, b) -> {
            int absA = Math.abs(a);
            int absB = Math.abs(b);

            if(absA == absB) {
                return a > b ? 1 : -1;
            } else {
                return absA > absB ? 1 : -1;
            }
        };

        PriorityQueue<Integer> pq = new PriorityQueue<>(comparator);

        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(bf.readLine());
            if(num == 0){
                if(pq.isEmpty()){
                    System.out.println(0);
                }
                else{
                    System.out.println(pq.poll());
                }
            }
            else{
                pq.add(num);
            }
        }
    }
}
