package medium;

import java.util.Map;
import java.util.HashMap;

public class RemoveDuplicatesFromUnsortedLinkedList1836 {

    public static ListNode deleteDuplicatesUnsorted(ListNode head) {

        if(head == null || head.next == null)
            return head;

        Map<Integer, Integer> m = new HashMap<>();

        ListNode runner = head;
        while(runner!=null){
            m.put(runner.val, m.getOrDefault(runner.val, 0)+1);
            runner = runner.next;
        }

        ListNode fakeHead = new ListNode();
        fakeHead.next = head;
        ListNode prev = fakeHead;
        runner = head;


        while(runner!=null){
            if(m.get(runner.val)>1){
                prev.next = runner.next;
                runner.next = null;
                runner = prev;
            }
            prev = runner;
            runner = runner.next;
        }

        return fakeHead.next;
    }
    public static void main(String[] args) {

    }
}
