import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());

        Data[] arr = new Data[N];

        for(int i = 0; i < N; i++) {
            arr[i] = new Data(Integer.parseInt(reader.readLine()), i);
        }

        Arrays.sort(arr);
        int maxShift = 0;

        for(int i = 0; i < N; i++) {
            if (arr[i].index - i > maxShift) {
                maxShift = arr[i].index - i;
            }
        }

        System.out.println(maxShift + 1);
    }
}

class Data implements Comparable<Data> {
    int value;
    int index;

    public Data(int value, int index) {
        this.value = value;
        this.index = index;
    }

    @Override
    public int compareTo(Data o) {
        return this.value - o.value;
    }
}