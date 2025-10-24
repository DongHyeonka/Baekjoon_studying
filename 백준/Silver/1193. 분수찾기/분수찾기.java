import java.util.*;
public class Main {
    public void solution(int input) { 
        int k = 1;
        while(input > k) {
            input -= k;
            k++;
        }
        
        if(k % 2 != 0) {
            System.out.println(k + 1 - input + "/" + input);
        } else {
            System.out.println(input + "/" + (k + 1 - input));
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        Main T = new Main();
        T.solution(input);

        sc.close();
    }
}