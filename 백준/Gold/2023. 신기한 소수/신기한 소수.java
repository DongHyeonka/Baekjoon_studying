import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        dfs(2, 1, N);
        dfs(3, 1, N);
        dfs(5, 1, N);
        dfs(7, 1, N);

        sc.close();
    }

    static void dfs(int number, int depth, int N) {
        if(!isPrime(number))
            return;
        
        if(depth == N) {
            System.out.println(number);
            return;
        }

        for (int i = 1; i <= 9; i++) {
            dfs(number * 10 + i, depth + 1, N);
        }
    }

    static boolean isPrime(int number) {
        if(number < 2) return false;

        for(int i = 2; i * i <= number; i++) {
            if(number % i == 0) return false;
        }
        return true;
    }
}
