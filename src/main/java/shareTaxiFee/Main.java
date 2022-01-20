package shareTaxiFee;

import java.io.IOException;
import java.util.Arrays;

//2021 kakao blind recruitment
public class Main {

    public void solution(){
        long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
        int result = solution(6,4,6,2, new int[][]{
                {4,1,10},
                {3,5,24},
                {5,6,2},
                {3,1,41},
                {5,1,24},
                {4,6,50},
                {2,4,66},
                {2,3,22},
                {1,6,25}
        });
//        for(int i : result)
            System.out.println(result);
        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
        long secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
        System.out.println("시간차이(ms) : "+secDiffTime);
    }

    int[][] board;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        board = new int[n+1][n+1];
        for(int i=0; i<board.length; i++) {
            Arrays.fill(board[i],20000000);
            board[i][i]=0;
        }
        for(int i=0; i<fares.length; i++) {
            board[fares[i][0]][fares[i][1]]=fares[i][2];
            board[fares[i][1]][fares[i][0]]=fares[i][2];
        }
        for(int cur=1; cur<=n; cur++){
            for(int start=1; start<=n; start++){
                search(n, cur, start);
            }
        }
        for(int i=1; i<=n; i++) answer = Math.min(answer, board[s][i]+board[i][a]+board[i][b]);
        return answer;
    }
    private void search(int n, int cur, int start){
        for(int end=1; end<=n; end++){
            board[start][end] = Math.min(board[start][end], board[start][cur] + board[cur][end]);
        }
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
