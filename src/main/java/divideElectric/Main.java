package divideElectric;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public void solution(){
        long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
        int result = solution(4, new int[][]{{1,2},{2,3},{3,4}});
//        for(String i : result)
        System.out.println(result);
        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
        long secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
        System.out.println("시간차이(ms) : "+secDiffTime);
    }

    private class Node{
        int n;
        LinkedList<Node> nodes;
        public Node(int n){
            this.n = n;
            nodes = new LinkedList<>();
        }
    }

    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        Node[] nodes = new Node[n+1];
        for(int i=1; i<n+1; i++)
            nodes[i] = new Node(i);
        for(int i=0; i<wires.length; i++){
            nodes[wires[i][0]].nodes.add(nodes[wires[i][1]]);
            nodes[wires[i][1]].nodes.add(nodes[wires[i][0]]);
        }
        for(int i=1; i<n+1; i++){
            if(nodes[i].nodes.size() > 1){
                for(int j=0; j<nodes[i].nodes.size(); j++){
                    Node getNode1 = nodes[i].nodes.get(j);
                    int k = 0;
                    for(k=0; k<getNode1.nodes.size(); k++){
                        if(getNode1.nodes.get(k).n==nodes[i].n)
                            break;
                    }
                    Node getNode2=nodes[getNode1.n].nodes.get(k);

                    nodes[i].nodes.remove(j);
                    nodes[getNode1.n].nodes.remove(k);

                    int result = bfs(n, nodes, i);
                    answer = Math.abs(n-result-result) < answer ? Math.abs(n-result-result) : answer;
                    nodes[i].nodes.add(j, getNode1);
                    nodes[getNode1.n].nodes.add(k, getNode2);
                }
            }
        }

        return answer;
    }
    public int bfs(int n, Node[] nodes, int start){
        int nodeCount = 0;
        boolean[] check = new boolean[n+1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        while(!queue.isEmpty()){
            int cur = queue.poll();
            check[cur]=true;
            for(Node node : nodes[cur].nodes){
                if(!check[node.n]){
                    queue.offer(node.n);
                }
            }
            nodeCount++;
        }
        return nodeCount;
    }


    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
