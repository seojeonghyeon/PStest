package backjoon7576;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int count;
    static int days;
    public int solution(int M, int N, int[][] box, Queue<int[]> queue) {
        bfs(box, M, N, queue);
        return count==0 ? days : -1;
    }
    private static void bfs(int[][] box, int M, int N, Queue<int[]> queue){
        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};
        days = 0;

        while (count > 0 && !queue.isEmpty()) {
            for (int s = queue.size(); s > 0; s--) {
                int[] cur = queue.poll();

                for (int k = 0; k < 4; k++) {
                    int ny = cur[0] + dy[k];
                    int nx = cur[1] + dx[k];
                    if ( (0<=nx && nx<M) && (0<=ny && ny<N) && box[ny][nx] == 0) {
                        count--;
                        box[ny][nx] = 1;
                        queue.add(new int[]{ny, nx});
                    }
                }
            }
            days++;
        }
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer = new StringTokenizer(in.readLine());
        int M = Integer.parseInt(stringTokenizer.nextToken());
        int N = Integer.parseInt(stringTokenizer.nextToken());

        Queue<int[]> queue = new LinkedList<>();
        int[][] box = new int[N][M];
        count = 0;

        for(int i=0; i<N; ++i){
            stringTokenizer = new StringTokenizer(in.readLine());
            for(int j=0; j<M; ++j){
                box[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                if(box[i][j]==1) queue.add(new int[]{i, j});
                else if(box[i][j]==0) count++;
            }
        }

        out.write(main.solution(M,N,box, queue) + "\n");
        out.flush();
        in.close();
        out.close();
    }
}
