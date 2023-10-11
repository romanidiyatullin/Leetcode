package easy;

public class ConvertSortedArrayToBinarySearchTree108 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {

        if(nums.length>10000 || nums.length<1)
            return null;

        return calc(0, nums.length-1, nums);
    }

    public TreeNode calc(int startIndex, int endIndex, int[] nums){

        if(startIndex>endIndex)
            return null;

        int midIndex = (startIndex+endIndex)/2;
        TreeNode head = new TreeNode(nums[midIndex]);
        head.left = calc(startIndex,midIndex-1 ,nums);
        head.right=calc(midIndex+1,endIndex,nums);

        return head;
    }


    public static void main(String[] args) {
       TreeNode result = new ConvertSortedArrayToBinarySearchTree108().sortedArrayToBST(new int[]{1,2,3,4,5,6,7});
    }

}
