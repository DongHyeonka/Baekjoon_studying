import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int anum[] = new int[num];

        long sum = 0;
        long max = 0;

        for(int i = 0; i < num; i++) {
            anum[i] = sc.nextInt();
            sum += anum[i];
            if (max < anum[i]) 
                max = anum[i];
        }

        System.out.print(sum * 100.0 / max / num);
    }
}