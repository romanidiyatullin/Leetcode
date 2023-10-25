package medium;


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public String toString(){
        return " "+val+" ";
    }
}


public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if(l1 == null || l2 == null)
            return null;

        ListNode l3 = null;
        ListNode l3head = null;

        int remnants = 0;
        int sum;

        while(l1!=null && l2!=null)
        {
            sum = l1.val + l2.val + remnants;

            if(sum>9) {
                remnants = 1;
                sum = sum % 10;
            }
            else {
                remnants = 0;
            }

            if (l3head == null) {
                l3head = new ListNode(sum, null);
                l3 = l3head;
            }
            else {
                l3.next = new ListNode(sum, null);
                l3 = l3.next;
            }

            l1 = l1.next;
            l2 = l2.next;
        }

        if(l1 == null && l2 == null) {
            if(remnants != 0) {
                l3.next = new ListNode(remnants, null);
            }
            return l3head;
        }

        if(l1 == null) {
            if(remnants > 0) {
                sum = l2.val + remnants;
                if (sum > 9) addRemnant(l2);
                else l2.val = sum;
            }
            l3.next = l2;
        }
        else {
            if(remnants > 0) {
                sum = l1.val + remnants;
                if (sum > 9) addRemnant(l1);
                else l1.val = sum;
            }
            l3.next = l1;
        }

        return l3head;
    }

    public void addRemnant(ListNode list){

        int remnants = 1;
        int sum;
        ListNode currentListNode = null;

        while(list!=null){
            sum = list.val + remnants;
            if(sum > 9) {
                list.val = sum %10;
            }
            else {
                list.val = sum;
                remnants = 0;
                break;
            }
            currentListNode = list;
            list = list.next;
        }
        if(remnants > 0)
            currentListNode.next = new ListNode(remnants);
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9, new ListNode(9));
        ListNode l2 = new ListNode(9);
        ListNode result = new AddTwoNumbers().addTwoNumbers(l1, l2);
        while(result!=null){
            System.out.println(result.val + " ");
            result = result.next;
        }
    }
}
