package rockScissorsPapper;

import java.util.Scanner;

public class Main {

    public void solution(int[] nArrayA, int[] nArrayB) {
        for(int i =0; i<nArrayA.length;i++) {
            int result = nArrayA[i]-nArrayB[i];
            if((result == 1)||(result == -2))
                System.out.println("A");
            else if((result == -1)||(result == 2))
                System.out.println("B");
            else
                System.out.println("D");
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int nArrayA[] = new int[n];
        int nArrayB[] = new int[n];
        for(int i=0; i<n; i++) {
            nArrayA[i]=in.nextInt();
        }
        for(int i=0; i<n; i++) {
            nArrayB[i]=in.nextInt();
        }
        main.solution(nArrayA, nArrayB);
    }
}