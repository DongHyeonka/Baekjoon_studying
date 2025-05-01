import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static int[] arr;
    public static long result;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());

        arr = new int[N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }        

        sort(arr, 5);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 0; i < N; i++) {
            bw.write(arr[i] + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static void sort(int[] arr, int N) {
        int[] output = new int[arr.length];
        int set = 1;
        int count = 0;
        while(count != N) {
            int[] bucket = new int[10];
            for(int i = 0; i < arr.length; i++) {
                bucket[(arr[i] / set) % 10]++;
            }
            for(int i = 1; i < 10; i++) {
                bucket[i] += bucket[i - 1];
            }
            for(int i = arr.length - 1; i >= 0; i--) {
                output[bucket[(arr[i] / set) % 10] - 1] = arr[i];
                bucket[(arr[i] / set) % 10]--;
            }
            for(int i = 0; i < arr.length; i++) {
                arr[i] = output[i];
            }
            set *= 10;
            count++;
        }
    }
}
