package printBigNumber;

import java.util.Scanner;

public class Main {

    public String solution(int[] nArray) {
        String answer = ""+nArray[0];
        for(int i=1; i<nArray.length;i++)
            if(nArray[i]>nArray[i-1]) answer+=" "+nArray[i];
        return answer;

    }

    public static void main(String[] args) {
        Main main = new Main();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int nArray[] = new int[n];
        for(int i=0; i<n; i++) {
            nArray[i]=in.nextInt();
        }
        System.out.println(main.solution(nArray));
    }

}