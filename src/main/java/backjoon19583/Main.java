package backjoon19583;

import java.io.*;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        HashSet<String> beforeHashSet = new HashSet<>();
        HashSet<String> afterHashSet = new HashSet<>();
        HashSet<String> nameHashSet = new HashSet<>();
        int answer = 0;

        String[] input = in.readLine().split(" ");
        String S = input[0];
        String E = input[1];
        String Q = input[2];

        String str = null;
        while((str=in.readLine()) != null){
            input = str.split(" ");
            String time = input[0];
            String nickname = input[1];

            nameHashSet.add(nickname);
            if(S.compareTo(time) >= 0){
                beforeHashSet.add(nickname);
            }else if((E.compareTo(time)<=0) && (Q.compareTo(time)>=0)){
                afterHashSet.add(nickname);
            }
        }
        for(String nickname : nameHashSet){
            if(beforeHashSet.contains(nickname) && afterHashSet.contains(nickname)) answer+=1;
        }

        out.write(answer + "\n");
        out.flush();
        in.close();
        out.close();
    }
}
