package easy;


public class ConvertSortedArrayToBinary108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        int mid = nums.length/2;
        TreeNode head = new TreeNode(nums[mid]);
        if(mid>0) {
            head.left=calc(0, mid-1, nums);
            head.right=calc(mid+1, nums.length-1, nums);
        }
        return head;
    }

    public TreeNode calc(int start, int end, int[] nums){

        if(start>end)
            return null;

        int mid = (start + end)/2;

        TreeNode node = new TreeNode(nums[mid]);
        node.left=calc(start, mid-1, nums);
        node.right=calc(mid+1, end, nums);

        return node;
    }


    public static void main(String[] args) {
        TreeNode result = new ConvertSortedArrayToBinary108().sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
        System.out.println(result);
    }
}
