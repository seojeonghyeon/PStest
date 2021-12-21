package treeTrioMid;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public void solution(){
        long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
        int result = solution(4, new int[][]{{1,2},{2,3},{3,4}});
//        for(int i : result)
            System.out.println(result);
        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
        long secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
        System.out.println("시간차이(ms) : "+secDiffTime);
    }

    Node[] nodes;
    public class Node{
        int edge, level;
        LinkedList<Node> edges;
        public Node(int edge){
            this.edge=edge;
            this.level = 0;
            edges = new LinkedList<>();
        }
    }

    public int solution(int n, int[][] edges) {
        initNode(n);
        for(int i=0; i<edges.length; i++){
            nodes[edges[i][0]].edges.add(nodes[edges[i][1]]);
            nodes[edges[i][1]].edges.add(nodes[edges[i][0]]);
        }
        return searchFarNode(n);
    }
    public int searchFarNode(int n){
        int start = 1;
        int count = 0;

        int[] result = bfs(start, n);
        for(int i=2; i<n+1; i++) if(result[i]>result[start]) start=i;

        int max = start;
        result = bfs(start, n);
        for(int i=1; i<n+1; i++) if(result[i]>result[start]) start=i;
        for(int i=1; i<n+1; i++) if(result[start]==result[i]) count++;
        if(count >= 2) return result[start];

        count=0;
        result = bfs(start, n);
        for(int i=1; i<n+1; i++) if(result[i]>result[start]) start=i;
        for(int i=1; i<n+1; i++) if(result[start]==result[i]) count++;
        if(count >= 2) return result[start];
        return result[start]-1;
    }
    public int[] bfs(int start, int n){
        int[] result = new int[n+1];
        Boolean[] check = initBoolean(n);
        Queue<Node> Q = new LinkedList<>();
        Q.offer(nodes[start]);
        check[start] = false;
        nodes[start].level=0;
        while(!Q.isEmpty()){
            Node cur = Q.poll();
            result[cur.edge]=cur.level;
            for(Node node : cur.edges){
                if(check[node.edge]){
                    Q.add(node);
                    node.level = cur.level+1;
                    check[node.edge]=false;
                }
            }
        }
        return result;
    }
    public void initNode(int n){
        nodes = new Node[n+1];
        for(int i=0; i<n+1; i++) nodes[i]=new Node(i);
    }
    public Boolean[] initBoolean(int n){
        Boolean[] check = new Boolean[n+1];
        for(int i=0; i<n+1; i++) check[i]=true;
        return check;
    }


    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
