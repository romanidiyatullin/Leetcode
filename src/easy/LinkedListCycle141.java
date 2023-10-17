package easy;

public class LinkedListCycle141 {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static boolean hasCycle(ListNode head) {

        ListNode node1 = head;
        ListNode node2 = head;

        while (node2 != null && node2.next != null) {
            node1 = node1.next;
            node2 = node2.next.next;

            if (node1 == node2)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        // Test 1 - empty.                         Expected: false
        System.out.println(hasCycle(null));
        // Test 2 - just one.                      Expected: false
        ListNode node1 = new ListNode(1);
        System.out.println(hasCycle(node1));
        // Test 3 - just two.                      Expected: false
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        System.out.println(hasCycle(node1));
        // Test 4 - just two with loop.             Expected: true
        node2.next=node1;
        System.out.println(hasCycle(node1));
        // Test 5 - just three.                     Expected: false
        ListNode node3 = new ListNode(3);
        node2.next=node3;
        System.out.println(hasCycle(node1));
        // Test 6 - just three with loop into two.  Expected: true
        node3.next=node2;
        System.out.println(hasCycle(node1));
        // Test 7 - just three with loop into one.  Expected: true
        node3.next=node1;
        System.out.println(hasCycle(node1));

    }
}
