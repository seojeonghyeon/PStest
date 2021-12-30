package getItem;

import java.io.IOException;

public class Main {

    public void solution(){
        long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
        int result = solution(new int[][]{{1,1,7,4},{3,2,5,5},{4,3,6,9},{2,6,8,8}},1,3,7,8);
//        for(String i : result)
        System.out.println(result);
        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
        long secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
        System.out.println("시간차이(ms) : "+secDiffTime);
    }


    static int MAX_VALUE = 105;
    int[][] board;
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        init();
        for(int i=0; i< rectangle.length; i++){
            markingArea(rectangle[i][0], rectangle[i][1], rectangle[i][2], rectangle[i][3]);
        }
        answer = search(characterX, characterY, itemX, itemY);
        int reverse = search(itemX, itemY, characterX, characterY);
        answer = answer > reverse ? reverse : answer;
        return answer;
    }
    public int search(int startPointX, int startPointY, int endPointX, int endPointY){

        int count = 0;
        int curX = startPointX;
        int curY = startPointY;
        while(!(curX==endPointX && curY==endPointY)){
            int number = board[curY][curX];
            if(number == 0 || number == 1) return 0;
            if(number == 2) curY--;
            else if(number == 3) curY++;
            else if(number == 4) curX--;
            else if(number == 5) curX++;

            count++;
        }
        return count;
    }
    //0 -> no area, 1 -> black area, 2 -> up, 3 -> down, 4 -> left, 5 -> right
    public void markingArea(int startX, int startY, int endX, int endY){
        for(int i=startY; i<=endY; i++){
            for(int j=startX; j<=endX; j++){
                if(j==startX || j==(endX) || i==startY || i==(endY)){ //border
                    if(board[i][j]!=1) {
                        if(j==startX && (startY < i && i <=endY)){ //up
                            if(board[i][j]==4) board[i][j]=4;
                            else if(board[i][j]==5) board[i][j]=2;
                            else board[i][j]=2;
                        }else if(i==startY && (startX <= j && j <endX)){ //right
                            if(board[i][j]==2) board[i][j]=2;
                            else if(board[i][j]==3) board[i][j]=5;
                            else board[i][j]=5;
                        }else if(j==endX && (startY <= i && i <endY)){ //down
                            if(board[i][j]==4) board[i][j]=3;
                            else if(board[i][j]==5) board[i][j]=5;
                            else board[i][j]=3;
                        }else if(i==endY && (startX < j && j <=endX)){ //left
                            if(board[i][j]==2) board[i][j]=4;
                            else if(board[i][j]==3) board[i][j]=3;
                            else board[i][j]=4;
                        }
                    }
                }else{
                    board[i][j] = 1;
                }
            }
        }
    }
    public void init(){
        board = new int[MAX_VALUE][MAX_VALUE];
    }


    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
