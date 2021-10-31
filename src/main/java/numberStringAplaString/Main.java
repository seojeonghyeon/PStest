package numberStringAplaString;

import java.io.IOException;

public class Main {
    public void solution(){
        long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
        System.out.println(solution("three1three2three3threethreethree"));
        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
        long secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
        System.out.println("시간차이(ms) : "+secDiffTime);
    }
    public int solution(String s) {
        int answer = 0;
        StringBuilder sb = new StringBuilder("");
        int len = s.length();
        String[] digits = {"0","1","2","3","4","5","6","7","8","9"};
        String[] alphabets = {"zero","one","two","three","four","five","six","seven","eight","nine"};

        for(int i=0; i<10; i++){
            s = s.replaceAll(alphabets[i],digits[i]);
        }

        return Integer.parseInt(s);
    }

//    public int solution(String s) {
//        int sum = 0;
//        HashMap<Integer, Integer> aplaNumber = aplaNumberSet();
//        StringBuilder stringBuilder = new StringBuilder();
//        char[] sArray = s.toCharArray();
//        for(char c : sArray){
//            sum+=(int)c;
//            sum *=10;
//            if(aplaNumber.containsKey(sum)){
//                stringBuilder.append(aplaNumber.get(sum));
//                sum=0;
//            }else if(48 <= (int)c && (int)c <=57){
//                stringBuilder.append(c);
//                sum=0;
//            }
//        }
//
//        return Integer.parseInt(stringBuilder.toString());
//    }
//    public HashMap<Integer, Integer> aplaNumberSet(){
//        HashMap<Integer, Integer> hashMap = new HashMap<>();
//        String[] strings = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
//        for (int i=0; i<strings.length; i++){
//            int sum = 0;
//            for(int j=0; j<strings[i].length(); j++){
//                sum += strings[i].charAt(j);
//                sum *= 10;
//            }
//            hashMap.put(sum, i);
//        }
//        return hashMap;
//    }


    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
