package backjoon1149;

import java.io.*;

public class Main {

    private void solution(Integer[] rgb, Integer[][] dp, Integer cur){
        dp[cur][0] = rgb[0] + TwoMin(dp[cur-1][1], dp[cur-1][2]);
        dp[cur][1] = rgb[1] + TwoMin(dp[cur-1][0], dp[cur-1][2]);
        dp[cur][2] = rgb[2] + TwoMin(dp[cur-1][1], dp[cur-1][0]);
    }

    private int TwoMin(int n1, int n2){
        return n1 < n2 ? n1 : n2;
    }

    private int ThreeMin(int n1, int n2, int n3){
        return (n1 < n2 ? (n1 < n3 ? n1 : n3):(n2 < n3 ? n2 : n3));
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        Integer[][] dp = new Integer[1001][3];

        Integer N = Integer.parseInt(in.readLine());
        String[] input = in.readLine().split(" ");
        dp[1][0] = Integer.parseInt(input[0]);
        dp[1][1] = Integer.parseInt(input[1]);
        dp[1][2] = Integer.parseInt(input[2]);

        for(Integer i=2; i<=N; ++i){
            input = in.readLine().split(" ");
            Integer[] rgb = new Integer[3];
            rgb[0] = Integer.parseInt(input[0]);
            rgb[1] = Integer.parseInt(input[1]);
            rgb[2] = Integer.parseInt(input[2]);
            main.solution(rgb, dp, i);
        }
        out.write(String.format("%d", main.ThreeMin(dp[N][0], dp[N][1], dp[N][2])) + "\n");
        out.flush();
        in.close();
        out.close();
    }
}
