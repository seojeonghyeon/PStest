package minSum;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

public class Main {

    public void solution(){
        long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
        int result = solution(new int[]{1,2}, new int[]{3,4});
//        for(int i : result)
            System.out.println(result);
        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
        long secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
        System.out.println("시간차이(ms) : "+secDiffTime);
    }

    public int solution(int[] A, int[] B) {
        int answer = 0;
        Integer[] Aarray = sort(A, 1);
        Integer[] Barray = sort(B, -1);
        for(int i=0; i< A.length; i++){
            answer+=Aarray[i]*Barray[i];
        }
        return answer;
    }
    public Integer[] sort(int[] array, int n){
        Integer[] Array = new Integer[array.length];
        for(int i=0; i<array.length; i++){
            Array[i] = array[i];
        }
        if(n == 1){
            Arrays.sort(Array);
        }else{
            Arrays.sort(Array,Collections.reverseOrder());
        }
        return Array;
    }


    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
