package backjoon7568;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static class Person{
        int height;
        int weight;
        public Person(int height, int weight){
            this.height = height;
            this.weight = weight;
        }
    }
    public int[] solution(int N, Person[] people) {
        int[] result = new int[N];
        int count;
        for(int i=0; i<N; ++i){
            count=0;
            for(int j=0; j<N; ++j){
                if(people[i].weight < people[j].weight && people[i].height < people[j].height)
                    count++;
            }
            result[i]=count+1;
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(in.readLine());
        Person[] people = new Person[N];
        StringTokenizer stringTokenizer;
        for(int i=0; i<N; ++i){
            stringTokenizer = new StringTokenizer(in.readLine());
            people[i] = new Person(
                    Integer.parseInt(stringTokenizer.nextToken()),
                    Integer.parseInt(stringTokenizer.nextToken()));
        }
        for(int i : main.solution(N,people)) out.write(i + "\n");
        out.flush();
        in.close();
        out.close();
    }
}
