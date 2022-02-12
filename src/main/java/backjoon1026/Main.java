package backjoon1026;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public int solution(int[] A, int[] B) {
        int result = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        for(int i=0; i<A.length; ++i){
            result += A[i]*B[B.length-1-i];
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(in.readLine());
        int[] A = new int[N];
        int[] B = new int[N];
        StringTokenizer stringTokenizer = new StringTokenizer(in.readLine());
        for(int i=0; i<N; ++i)
            A[i] = Integer.parseInt(stringTokenizer.nextToken());
        stringTokenizer = new StringTokenizer(in.readLine());
        for(int i=0; i<N; ++i)
            B[i] = Integer.parseInt(stringTokenizer.nextToken());
        out.write(main.solution(A,B) + "\n");
        out.flush();
        in.close();
        out.close();
    }
}
