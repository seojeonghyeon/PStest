package Test;

import java.io.IOException;
import java.util.*;

public class Main {

    public void solution(){
        long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
        int result = solution(9, new Integer[]{2,3,7});
//        for(String i : result)
            System.out.println(result);
        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
        long secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
        System.out.println("시간차이(ms) : "+secDiffTime);
    }
    public int solution(int finalScore, Integer[] scores) {
        List<Integer> individualPlayScores = new ArrayList<Integer>(Arrays.asList(scores));
        return numCombinationsForFinalScore(finalScore, individualPlayScores);
    }
    public static int numCombinationsForFinalScore(int finalScore, List<Integer> individualPlayScores){
        int[] numCombinationsForScore = new int[finalScore+1];
        for(int i=0; i<individualPlayScores.size(); ++i){
            numCombinationsForScore[0]=1;
            for(int j=1; j<=finalScore; ++j){
                int withoutThisPlay = i-1 >= 0 ? numCombinationsForScore[j] : 0;
                int withThisPlay = j >= individualPlayScores.get(i) ? numCombinationsForScore[j-individualPlayScores.get(i)] : 0;
                numCombinationsForScore[j] = withoutThisPlay + withThisPlay;
            }
        }
        return numCombinationsForScore[finalScore];
    }


    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
