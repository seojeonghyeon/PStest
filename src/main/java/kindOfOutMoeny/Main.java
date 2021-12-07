package kindOfOutMoeny;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public void solution(){
        long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
        ArrayList<Integer> result = solution(7,4,new int[]{20,12,20,10,23,17,10});
        for(int i : result)
            System.out.println(i);
        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
        long secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
        System.out.println("시간차이(ms) : "+secDiffTime);
    }

//    public int[] solution(int N, int K, int[] array) {
//        int[] answer = new int[N-K+1];
//
//        for(int i=0; i<N-K+1; i++){
//            HashSet<Integer> hashSet = new HashSet<>();
//            for(int j=0; j<K; j++){
//                hashSet.add(array[i+j]);
//            }
//            answer[i]=hashSet.size();
//        }
//        return answer;
//    }
    public ArrayList<Integer> solution(int N, int K, int[] array) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<Integer, Integer> HM = new HashMap<>();
        for(int i=0; i<K-1; i++){
            HM.put(array[i],HM.getOrDefault(array[i],0)+1);
        }
        int lt=0;
        for(int rt=K-1; rt < N; rt++){
            HM.put(array[rt],HM.getOrDefault(array[rt],0)+1);
            answer.add(HM.size());
            HM.put(array[lt], HM.get(array[lt])-1);
            if(HM.get(array[lt])==0) HM.remove(array[lt]);
            lt++;
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
