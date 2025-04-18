import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = bufferedReader.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int L = Integer.parseInt(input[1]);
        Deque<Node> deque = new LinkedList<>();
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        
        for(int i = 0; i < N; i++) {
            int now = Integer.parseInt(stringTokenizer.nextToken());
            
            while (!deque.isEmpty() && deque.getLast().value > now) {
                deque.removeLast();
            }
            deque.addLast(new Node(now, i));
            if(deque.getFirst().index < i - L + 1) {
                deque.removeFirst();
            }
            bufferedWriter.write(deque.getFirst().value + " ");
        }
        
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    static class Node {
        public int value;
        public int index;

        Node(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}