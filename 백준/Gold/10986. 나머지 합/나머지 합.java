import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        long result = 0;
        long[] S = new long[N];
        long[] C = new long[M];

        S[0] = sc.nextInt();
        

        for (int i = 1; i < N; i++) {
            S[i] = S[i - 1] + sc.nextInt();
        }

        for(int i = 0; i < N; i++) {
            int remain = (int) (S[i] % M);
            if (remain == 0) result++;
            C[remain]++;
        }

        for (int i = 0; i < M; i++) {
            if(C[i] > 1) {
                result = result + (C[i] * (C[i] - 1) / 2);
            }
        }

        System.out.println(result);
    }
}