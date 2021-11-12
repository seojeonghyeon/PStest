package TrieNode;

import java.util.HashMap;

public class TrieNode {
    /* 트라이에서 해당 노드의 자식 노드 */
    private HashMap<Character, TrieNode> children;
    private boolean termiantes = false;

    /* 해당 노드의 데이터로 문자를 저장한다. */
    private char character;

    /* 비어 있는 트라이 노드를 생성한 뒤에 그 자식 노드 리스트들을 비어 있는
     * 해시맵으로 초기화한다. 트라이의 루트 노드를 생성할 때만 사용한다. */
    public TrieNode(){
        children = new HashMap<Character, TrieNode>();
    }

    /* 트라이의 노드를 생성한 뒤에 character를 노드의 값으롲 저장한다.
     * 그 자식 노드 리스트들을 비어 있는 해시맵으로 초기화 한다.
     */
    public TrieNode(char character){
        this();
        this.character = character;
    }

    /* 해당 노드에 저장되어 있는 문자 데이터를 반환한다. */
    public char getChar(){
        return character;
    }

    /* word를 트라이에 추가한다.
     * 그리고 재귀적으로 자식노드를 만든다.
     */
    public void addWord(String word){
        if(word == null || word.isEmpty()){
            return;
        }

        char firstChar = word.charAt(0);

        TrieNode child = getChild(firstChar);
        if(child == null){
            child = new TrieNode(firstChar);
            children.put(firstChar, child);
        }

        if(word.length() > 1){
            child.addWord(word.substring(1));
        }else{
            child.setTerminates(true);
        }
    }

    /* 해당 노드의 자식 노드 중에서 문자c를 데이터로 저장하고 있는 자식노드를
     * 찾는다. 그런 자식이 트라이 내에 존재하지 않으면 null을 반환한다.
     */
    public TrieNode getChild(char c){
        return children.get(c);
    }

    /* 현재 노드가 단어의 끝을 나타내는지 아닌지를 알려준다. */
    public boolean terminates(){
        return termiantes;
    }

    /* 현재 노드가 단어의 끝인지 아닌지를 세팅한다. */
    public void setTerminates(boolean t){
        termiantes = t;
    }
}
