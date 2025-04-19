import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        Stack<Integer> stack = new Stack<>();

        boolean isPossible = true;
        int count = 1;

        StringBuffer sb = new StringBuffer();

        for(int i = 1; i <= N; i++) {
            int num = sc.nextInt();

            if(num >= count) {
                while(num >= count) {
                    stack.push(count);
                    sb.append("+\n");
                    count++;
                }
                stack.pop();
                sb.append("-\n");
            }
            else {
                int temp = stack.pop();
                if(temp > num){
                    isPossible = false;
                    System.out.println("NO");
                    break;
                }
                else {
                    sb.append("-\n");
                }
            }
        }
        if(isPossible) {
            System.out.println(sb.toString());
        }
    }
}