package computeBinomialCoefficient;

import java.io.IOException;

public class Main {

    public void solution(){
        long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
        int result = solution(5, 2);
//        for(String i : result)
            System.out.println(result);
        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
        long secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
        System.out.println("시간차이(ms) : "+secDiffTime);
    }

    public int solution(int n, int k) {
        return computeBinomialCoefficient(n, k);
    }
    public static int computeBinomialCoefficient(int n, int k){
        return computeXChooseY(n, k, new int[n+1][k+1]);
    }
    private static int computeXChooseY(int x, int y, int[][] xChooseY){
        if(y==0 || x==y){
            return 1;
        }

        if(xChooseY[x][y] == 0){
            int withoutY = computeXChooseY(x-1, y, xChooseY);
            int withY = computeXChooseY(x-1, y-1, xChooseY);
            xChooseY[x][y] = withoutY + withY;
        }
        return xChooseY[x][y];
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
