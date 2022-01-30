package backjoon11000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {

    private static class Lecture implements Comparable<Lecture>{
        int S, T;
        private Lecture(int S, int T){
            this.S = S;
            this.T = T;
        }
        @Override
        public int compareTo(Lecture o) {
            if(this.S == o.S) return this.T-o.T;
            return this.S-o.S;
        }
    }

    public void solution(Lecture[] Narray) {
        Arrays.sort(Narray);
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(Narray[0].T);
        for(int i=1; i<Narray.length; i++){
            if(priorityQueue.peek() <= Narray[i].S) priorityQueue.poll();
            priorityQueue.offer(Narray[i].T);
        }
        System.out.println(priorityQueue.size());
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;
        Integer N = Integer.parseInt(in.readLine());
        Lecture[] Narray = new Lecture[N];
        for(Integer i=0; i<N; i++){
            stringTokenizer = new StringTokenizer(in.readLine());
            Integer S = Integer.parseInt(stringTokenizer.nextToken());
            Integer T = Integer.parseInt(stringTokenizer.nextToken());
            Narray[i] = new Lecture(S, T);
        }
        Main main = new Main();
        main.solution(Narray);
    }
}
