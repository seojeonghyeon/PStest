package backjoon1915;

import java.io.*;
import java.util.StringTokenizer;

public class Main {


    public void solution() {
    }


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());

        int[][] dp = new int[1001][10001];
        int ans = 0;
        for(int i = 0; i < n; i ++){
            char[] line = in.readLine().toCharArray();
            for(int j = 0; j < line.length; j++){
                dp[i + 1][j + 1] = line[j] - '0';
                if(dp[i + 1][j + 1] != 0){
                    int temp = Math.min(dp[i][j], dp[i][j + 1]);
                    dp[i + 1][j + 1] = Math.min(temp, dp[i + 1][j]) + 1;
                    ans = Math.max(ans, dp[i + 1][j + 1]);
                }
            }
        }
        Main main = new Main();
        main.solution();

        out.write((ans * ans) + "\n");
        out.flush();
        in.close();
        out.close();

    }
}
