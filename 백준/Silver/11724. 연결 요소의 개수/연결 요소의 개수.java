import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        for(int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<Integer>();
        }
        
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            arr[first].add(second);
            arr[second].add(first);
        }

        int count = 0;
        for(int i = 1; i <= N; i++) {
            if(!visited[i]) {
                count++;
                DFS(i);
            }
        }

        System.out.println(count);
    }

    public static void DFS(int start) {
        if(visited[start]) {
            return;
        }
        visited[start] = true;
        for(int i : arr[start]) {
            if(visited[i] == false) {
                DFS(i);
            }
        }
    }
}
