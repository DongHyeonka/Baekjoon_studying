import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine()); 
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int[] arr = new int[N];
        int[] temp = new int[N];
        Stack<Integer> stack = new Stack<>();

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        stack.push(0);

        for(int i = 1; i < N; i++) {
            while(!stack.isEmpty() && arr[stack.peek()] < arr[i]){
                temp[stack.pop()] = arr[i];
            }
            stack.push(i);
        }

        while(!stack.isEmpty()) {
            temp[stack.pop()] = -1;
        }

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 0; i < N; i++) {
            bufferedWriter.write(temp[i] + " ");
        }

        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
