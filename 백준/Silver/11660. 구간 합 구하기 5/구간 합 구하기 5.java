import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int firstNum = Integer.parseInt(stringTokenizer.nextToken());
        int secondNum = Integer.parseInt(stringTokenizer.nextToken());

        long[][] chart = new long[firstNum + 1][firstNum + 1];

        for(int i = 1; i <= firstNum; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int j = 1; j <= firstNum; j++) {
                chart[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        long[][] temp = new long[firstNum + 1][firstNum + 1];

        for(int i = 1; i <= firstNum; i++) {
            for(int j = 1; j <= firstNum; j++) {
                temp[i][j] = temp[i][j - 1] + temp[i - 1][j] - temp[i - 1][j - 1] + chart[i][j];
            }
        }

        for(int i = 0; i < secondNum; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int x1 = Integer.parseInt(stringTokenizer.nextToken());
            int y1 = Integer.parseInt(stringTokenizer.nextToken());
            int x2 = Integer.parseInt(stringTokenizer.nextToken());
            int y2 = Integer.parseInt(stringTokenizer.nextToken());
            System.out.println(temp[x2][y2] - temp[x1 - 1][y2] - temp[x2][y1 - 1] + temp[x1 - 1][y1 - 1]);
        }
    }
}