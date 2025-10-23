import java.util.*;

public class Main {

    private boolean isGroupWord(String str) {
        Set<Character> appeared = new HashSet<>();

        char prev = ' ';

        for(int i = 0; i < str.length(); i++) {
            char currentCh = str.charAt(i);

            if(prev != currentCh) {
                if(appeared.contains(currentCh)) {
                    return false;
                }

                appeared.add(currentCh);
            }

            prev = currentCh;
        }

        return true;
    }

    public int solution(int input, Scanner sc) {
        int answer = 0;

        for(int i = 0; i < input; i++) {
            String str = sc.nextLine();

            if(isGroupWord(str)) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        sc.nextLine();

        Main T = new Main();
        System.out.println(T.solution(input, sc));

        sc.close();
    }
}