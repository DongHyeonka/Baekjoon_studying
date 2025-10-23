import java.util.*;

public class Main {
    public int solution(String str) {
        str = str.replaceAll("c=", "#");
        str = str.replaceAll("c-", "#");
        str = str.replaceAll("dz=", "#");
        str = str.replaceAll("d-", "#");
        str = str.replaceAll("lj", "#");
        str = str.replaceAll("nj", "#");
        str = str.replaceAll("s=", "#");
        str = str.replaceAll("z=", "#");

        return str.length();
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        Main T = new Main();
        int result = T.solution(input);
        System.out.println(result);

        sc.close();
    }
}
