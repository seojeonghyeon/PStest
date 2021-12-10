package Test;

import java.io.*;
import java.util.*;

public class Main {

    public void solution(){
        long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
        int result = solution( 6);
//        for(int i : result)
            System.out.println(result);
        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
        long secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
        System.out.println("시간차이(ms) : "+secDiffTime);
    }
    class Edge implements Comparable<Edge>{
        public int vex; //정점
        public int cost; //가중치 값
        Edge(int vex, int cost){
            this.vex=vex;
            this.cost=cost;
        }
        @Override
        public int compareTo(Edge ob) {
            return this.cost-ob.cost;
        }
    }

    static ArrayList<ArrayList<Edge>> graph;
    static int[] dis;
    static int n, m;
    public int solution(int n) {
        int answer=0;
        graph = new ArrayList<ArrayList<Edge>>();
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<Edge>());
        }
        dis= new int[n+1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        for(int i=0; i<m; i++){

        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
