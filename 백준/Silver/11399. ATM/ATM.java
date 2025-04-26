import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N + 1];
        int[] sum = new int[N + 1];

        for(int i = 1; i <= N; i ++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        int result = 0;

        for(int i = 1; i <= N; i++) {
            sum[i] = sum[i - 1] + arr[i];
            result += sum[i];
        }

        System.out.print(result);
    }
}