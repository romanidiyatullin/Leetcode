package medium;

import java.util.Set;
import java.util.HashSet;

public class LinkedListCycleII142 {
    public static ListNode detectCycle(ListNode head) {

        if(head == null || head.next == null)
            return null;

        Set<ListNode> set = new HashSet<>();
        ListNode node = head;

        while(node!=null){
            if(!set.add(node))
                return node;
            node = node.next;
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3)));
        System.out.println(detectCycle(head));
        head.next.next=head;
        System.out.println(detectCycle(head));


    }
}
