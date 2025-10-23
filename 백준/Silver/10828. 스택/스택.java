import java.util.*;

public class Main {
    Deque<Integer> stack = new ArrayDeque<>();

    public String solution(Scanner sc) {
        String str = sc.nextLine();

        String[] parts = str.split(" ");

        String command = parts[0];

        switch(command) {
            case "push":
                int num = Integer.parseInt(parts[1]);
                stack.addFirst(num);
                return null;
            case "pop":
                if(!stack.isEmpty()) {
                    return String.valueOf(stack.removeFirst());
                } else {
                    return "-1";
                }
            case "size":
                return String.valueOf(stack.size());
            case "empty":
                if(stack.isEmpty()) {
                    return "1";
                } else {
                    return "0";
                }
            case "top":
                if(!stack.isEmpty()) {
                    return String.valueOf(stack.getFirst());
                } else {
                    return "-1";
                }
            default:
                break;
        }

        return null;
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        sc.nextLine();

        Main T = new Main();
        for(int i = 0; i < input; i++) {
            String result = T.solution(sc);
            
            if(result != null) {
                System.out.println(result);
            }
        }

        sc.close();
    }
}
