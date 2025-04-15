import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int M = Integer.parseInt(stringTokenizer.nextToken());
        int[] arr = new int[N];
        
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int start = 0;
        int end = N - 1;
        int count = 0;

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        Arrays.sort(arr);

        while(start < end) {
            if(arr[start] + arr[end] < M) {
                start++;
            } else if(arr[start] + arr[end] > M) {
                end--;                
            } else {
                count++;
                end--;
                start++;
            }
        }

        System.out.print(count);
    }
}