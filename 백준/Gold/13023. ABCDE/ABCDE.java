import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static boolean result = false;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] arr = new ArrayList[N];
        boolean[] visited = new boolean[N];

        for(int i = 0; i < N; i++) {
            arr[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            arr[first].add(second);
            arr[second].add(first);
        }

        for(int i = 0; i < N; i++) {
            if(!visited[i]) {
                dfs(i, arr, visited, 1);
            }
        }

        if(result)
            System.out.println("1");
        else
            System.out.println("0");
    }

    static void dfs(int number, ArrayList<Integer>[] arr, boolean[] visited, int depth) {
        if(depth == 5 || result) {
            result = true;
            return;
        }
    
        visited[number] = true;

        for(int i : arr[number]) {
            if(!visited[i])
                dfs(i, arr, visited, depth + 1);
        }

        visited[number] = false;
    }
}
