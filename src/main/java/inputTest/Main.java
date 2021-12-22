package inputTest;

import java.io.IOException;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] array = new int[N];
        for(int i =0; i<array.length; i++){
            array[i]=sc.nextInt();
        }
        long answer = 0;
        long lt=1;
        long rt = 0;
        for(int i = 0; i<array.length; i++) if(array[i] > rt) rt = array[i];
        rt = rt*M;
        answer = rt;
        while(lt < rt){
            long sum = 0;
            long mid = (lt+rt)/2;
            for(int i : array) sum+=(mid/i);
            if(sum<M) {
                lt=mid+1;
            }else{
                answer = answer > mid ? mid : answer;
                rt=mid;
            }
        }
        System.out.print(answer);
    }
}
