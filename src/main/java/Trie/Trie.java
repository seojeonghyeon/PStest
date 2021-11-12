package Trie;

import TrieNode.TrieNode;

import java.util.ArrayList;

public class Trie {
    //트라이의 루트
    private TrieNode root;

    /* 문자열 리스트를 인자로 받은 뒤에, 이 모든 문자열 리스트를 저장할
     * 자료구조인 트라이를 만든다.
     */
    public Trie(ArrayList<String> list){
        root = new TrieNode();
        for(String word : list){
            root.addWord(word);
        }
    }

    /* 문자열 리스트를 인자로 받은 뒤에, 이모든 문자열 리스트를 저장할 자료구조인 트라이를 만든다. */
    public Trie(String[] list){
        root = new TrieNode();
        for(String word : list){
            root.addWord(word);
        }
    }

    /* 인자로 넘어온 prefix가 트라이 안에 들어 있는 문자열의 접두사를 실제로 만족하는 지 그렇지 않은 지 확인한다. */
    public boolean contains(String prefix, boolean exact){
        TrieNode lastNode = root;
        int i = 0;
        for(i=0; i <prefix.length(); i++){
            lastNode = lastNode.getChild(prefix.charAt(i));
            if(lastNode == null){
                return false;
            }
        }
        return !exact || lastNode.terminates();
    }

    public boolean contains(String prefix){
        return contains(prefix, false);
    }

    public TrieNode getRoot(){
        return root;
    }
}
