package easy;


public class MaximumDepthOfBinaryTree104 {

    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;

        if(root.left == null && root.right == null)
            return 1;

        return Math.max(maxDepth(root.left), maxDepth(root.right)) +1;
    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode(3, new TreeNode(9, null, null), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println(new MaximumDepthOfBinaryTree104().maxDepth(t));
    }
}
