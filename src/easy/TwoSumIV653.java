package easy;

import java.util.*;

public class TwoSumIV653 {
    Set<Integer> set = new HashSet<>();

    public boolean findTarget(TreeNode root, int k) {
        if(root==null)
            return false;

        if(set.contains(k-root.val))
            return true;
        else set.add(root.val);

        return findTarget(root.left,k) || findTarget(root.right,k);

    }

    public static void main(String[] args) {
        //TreeNode root = new TreeNode(5, new TreeNode(3,new TreeNode(2), new TreeNode(4)), new TreeNode(6, null, new TreeNode(7)));
        //TreeNode root = new TreeNode(1);
        //TreeNode root = new TreeNode(2, null, new TreeNode(3));
        TreeNode root = new TreeNode(1, null, new TreeNode(2));
        System.out.println(new TwoSumIV653().findTarget(root, 2));
    }
}
