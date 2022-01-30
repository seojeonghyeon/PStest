package backjoon1920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {


    public void solution(Integer N, Integer[] A, Integer M, Integer[] Marray) {
        Integer[] answer = new Integer[M];
        Arrays.sort(A);
        for(int i=0; i<Marray.length; i++) {
            answer[i]  = Arrays.binarySearch(A, Marray[i]) >= 0 ? 1 : 0;
        }
        for(Integer i : answer) System.out.println(i);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Integer N = Integer.parseInt(in.readLine());
        Integer[] A = new Integer[N];
        StringTokenizer stringTokenizer = new StringTokenizer(in.readLine());
        for(int i=0; i<N; ++i)
            A[i] = Integer.parseInt(stringTokenizer.nextToken());

        Integer M = Integer.parseInt(in.readLine());
        Integer[] Marray = new Integer[M];
        stringTokenizer = new StringTokenizer(in.readLine());
        for(int i=0; i<M; ++i)
            Marray[i] = Integer.parseInt(stringTokenizer.nextToken());
        Main main = new Main();
        main.solution(N, A, M, Marray);
    }
}
