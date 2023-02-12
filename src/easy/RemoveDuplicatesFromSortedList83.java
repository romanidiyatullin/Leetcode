package easy;

class ListNode1 {
    int val;
    ListNode1 next;
    ListNode1() {}
    ListNode1(int val) {
        this.val = val;
    }
    ListNode1(int val, ListNode1 next) {
        this.val = val; this.next = next;
    }

    @Override
    public String toString() {

        String resultString = "";
        ListNode1 currentNode = this;

        while(currentNode!=null ){
            resultString += currentNode.val + " ";
            currentNode = currentNode.next;
        }

        return resultString;
    }

}

public class RemoveDuplicatesFromSortedList83 {

    public ListNode1 deleteDuplicates(ListNode1 head) {

        if(head == null)
            return null;

        if(head.val < -100 || head.val > 100)
            return null;

        ListNode1 prevNode = head;
        ListNode1 currentNode = head.next;

        int prevValue = prevNode.val;

        int count = 1;

        while(currentNode != null) {

            count++;

            while (currentNode != null && currentNode.val == prevValue)
                currentNode = currentNode.next;

            if(currentNode == null) {
                prevNode.next = null;
                return head;
            }

            prevNode.next = currentNode;
            prevValue = prevNode.val;

            if (prevValue < -100 || prevValue > 100 || count > 300)
                return null;

            prevNode = currentNode;
            prevValue = prevNode.val;
            currentNode = currentNode.next;

        }

        return head;
    }

    public static void main(String[] args) {
       // 1 1 2 -> 1 2
        //ListNode1 testListNode1 = new ListNode1(1, new ListNode1(1,new ListNode1(2,null)));
        // 1 1 2 3 3 -> 1 2 3
        ListNode1 testListNode1 = new ListNode1(1, new ListNode1(1, new ListNode1(2, new ListNode1(3, new ListNode1(3, null)))));
        System.out.println(new RemoveDuplicatesFromSortedList83().deleteDuplicates(testListNode1));
    }
}
