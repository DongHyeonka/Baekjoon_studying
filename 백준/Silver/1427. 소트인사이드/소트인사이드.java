import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(bufferedReader.readLine());
        ArrayList<Integer> arr = new ArrayList<>();
        
        while(N > 0) {
            arr.add((int)(N % 10));
            N /= 10;
        }

        Collections.sort(arr, Collections.reverseOrder());
        
        for(int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i));
        }
    }
}
