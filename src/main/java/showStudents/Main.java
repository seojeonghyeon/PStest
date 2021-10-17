package showStudents;

import java.util.Scanner;

public class Main {

    public int solution(int[] nArray) {
        int answer=1;
        int tmp=nArray[0];
        for(int i =1; i<nArray.length; i++) {
            if(tmp<nArray[i]) {
                tmp=nArray[i];
                answer++;
            }
        }

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