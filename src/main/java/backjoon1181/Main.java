package backjoon1181;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public String[] solution(String[] words) {
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() == o2.length()){
                    return o1.compareTo(o2);
                }
                return o1.length() - o2.length();
            }
        });
        for(int i=0; i<words.length-1; ++i){
            if(words[i].equals(words[i+1])) words[i]="";
        }
        return words;
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(in.readLine());
        String[] words = new String[N];
        for(int i=0; i<N; ++i){
            words[i] = in.readLine();
        }

        for(String word : main.solution(words)) {
            if(!word.equals("")) out.write(word + "\n");
        }
        out.flush();
        in.close();
        out.close();

    }
}
