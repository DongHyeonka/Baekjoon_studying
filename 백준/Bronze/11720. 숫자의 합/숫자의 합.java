import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        String snum = sc.next();
        char[] cnum = snum.toCharArray();

        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += cnum[i] - '0';
        }

        System.out.print(sum);
    }
}