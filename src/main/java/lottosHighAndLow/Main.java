package lottosHighAndLow;


import java.io.IOException;
import java.util.HashMap;

public class Main {
    public void solution(){
        int[] result = solution(new int[]{44,1,0,0,31,25},new int[]{31,10,45,1,6,19});
        System.out.println(result[0]+" "+result[1]);
    }
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int correctCount = 0;
        int zeroCount = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int i=0; i<win_nums.length; i++){
            hashMap.put(win_nums[i],i);
        }
        for(int i=0; i<lottos.length; i++){
            if(hashMap.containsKey(lottos[i])){
                correctCount++;
            }else if(lottos[i]==0){
                zeroCount++;
            }
        }

        answer[0] = checkScore(correctCount+zeroCount);
        answer[1] = checkScore(correctCount);
        return answer;
    }
    public int checkScore(int correctNumber){
        if(correctNumber == 6){
            return 1;
        }else if(correctNumber == 5){
            return 2;
        }else if(correctNumber == 4){
            return 3;
        }else if(correctNumber == 3){
            return 4;
        }else if(correctNumber == 2){
            return 5;
        }
        return 6;
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
