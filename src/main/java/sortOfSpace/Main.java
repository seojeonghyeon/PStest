package sortOfSpace;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public void solution(){
        long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
        solution1();
//        for(int i : result)
//            System.out.println(result);
        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
        long secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
        System.out.println("시간차이(ms) : "+secDiffTime);
    }

    public void solution1() {
        ArrayList<Point> arrayList = new ArrayList<>();
        arrayList.add(new Point(2,7));
        arrayList.add(new Point(1,3));
        arrayList.add(new Point(1,2));
        arrayList.add(new Point(2,5));
        arrayList.add(new Point(3,6));
        Collections.sort(arrayList);
    }
    class Point implements Comparable<Point>{
        public int x, y;
        Point(int x, int y){
            this.x=x;
            this.y=y;
        }
        @Override
        public int compareTo(Point o){
            if(this.x==o.x) return this.y-o.y;
            else return this.x-o.x;
        }
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
