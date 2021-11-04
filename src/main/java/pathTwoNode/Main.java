package pathTwoNode;

import java.util.LinkedList;

public class Main {
    class Graph{
        public Node[] nodes;

        public Node[] getNodes() {
            return nodes;
        }
    }

    class Node{
        public State state;
        public Node[] adjacent;

        public Node[] getAdjacent() {
            return adjacent;
        }
    }

    enum State{ Unvisited, Visited, Visiting; }

    boolean search(Graph g, Node start, Node end){
        if(start == end) return true;
        //Queue처럼 동작
        LinkedList<Node> q = new LinkedList();
        for(Node u : g.getNodes()){
            u.state = State.Unvisited;
        }
        start.state = State.Visiting;
        q.add(start);
        Node u;
        while(!q.isEmpty()){
            u = q.removeFirst();
            if(u != null){
                for(Node v : u.getAdjacent()){
                    if(v.state == State.Unvisited){
                        if(v == end){
                            return true;
                        }else{
                            v.state = State.Visiting;
                            q.add(v);
                        }
                    }
                }
                u.state = State.Visited;
            }
        }
        return false;
    }

}
