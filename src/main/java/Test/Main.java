package Test;

import java.io.*;
import java.util.*;

public class Main {

    public void solution(){
        long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
        int result = solution(5, new int[][]{{1,5},{2,5},{3,5},{4,5}});
//        for(int i : result)
            System.out.println(result);
        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
        long secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
        System.out.println("시간차이(ms) : "+secDiffTime);
    }

    int[][] nArray;
    Boolean[] check;
    public int solution(int n, int[][] edges) {
        int answer = 0;
        nArray = new int[n+1][n+1];
        check = initBoolean(n);
        for(int i=0; i<edges.length; i++){
            nArray[edges[i][0]][edges[i][1]] = 1;
            nArray[edges[i][1]][edges[i][0]] = 1;
        }
        for(int i=1; i<n+1; i++){
            for(int j=1; j<n+1; j++){
                if(i==j) continue;
                if(nArray[i][j]!=0) continue;
                cleanBoolean();
                check[i]=true;
                dfs(i, i, j,1);
            }
        }
        for(int a=1; a<nArray.length; a++){
            for(int b=a+1; b<nArray.length; b++){
                for(int c=b+1; c<nArray.length; c++){
                    int mid = f(a,b,c);
                    if(answer < mid) answer = mid;
                }
            }
        }
        return answer;
    }
    public int f(int a, int b, int c){
        int[] n = new int[3];
        n[0]=nArray[a][b];
        n[1]=nArray[b][c];
        n[2]=nArray[c][a];
        Arrays.sort(n);
        return n[1];
    }
    public void dfs(int cur, int i, int j, int level){
        if(nArray.length <= i || nArray.length <= j) return;
        if(nArray[cur][j]!=0){
            nArray[i][j]=level;
            nArray[j][i]=level;
            return ;
        }
        if(nArray[i][cur]==0){
            nArray[i][cur]=level;
            nArray[cur][i]=level;
        }
        for(int k=1; k<nArray.length; k++){
            if(!check[k] && nArray[cur][k]==1){
                check[k]=true;
                if(k==j) {
                    nArray[i][j]=level+1;
                    nArray[j][i]=level+1;
                    return;
                }
                dfs(k, i, j, level+1);
            }
        }
    }
    public void cleanBoolean(){
        for(int i =0; i<check.length; i++)
            check[i]=false;
    }
    public Boolean[] initBoolean(int n){
        Boolean[] booleans = new Boolean[n+1];
        for(int i=0; i<=n; i++)
            booleans[i]=false;
        return booleans;
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
