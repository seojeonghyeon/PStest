package pathTwoNode;

import java.util.LinkedList;

public class Main {
//    class Graph{
//        public Node[] nodes;
//
//        public Node[] getNodes() {
//            return nodes;
//        }
//    }
//
//    class Node{
//        public State state;
//        public Node[] adjacent;
//
//        public Node[] getAdjacent() {
//            return adjacent;
//        }
//    }
//
//    enum State{ Unvisited, Visited, Visiting; }
//
//    boolean search(Graph g, Node start, Node end){
//        if(start == end) return true;
//        //Queue처럼 동작
//        LinkedList<Node> q = new LinkedList();
//        for(Node u : g.getNodes()){
//            u.state = State.Unvisited;
//        }
//        start.state = State.Visiting;
//        q.add(start);
//        Node u;
//        while(!q.isEmpty()){
//            u = q.removeFirst();
//            if(u != null){
//                for(Node v : u.getAdjacent()){
//                    if(v.state == State.Unvisited){
//                        if(v == end){
//                            return true;
//                        }else{
//                            v.state = State.Visiting;
//                            q.add(v);
//                        }
//                    }
//                }
//                u.state = State.Visited;
//            }
//        }
//        return false;
//    }
static class Graph{
        class Node{
            int data;
            boolean marked;
            LinkedList<Node> adjacent;
            Node (int data){
                this.data = data;
                this.marked = false;
                this.adjacent = new LinkedList<Node>();
            }
        }

        Node[] nodes;

        Graph(int size){
            nodes = new Node[size];
            for(int i=0; i<size; i++){
                nodes[i] = new Node(i);
            }
        }

        void addEdge(int i1, int i2){
            Node n1 = nodes[i1];
            Node n2 = nodes[i2];
            if(!n1.adjacent.contains(n2)){
                n1.adjacent.add(n2);
            }
            if(!n2.adjacent.contains(n1)){
                n2.adjacent.add(n1);
            }
        }
        void initMarks(){
            for(Node n : nodes){
                n.marked = false;
            }
        }

        boolean search(int i1, int i2){
            return search(nodes[i1], nodes[i2]);
        }

        boolean search(Node start, Node end){
            initMarks();
            LinkedList<Node> q = new LinkedList<>();
            q.add(start);
            while(!q.isEmpty()){
                Node root = q.removeFirst();
                if(root==end){
                    return true;
                }
                for(Node n : root.adjacent){
                    if(n.marked == false){
                        n.marked = true;
                        q.add(n);
                    }
                }
            }
            return false;
        }
    }
    /*
     *   0
     *  /
     * 1 -- 3    7
     * |  / | \ /
     * | /  |  5
     * 2 -- 4   \
     *           6 - 8
     */
    public static void main(String[] args){
        Graph g = new Graph(9);
        g.addEdge(0,1);
        g.addEdge(1,2);
//        g.addEdge(1,3);
        g.addEdge(2,4);
        g.addEdge(2,3);
        g.addEdge(3,4);
        g.addEdge(3,5);
        g.addEdge(5,6);
        g.addEdge(5,7);
        g.addEdge(6,8);
        System.out.println(g.search(1,8));

    }

}
