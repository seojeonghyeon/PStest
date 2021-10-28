package addTwoNumbers;


import java.io.IOException;

public class Main {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {
        }
        ListNode(int a, int b, int c) {
            this.val=a;
            this.next.val=b;
            this.next.next.val=c;
        }
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public void solution(){
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return calTwoNumber(l1, l2, 0);
    }
    public ListNode calTwoNumber(ListNode l1, ListNode l2, int carry){
        if(l1==null && l2==null && carry==0){
            return null;
        }
        if(l1 ==null){
            l1 = new ListNode();
            l1.val=0;
        }
        if(l2 ==null){
            l2 = new ListNode();
            l2.val=0;
        }
        ListNode listNode = new ListNode();
        int temp = (l1.val+l2.val+carry)/10;
        listNode.val = (l1.val+l2.val+carry)%10;
        listNode.next = calTwoNumber(l1.next, l2.next, temp);
        return listNode;
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
