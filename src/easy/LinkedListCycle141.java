package easy;

import java.util.Set;
import java.util.HashSet;

class MyListNode {
    int val;
    MyListNode next;
    MyListNode(int val, MyListNode next) { this.val = val; this.next = next; }

    public String toString(){
        return " "+ this.val;
    }
}


public class LinkedListCycle141 {
    public static boolean hasCycle(MyListNode head) {

        Set<MyListNode> set = new HashSet<>();

        int counter = 0;

        while(true){

            if(set.contains(head))
                return true;

            set.add(head);

            if(head.next!=null)
                head = head.next;
            else
                return false;

            counter++;
        }
    }
//3 2 0 -4
    public static void main(String[] args) {
        MyListNode node4 = new MyListNode(4, null);
        MyListNode node3 = new MyListNode(3, node4);
        MyListNode node2 = new MyListNode(2, node3);
        MyListNode node1 = new MyListNode(1, node2);
        node4.next = node2;

        System.out.println(hasCycle(node1));
    }
}
