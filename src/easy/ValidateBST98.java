package easy;

class TreeNode98 {
    int val;
    TreeNode98 left;
    TreeNode98 right;
    TreeNode98() {
    }
    TreeNode98(int val) {
        this.val = val;
    }
    TreeNode98(int val, TreeNode98 left, TreeNode98 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


class ValidateBST98 {

    public static boolean isValidBST(TreeNode98 root) {
        if(root==null || root.left == null && root.right == null)
            return true;

        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean isValid(TreeNode98 node, long leftMargin, long rightMargin){
        if(node==null)
            return true;

        if(node.val <= leftMargin || node.val >= rightMargin)
            return false;

        return (isValid(node.left, leftMargin, node.val)
            &&  isValid(node.right, node.val, rightMargin));
    }

    public static void main(String[] args){
        TreeNode98 root = new TreeNode98(5, new TreeNode98(1),new TreeNode98(7, new TreeNode98(6), new TreeNode98(8)));
        System.out.println(isValidBST(root));
    }

}
