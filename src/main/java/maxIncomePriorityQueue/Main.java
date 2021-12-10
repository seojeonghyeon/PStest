package maxIncomePriorityQueue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

    public void solution(){
        long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
        int result = solution( 6, new int[][]{
                        {50,2},
                        {20,1},
                        {40,2},
                        {60,3},
                        {30,3},
                        {30,1}
                }
                );
//        for(int i : result)
            System.out.println(result);
        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
        long secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
        System.out.println("시간차이(ms) : "+secDiffTime);
    }
    class Lecture implements  Comparable<Lecture>{
        public int money;
        public int time;
        Lecture(int money, int time){
            this.money=money;
            this.time=time;
        }
        @Override
        public int compareTo(Lecture ob){
            return ob.time-this.time;
        }
    }
    static int n, max=Integer.MAX_VALUE;
    public int solution(int n, int[][] MD) {
        int answer=0;
        this.n=n;
        ArrayList<Lecture> arr = new ArrayList<>();
        for(int i=0; i<MD.length; i++){
            arr.add(new Lecture(MD[i][0],MD[i][1]));
            if(MD[i][1]>max) max=MD[i][1];
        }

        //큰값 우선
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
        Collections.sort(arr);
        int j=0;
        for(int i=max; i>=1; i--){
            for(; j<n; j++){
                if(arr.get(j).time<i) break;
                pQ.offer(arr.get(j).money);
            }
            if(!pQ.isEmpty()) answer+=pQ.poll();
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
