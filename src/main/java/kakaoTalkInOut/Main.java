package kakaoTalkInOut;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;

public class Main {

    public void solution(){
        long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
        String[] result = solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"});
        for(String i : result)
            System.out.println(i);
        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
        long secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
        System.out.println("시간차이(ms) : "+secDiffTime);
    }

    public String[] solution(String[] record) {
        String[] answer;
        int resultCount = 0;
        LinkedList<Node> linkedList = new LinkedList<>();
        HashMap<String, String> id = new HashMap<>();

        for(String str : record){
            String[] subStr = str.split(" ");
            if(subStr[0].equals("Enter") || subStr[0].equals("Change")) {
                id.put(subStr[1], subStr[2]);
            }
            if(!subStr[0].equals("Change")){
                Node node = new Node(subStr[1], subStr[0]);
                linkedList.add(node);
                resultCount++;
            }

        }

        int i=0;
        resultCount = resultCount;
        answer = new String[resultCount];
        for(Node node : linkedList){
            if(node.action.equals("Enter")){
                answer[i]=id.get(node.id)+"님이 들어왔습니다.";
            }else if(node.action.equals("Leave")){
                answer[i]=id.get(node.id)+"님이 나갔습니다.";
            }
            i++;
        }
        return answer;
    }

    class Node{
        String id;
        String action;
        Node(String id, String action){
            this.id=id;
            this.action= action;
        }
    }
    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
