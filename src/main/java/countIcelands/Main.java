package countIcelands;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public void solution(){
        long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
        int result = solution(7,new int[][]{
                {1, 1, 0, 0, 0, 1, 0},
                {0, 1, 1, 0, 1, 1, 0},
                {0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 1, 1},
                {1, 1, 0, 1, 1, 0, 0},
                {1, 0, 0, 0, 1, 0, 0},
                {1, 0, 1, 0, 1, 0, 0}}
                );
//        for(int i : result)
            System.out.println(result);
        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
        long secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
        System.out.println("시간차이(ms) : "+secDiffTime);
    }

    static int n;
    static int[] dx={-1,-1,0,1,1,1,0,-1};
    static int[] dy={0,1,1,1,0,-1,-1,-1};
    public int solution(int n, int[][] board) {
        int answer=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(board[i][j]==1){
                    answer++;
                    board[i][j]=0;
                    DFS(i,j,board);
//                    BFS(i, j, board);
                }
            }
        }
        return answer;
    }
    public void DFS(int x, int y, int[][] board){
        for(int i=0; i<8; i++){
            int nx=x+dx[i];
            int ny=y+dy[i];
            if(nx>=0 && nx<n && ny>=0 && ny<n && board[nx][ny]==1){
                board[nx][ny]=0;
                DFS(nx,ny,board);
            }
        }
    }
    class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
    Queue<Point> queue = new LinkedList<>();
    public void BFS(int x, int y, int[][] board){
        queue.add(new Point(x,y));
        while(!queue.isEmpty()){
            Point pos = queue.poll();
            for(int i=0; i<8; i++){
                int nx=pos.x+dx[i];
                int ny=pos.y+dy[i];
                if(nx>=0 && nx<n && ny>=0 && ny<n && board[nx][ny]==1){
                    board[nx][ny]=0;
                    queue.add(new Point(nx, ny));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
