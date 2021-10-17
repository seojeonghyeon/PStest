package KorToEng;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    char[][] array;

    public void solution(int N){
        StringBuilder sb;
        array = new char[N][N];
        sb = new StringBuilder();
        printStart(0,0,N, false);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(array[i][j]);
            }
            sb.append('\n');
        }
        System.out.print(sb);

    }
    //N은 블록 사이즈
    public void printStart(int x, int y, int N, boolean ablank){
        if(ablank){
            for(int i = x; i < x+N; i++){
                for(int j =y; j < y+N; j++){
                    array[i][j]=' ';
                }
            }
            return;
        }
        if(N == 1){
            array[x][y]='*';
            return;
        }
        int size = N/3;
        int count = 0;
        for(int i=x;i<x+N; i+=size){
            for(int j=y; j<y+N; j+=size){
                count++;
                if (count == 5){
                    printStart(i, j, size, true);
                }else{
                    printStart(i, j, size, false);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        br.close();
        main.solution(N);
    }
}
