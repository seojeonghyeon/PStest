package backjoon17073;

import java.io.*;
import java.util.LinkedList;

public class Main {

    private static class Node{
        public Integer name;
        LinkedList<Node> adjacencyNodes;
        public Node(Integer name){
            this.name = name;
            adjacencyNodes = new LinkedList<>();
        }
    }

    private double solution(int N, int W, Node[] nodes){
        return (double)W/rainwaterOnTree(N, nodes);
    }

    //leaf N
    private int rainwaterOnTree(int N, Node[] nodes){
        int leafNodeCount = 0;
        for(int i=2; i<=N; ++i) if(nodes[i].adjacencyNodes.size()==1) leafNodeCount++;
        return leafNodeCount;
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = in.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int W = Integer.parseInt(input[1]);

        Node[] nodes = new Node[N+1];
        for(int i=1; i<N+1; ++i) nodes[i] = new Node(i);
        for(int i=0; i<N-1; ++i){
            String[] readline = in.readLine().split(" ");
            nodes[Integer.parseInt(readline[0])].adjacencyNodes.add(nodes[Integer.parseInt(readline[1])]);
            nodes[Integer.parseInt(readline[1])].adjacencyNodes.add(nodes[Integer.parseInt(readline[0])]);
        }

        out.write(String.format("%.10f", main.solution(N, W, nodes)) + "\n");
        out.flush();
        in.close();
        out.close();
    }
}
