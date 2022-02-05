package backjoon5052;

import java.io.*;
import java.util.Arrays;

public class Main {

    public String solution(String[] phoneBook) {
        Arrays.sort(phoneBook);
        for(int i=0; i<phoneBook.length-1; i++){
            if(phoneBook[i+1].startsWith(phoneBook[i])) return "NO";
        }
        return "YES";
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(in.readLine());
        String[] result = new String[t];
        for(int i=0; i<t; ++i){
            int n = Integer.parseInt(in.readLine());
            String[] phoneBook = new String[n];
            for(int j=0; j<n; ++j) phoneBook[j] = in.readLine();
            result[i] = main.solution(phoneBook);
        }
        for(int i=0; i<t; ++i)
            out.write(result[i] + "\n");
        out.flush();
        in.close();
        out.close();

    }
}
