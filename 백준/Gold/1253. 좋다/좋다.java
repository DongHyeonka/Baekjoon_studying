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

        long[] number = new long[N];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for(int i = 0; i < N; i++) {
            number[i] = Long.parseLong(stringTokenizer.nextToken());
        }

        int count = 0;

        Arrays.sort(number);

        for(int k = 0; k < N; k++) {
            long find = number[k];
            int i = 0;
            int j = N - 1;

            while(i < j) {
                if(number[i] + number[j] < find) {
                    i++;
                } else if(number[i] + number[j] > find) {
                    j--;
                } else {
                    if(i != k && j != k) {
                        count++;
                        break;
                    } else if(i == k) {
                        i++;
                    } else if(j == k) {
                        j--;
                    }
                }
            }
        }

        System.out.print(count);
    }
}