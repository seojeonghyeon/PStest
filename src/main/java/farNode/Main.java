package farNode;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public void solution(){
        long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
        int result = solution(6, new int[][] {{3,6}, {4,3}, {3,2}, {1,3}, {1,2}, {2,4}, {5,2}});
        System.out.println(result);
        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
        long secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
        System.out.println("시간차이(ms) : "+secDiffTime);
    }
    public int solution(int n, int[][] edge) {
        Graph graph = new Graph(n);
        for(int i = 0; i < edge.length; i++){
            graph.addEdge(edge[i][0], edge[i][1]);
        }
        return graph.farNode(1);
    }
    class Graph {
        class Node {
            int data;
            LinkedList<Node> adjacent;
            boolean marked;
            int level;

            Node(int data) {
                this.data = data;
                this.marked = false;
                this.level = 0;
                adjacent = new LinkedList<Node>();
            }
        }
        Node[] nodes;
        Queue<Node> queue;
        Graph(int size) {
            nodes = new Node[size+1];
            for (int i = 0; i < size+1; i++) {
                nodes[i] = new Node(i);
            }
        }

        void addEdge(int i1, int i2) {
            Node n1 = nodes[i1];
            Node n2 = nodes[i2];
            if (!n1.adjacent.contains(n2)) {
                n1.adjacent.add(n2);
            }
            if (!n2.adjacent.contains(n1)) {
                n2.adjacent.add(n1);
            }
        }

        int farNode(int n){
            Node root = nodes[n];
            queue = new LinkedList<>();
            int maxLevel = 0;
            int count = 0;
            root.marked = true;
            queue.add(root);
            while(!queue.isEmpty()){
                Node node = queue.remove();
                if(maxLevel < node.level) maxLevel = node.level;
                for(Node r : node.adjacent){
                    if(!r.marked){
                        r.level = node.level+1;
                        r.marked = true;
                        queue.add(r);
                    }
                }
            }
            for(int i = 0; i< nodes.length; i++)
                if(nodes[i].level == maxLevel) count++;
            return count;
        }
    }


    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
