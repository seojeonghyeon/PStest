package kakaobankone;

import java.io.IOException;

public class Main {

    public void solution(){
        long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
        int result = solution(new int[][]{{200, 910, 93}, {400, 1600, 188}, {655, 7300, 281}, {0, 15372, 435}}, 450);
//        for(String i : result)
            System.out.println(result);
        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
        long secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
        System.out.println("시간차이(ms) : "+secDiffTime);
    }

    class Node{
        int kWh;
        int basicFee;
        int perKWh;
        int perKWhMax;
        public Node(int kWh, int basicFee, int perKWh, int section){
            this.kWh=kWh;
            this.basicFee=basicFee;
            this.perKWh=perKWh;
            this.perKWhMax=section*perKWh;
        }
    }
    public int solution(int[][] fees, int usage) {
        int answer = 0;
        int check = 0;
        Node[] nodes = new Node[fees.length];
        fees[fees.length-1][0]=10000;
        nodes[0]=new Node(fees[0][0],fees[0][1],fees[0][2],fees[0][0]);
        for(int i=1; i< fees.length; i++){
            nodes[i]=new Node(fees[i][0],fees[i][1],fees[i][2],fees[i][0]-fees[i-1][0]);
        }
        if(nodes[0].kWh >= usage){
            return nodes[0].basicFee+(nodes[0].perKWh*usage);
        }
        for(int i=1; i< nodes.length; i++){
            if(nodes[i-1].kWh < usage && usage <= nodes[i].kWh){
                check = i;
                answer = nodes[i].basicFee;
            }
        }
        for(int i=0; i<=check; i++){
            if(check==i){
                answer += nodes[i].perKWh*(usage-nodes[i-1].kWh);
            }else{
                answer += nodes[i].perKWhMax;
            }
        }
        return answer;
    }


    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
