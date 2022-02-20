package backjoonTest;

import java.io.*;
import java.util.*;

public class Main {


    private static int hourS;
    private static int minuteS;
    private static int hourE;
    private static int minuteE;
    private static int hourQ;
    private static int minuteQ;

    private class Chat implements Comparable<Chat>{
        public String time;
        public String nickname;
        public int where;

        @Override
        public int compareTo(Chat o) {
            String[] thisArray = this.time.split(":");
            String[] objectArray = o.time.split(":");
            if(thisArray[0].equals(objectArray[0])){
                return Integer.parseInt(thisArray[1])-Integer.parseInt(objectArray[1]);
            }
            return Integer.parseInt(thisArray[0])-Integer.parseInt(objectArray[0]);
        }

        public int compareToWhere(String S, String E, String Q){
            String[] thisArray = this.time.split(":");
        }
    }
    public int solution() {
        return 0;
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = in.readLine().split(" ");
        String S = input[0];
        String E = input[1];
        String Q = input[2];

        String[] SArray = S.split(":");
        String[] EArray = E.split(":");
        String[] QArray = Q.split(":");

        hourS = Integer.parseInt(SArray[0]);
        minuteS = Integer.parseInt(SArray[1]);
        hourE = Integer.parseInt(EArray[0]);
        minuteE = Integer.parseInt(EArray[1]);
        hourQ = Integer.parseInt(QArray[0]);
        minuteQ = Integer.parseInt(QArray[1]);




        String str;
        while((str=in.readLine()) != null){
            input = str.split(" ");
            String time = input[0];
            String nickname = input[1];

        }

        out.write(main.solution() + "\n");
        out.flush();
        in.close();
        out.close();
    }
}
