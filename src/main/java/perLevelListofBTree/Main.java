package perLevelListofBTree;

import java.util.ArrayList;
import java.util.LinkedList;


class Tree {
    class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    Node root;

    Tree(int size) {
        root = makeBST(0, size - 1);
    }

    Node makeBST(int start, int end) {
        if (start > end) return null;
        int mid = (start + end) / 2;
        Node node = new Node(mid);
        node.left = makeBST(start, mid - 1);
        node.right = makeBST(mid + 1, end);
        return node;
    }

    ArrayList<LinkedList<Node>> BSTtoList() {
        ArrayList<LinkedList<Node>> lists = new ArrayList<>();
        BSTtoList(root, lists, 0);
        return lists;
    }

    void BSTtoList(Node root, ArrayList<LinkedList<Node>> lists, int level) {
        if (root == null) return;
        LinkedList<Node> list = null;
        if (lists.size() == level) {
            list = new LinkedList<>();
            lists.add(list);
        } else {
            list = lists.get(level);
        }
        list.add(root);
        BSTtoList(root.left, lists, level + 1);
        BSTtoList(root.right, lists, level + 1);
    }

    ArrayList<LinkedList<Node>> BSTtoList2() {
        ArrayList<LinkedList<Node>> result = new ArrayList<>();
        LinkedList<Node> current = new LinkedList<>();
        if (root != null) {
            current.add(root);
        }
        while (current.size() > 0) {
            result.add(current);
            LinkedList<Node> parents = current;
            current = new LinkedList<>();
            for (Node parent : parents) {
                if (parent.left != null) current.add(parent.left);
                if (parent.right != null) current.add(parent.right);
            }
        }
        return result;
    }

    void printList(ArrayList<LinkedList<Node>> arr) {
        for (LinkedList<Node> list : arr) {
            for (Node node : list)
                System.out.print(node.data + " ");
            System.out.println();
        }
    }
}
public class Main {
    public static void main(String[] args){
        Tree t = new Tree(10);
        t.printList(t.BSTtoList());
        t.printList(t.BSTtoList2());
        /*
         *            4
         *           / \
         *          /   \
         *         /     \
         *        1       7
         *       / \     / \
         *      0   2   5   8
         *           \   \   \
         *            3   6   9
         */
    }
}
