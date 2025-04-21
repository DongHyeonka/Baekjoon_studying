import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        Deque<Integer> deque = new ArrayDeque<>();

        for(int i = 1; i <= N; i++) {
            deque.addLast(i);
        }

        while(deque.size() > 1) {
            deque.removeFirst();
            deque.addLast(deque.removeFirst());
        }

        System.out.println(deque.getFirst());
    }
}
