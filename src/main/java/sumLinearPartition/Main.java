package sumLinearPartition;

import java.io.IOException;
import java.util.Scanner;

/*
* 연속된 부분 구간 합
* -7, 4 -3, 6,3, -8, 3, 4
*/
public class Main {

    public void solution(int[] Nlist){
        System.out.println(fastMaxSum(Nlist, 0, Nlist.length));
    }
    public int fastMaxSum(int[] Nlist, int lo, int hi){
        //구간의 길이가 1일 경우
        if(lo == hi) return Nlist[lo];

        //배열을 A[lo..mid], A[mid..hi]의 두조각으로 나눈다
        int mid = (lo+hi)/2;
        //두부분에 모두 걸쳐 있는 최대 합 구간을 찾는다.
        //이 구간은 A[i..mid]와 A[mid+1..j]형태를 갖는 구간의 합으로 이루어진다.
        //A[i..mid]현태를 갖는 최대 구간을 찾는다.
        int left=Integer.MIN_VALUE;
        int right=Integer.MIN_VALUE;
        int sum=0;
        for(int i = mid; i >= lo; --i){
            sum += Nlist[i];
            left = left >= sum ? left : sum;
        }
        //A[mid+1..j]형태를 갖는 최대 구간을 찾는다.
        sum = 0;
        for(int j = mid+1; j <= hi; ++j){
            sum += Nlist[j];
            right = right >= sum ? right : sum;
        }

        //최대 구간이 두 조각 중 하나에만 속해있는 경우의 답을 재귀호출로 찾는다.
        int l = fastMaxSum(Nlist, lo, mid);
        int r = fastMaxSum(Nlist, mid+1, hi);
        int single = l >= r ? l : r;
        return (left+right) >= single ? (left+right) : single;

    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[] Nlist = new int[N];
        for(int i=0; i < N; i++)
            Nlist[i]=scanner.nextInt();
        main.solution(Nlist);
    }
}
