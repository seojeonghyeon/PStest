package printStar;

import java.util.Scanner;

public class Main {

    public int solution(int N, int M, int[] Nlist){
        int result =0;
        int point=1;
        int lt=2;
        int rt=3;
        while((point+2)<=N){
            int sum = Nlist[point] + Nlist[lt] + Nlist[rt];
            if( sum<=M && result<sum ){
                result = sum;
            }
            if(result==M){
                break;
            }
            if(rt==N){
                lt=lt+1;
                rt=lt+1;
            }
            if(lt==N){
                point=point+1;
                lt=point+1;
                rt=point+2;
            }
            if(rt!=N && lt!=N){
                rt++;
            }
        }
        return result;
    }
    public static void main(String[] args)  {
        Main main = new Main();
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[] Nlist = new int[N+1];
        for(int i=1; i<=N;i++)
            Nlist[i]=scanner.nextInt();
        System.out.print(main.solution(N,M,Nlist));
    }
}
