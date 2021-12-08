package numberOfKBig;

import java.io.IOException;
import java.util.Collections;
import java.util.TreeSet;

public class Main {

    public void solution(){
        long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
        int result = solution(10,3,new int[]{13,15,34,23, 45, 65, 33, 11, 26, 42});
//        for(int i : result)
            System.out.println(result);
        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
        long secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
        System.out.println("시간차이(ms) : "+secDiffTime);
    }

    public int solution(int N, int K, int[] NArray) {
        int answer=-1;
        TreeSet<Integer> Tset = new TreeSet<>(Collections.reverseOrder());
        for(int i=0; i<N; i++){
            for(int j=i+1; j<N; j++){
                for(int l=j+1; l<N; l++){
                    Tset.add(NArray[i]+NArray[j]+NArray[l]);
                }
            }
        }
        int cnt =0;
        for(int x : Tset){
            cnt++;
            if(cnt==K) return x;
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
