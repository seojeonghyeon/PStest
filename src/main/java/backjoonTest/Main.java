package backjoonTest;

import java.io.*;
import java.util.*;

public class Main {

    private static class Node{
        public int name;
        LinkedList<Node> adjacencyNodes;
        public Node(int name){
            this.name = name;
            adjacencyNodes = new LinkedList<>();
        }
    }

    private int solution(int N, int K, ){

    }



    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = in.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int W = Integer.parseInt(input[1]);

        Node[] nodes = new Node[N+1];
        for(int i=0; i<N-1; ++i){
            String[] read
        }

        out.write(main.solution(N, W) + "\n");
        out.flush();
        in.close();
        out.close();
    }
}
