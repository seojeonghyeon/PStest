package writeAndPrintMethod;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Main main = new Main();

        //출력방식 : 기본
//        Scanner in = new Scanner(System.in);
        //int N = in.nextInt();

        //Scanner 보다 빠름
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int N = Integer.parseInt(br.readLine());
//        br.close();


        //출력이 많은 경우 : 객체를 하나로 연결하여 출력하여 시간 단축
//        StringBuilder sb = new StringBuilder();
//
//        for (int i = 1; i <= N; i++) {
//            for (int j = 1; j <= i; j++) {
//                sb.append('*');
//            }
//            sb.append('\n');
//        }
//        System.out.print(sb);


        //출력할 문자가 많은 경우 : 각기 출력해야하는 경우
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        int N = Integer.parseInt(br.readLine());
//        br.close();
//
//        for (int i = 1; i <= N; i++) {
//            for (int j = 1; j <= i; j++) {
//                bw.write('*');
//            }
//            bw.newLine();
//        }
//        bw.flush();
//        bw.close();
    }
}
