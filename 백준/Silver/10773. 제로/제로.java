import java.util.*;

public class Main {
    Deque<Integer> stack = new ArrayDeque<>();

    public void solution(int input, Scanner sc) {
        for (int i = 0; i < input; i++) {
            int num = sc.nextInt();

            if (num == 0) {
                stack.removeFirst();
            } else {
                stack.addFirst(num);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        Main T = new Main();
        T.solution(input, sc);
        int answer = 0;

        if(T.stack.isEmpty()) {
            System.out.println(0);
        } else {
            while(!T.stack.isEmpty()) {
                answer += T.stack.pop();
            }
            System.out.println(answer);
        }

        sc.close();
    }
}
