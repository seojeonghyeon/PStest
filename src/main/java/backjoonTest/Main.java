package backjoonTest;

import java.io.*;
import java.util.*;


public class Main {

    private static class study implements Comparable<study>{
        Integer S, T;
        private study(Integer S, Integer T){
            this.S = S;
            this.T = T;
        }
        @Override
        public int compareTo(study o) {
            if(o.T.equals(this.T)) return o.S-this.S;
            return o.T-this.T;
        }
    }

    public void solution(study[] Narray) {
        int answer = 0;
        boolean[] check = new boolean[Narray.length];
        Arrays.sort(Narray);
        PriorityQueue<study> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        priorityQueue.add(Narray[0]);
        check[0]=true;
        while (!priorityQueue.isEmpty()){
            study k = priorityQueue.poll();
            for (int i = 0; i < Narray.length; i++) {
                if(!check[i] && k.S > Narray[i].T){
                    check[i]=true;
                    priorityQueue.add(Narray[i]);
                    break;
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Integer N = Integer.parseInt(in.readLine());
        study[] Narray = new study[N];
        for(Integer i=0; i<N; i++){
            Integer S = Integer.parseInt(in.readLine());
            Integer T = Integer.parseInt(in.readLine());
            Narray[i] = new study(S, T);
        }
        Main main = new Main();
        main.solution(Narray);
    }
}
