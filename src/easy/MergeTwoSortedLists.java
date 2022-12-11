package easy;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public String toString(){
        return " "+ this.val;
    }
}

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode resultHead = new ListNode();
        ListNode resultNode = resultHead;

        while (list1 != null && list2 != null) {

            resultNode.next = new ListNode();
            resultNode = resultNode.next;

            if (list1.val <= list2.val) {
                resultNode.val = list1.val;
                list1 = list1.next;
            }
            else{
                resultNode.val = list2.val;
                list2 = list2.next;
            }
        }

        if(list1 == null) resultNode.next = list2;
        if(list2 == null) resultNode.next=list1;

        resultHead = resultHead.next;
        
        return resultHead;
    }

    public static void main(String[] args) {

        ListNode list1 = new ListNode(1, new ListNode(1, new ListNode(10)));
        ListNode list2 = new ListNode(2, new ListNode(3, new ListNode(4)));

        ListNode resultList = new MergeTwoSortedLists().mergeTwoLists(list1, list2);

        while(resultList!=null){
            System.out.println(resultList);
            resultList = resultList.next;
        }

    }
}