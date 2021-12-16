package LRU;

import java.io.IOException;
import java.util.LinkedList;

public class Main {

    public void solution(){
        long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
        int[] result = solution(5, 9, new int[]{1,2,3,2,6,2,3,5,7});
        for(int i : result)
            System.out.println(i);
        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
        long secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
        System.out.println("시간차이(ms) : "+secDiffTime);
    }

//    public int[] solution(int S, int N, int[] array) {
//        int[] cache = new int[S];
//        for(int x : array){
//            int pos=-1;
//            for(int i=0; i<S; i++) if(x==cache[i]) pos=i;
//            if(pos==-1){
//                for(int i=S-1; i>=1; i--){
//                    cache[i]=cache[i-1];
//                }
//            }else{
//                for(int i=pos; i>=1; i--){
//                    cache[i]=cache[i-1];
//                }
//            }
//            cache[0]=x;
//        }
//        return cache;
//    }

    public int[] solution(int S, int N, int[] array) {
        LinkedList<Integer> cash = new LinkedList<>();
        for(int i=0; i<array.length; i++){
            if(cash.contains(array[i]))
                cash.remove(new Integer(array[i]));
            else
                if (cash.size() >= S)
                    cash.remove(S - 1);
            cash.add(0, array[i]);
        }
        int[] answer = new int[S];
        for(int i=0; i<S;i++){
            answer[i]=cash.get(i);
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
