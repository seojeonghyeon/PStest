package kakaoCatchIdolFromCrain;

import java.io.IOException;
import java.util.Stack;

public class Main {

    public void solution(){
        long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
        int result = solution(5, new int[][]{
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 3},
                {0, 2, 5, 0, 1},
                {4, 2, 4, 4, 2},
                {3, 5, 1, 3, 1}},
                8,
                new int[]{1, 5, 3, 5, 1, 2, 1, 4});
//        for(int i : result)
            System.out.println(result);
        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
        long secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
        System.out.println("시간차이(ms) : "+secDiffTime);
    }

    public int solution(int N, int[][] board, int M, int[] moves) {
        int answer=0;
        Stack<Integer> stack = new Stack<>();

        for(int move : moves){
            for(int i=0; i< board.length; i++){
                if(board[i][move-1]!=0){
                    answer+=inputStack(stack, board[i][move-1]);
                    board[i][move-1]=0;
                    break;
                }
            }
        }
        return answer;
    }
    public int inputStack(Stack<Integer> stack, int number){
        if(!stack.isEmpty() && number == stack.peek()){
            stack.pop();
            return 2;
        }else{
            stack.push(number);
            return 0;
        }
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
