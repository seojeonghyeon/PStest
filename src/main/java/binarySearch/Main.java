package binarySearch;

import java.io.IOException;
import java.util.Arrays;

public class Main {

    public void solution(){
        long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
        int result = solution(new int[]{23,87,65,12,57,32,99,81},8,32);
//        for(int i : result)
            System.out.println(result);
        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
        long secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
        System.out.println("시간차이(ms) : "+secDiffTime);
    }

    public int solution(int[] array,int N, int M) {
        int answer=0;
        Arrays.sort(array);
        int lt=0, rt =N-1;
        while(lt <= rt){
            int mid = (lt+rt)/2;
            if(array[mid]==M){
                answer=mid+1;
                break;
            }
            if(array[mid]>M) rt=mid-1;
            else lt=mid+1;
        }
        return answer;

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
