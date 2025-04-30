import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static long swap_count;
    public static int[] arr, result;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];
        result = new int[N + 1];

        st = new StringTokenizer(bf.readLine());
        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        swap_count = 0;
        merge_sort(1, N);

        System.out.println(swap_count);
    }

    private static void merge_sort(int start, int end) {
        if(end - start < 1) 
            return;
        
        int mid = (end - start) / 2 + start;

        merge_sort(start, mid);
        merge_sort(mid + 1, end);
        for(int i = start; i <= end; i++) {
            result[i] = arr[i];
        }
        int k = start;
        int index1 = start;
        int index2 = mid + 1;

        while(index1 <= mid && index2 <= end) {
            if(result[index1] > result[index2]) {
                arr[k] = result[index2];
                swap_count = swap_count + index2 - k;
                k++;
                index2++;
            } else {
                arr[k] = result[index1];
                k++;
                index1++;
            }
        }

        while(index1 <= mid) {
            arr[k] = result[index1];
            k++;
            index1++;
        }

        while(index2 <= end) {
            arr[k] = result[index2];
            k++;
            index2++;
        }
    }
}