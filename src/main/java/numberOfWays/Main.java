package numberOfWays;

import java.io.IOException;

public class Main {

    public void solution(){
        long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
        int result = solution(5, 5);
//        for(String i : result)
            System.out.println(result);
        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
        long secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
        System.out.println("시간차이(ms) : "+secDiffTime);
    }

    public int solution(int n, int m) {
        return numberOfWays(n, m);
    }
    public static int numberOfWays(int n, int m){
        return computeNumberOfWaysToXY(n-1, m-1, new int[n][m]);
    }

    //basic
    private static int computeNumberOfWaysToXY(int x, int y, int[][] numberOfWays){
        if(x==0 || y==0){
            return 1;
        }

        if(numberOfWays[x][y] == 0){
            int waysTop = x ==0 ? 0 : computeNumberOfWaysToXY(x-1, y, numberOfWays);
            int waysLeft = x ==0 ? 0 : computeNumberOfWaysToXY(x, y-1, numberOfWays);
            numberOfWays[x][y] = waysTop + waysLeft;
        }
        return numberOfWays[x][y];
    }



    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
