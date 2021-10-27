package programmers_phone_book;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;


public class Main {

    class HashTable{
        class Node{
            char key;
            String value;
            public Node(char key,String value){
                this.key=key;
                this.value =value;
            }
            String value(){
                return value;
            }
            void value(String value){
                this.value=value;
            }
        }
        LinkedList<Node>[] data;
        HashTable(int size){
            this.data = new LinkedList[size];
        }
        int getHashCode(char key){
            return key;
        }
        int convertToIndex(int hashcode){
            return hashcode % data.length;
        }
        Node searchKey(LinkedList<Node> list, char key){
            if(list == null){
                return null;
            }
            for(Node node : list){
                if(node.key==key){
                    return node;
                }
            }
            return null;
        }
        void put(char key, String value){
            int hashcode = getHashCode(key);
            int index = convertToIndex(hashcode);
            System.out.println(key + ", hashcode("+ hashcode + "), index("+index+")");
            LinkedList<Node> list =data[index];
            if(list == null){
                list = new LinkedList<Node>();
                data[index] = list;
            }
            Node node = searchKey(list, key);
            if(node == null){
                list.addLast(new Node(key, value));
            }else{
                node.value(value);
            }
        }
        String get(char key) {
            int hashcode = getHashCode(key);
            int index = convertToIndex(hashcode);
            LinkedList<Node> list = data[index];
            Node node = searchKey(list, key);
            return node == null ? "Not found" : node.value();
        }
    }

    public void solution(String[] list) {
        String str = sumString(list);
        int[] strHashTable = hashTable(str);
        int[] strlength = new int[list.length];
        int[] strSumHash = new int[list.length];
        int sum = 0;
        int k=0;
        int count =0;
        for(int i=1; i<strHashTable.length; i++){
            if(strHashTable[i]!=0){
                sum+=strHashTable[i];
            }else{  //==0
                strSumHash[k]=sum;
                strlength[k]=list[k].length();
                sum=0;
                k++;
            }
        }
        sum=0;
        for(int i=0; i<strHashTable.length; i++){
            if(strHashTable[i]!=0) {
                sum+=strHashTable[i];
                for (int j = 0; j < strSumHash.length; j++) {
                    if(strSumHash[j]==sum){
                        count++;
                    }
                }
            }
        }
    }
    public int[] hashTable(String str){
        int i=0;
        int[] strHashTable = new int[str.length()];
        for(char s : str.toCharArray()){
            if(s==' '){
                strHashTable[i] = 0;
            }else {
                int n = s;
                strHashTable[i] = n;
            }
            i++;
        }
        return strHashTable;
    }
    public String sumString(String[] list){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i< list.length; i++){
            sb.append(" ");
            sb.append(list[i]);
        }
        return sb.toString();
    }


    public static void main(String[] args) throws IOException {
        Main main = new Main();
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        String[] Nlist = new String[N];
        for(int i=0; i<N; i++) {
            Nlist[i]= scanner.next();
        }
        main.solution(Nlist);
    }
}
