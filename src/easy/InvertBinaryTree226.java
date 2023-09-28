package easy;

public class InvertBinaryTree226 {

    public TreeNode invertTree(TreeNode root) {

            if(root == null)
                return null;

            TreeNode exchange = root.left;
            root.left = root.right;
            root.right = exchange;
            invertTree(root.left);
            invertTree(root.right);


            return root;
        }
}
