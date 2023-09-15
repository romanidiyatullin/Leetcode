package easy;

 class TreeNode101 {
      int val;
      TreeNode101 left;
      TreeNode101 right;
      TreeNode101() {}
      TreeNode101(int val) { this.val = val; }
      TreeNode101(int val, TreeNode101 left, TreeNode101 right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

public class SymmetricTree101 {

    public boolean isSymmetric(TreeNode101 root) {

        // case: empty node -> result: FALSE
        if(root == null)
            return false;

        // case: lonely root node -> result: TRUE
        if(root.left == null && root.right == null)
            return true;

        // case: asymmetric -> result: FALSE
        if(root.left == null || root.right == null)
            return false;

        return binaryTreeWalk(root.left, root.right);
    }

    public boolean binaryTreeWalk(TreeNode101 node1, TreeNode101 node2) {

        // case: empty left or right side - cannot check for match -> result: FALSE
        if(node1 == null || node2 == null)
            return false;

        // case: values mismatch -> result: FALSE
        if(node1.val != node2.val)
            return false;

        // case: asymmetric -> result: FALSE
        if(node1.left == null && node2.right != null || node1.right == null && node2.left != null)
            return false;

        // case: no children -> result: TRUE
        // why: nodes symmetric by this place in code so children do not exist for node2 as well
        if(node1.left == null && node1.right == null)
            return true;

        // since nodes symmetric so children exist for node2 as well
        boolean isBothChildren = node1.left != null && node1.right != null;

        if(isBothChildren) {
            return  binaryTreeWalk(node1.left, node2.right) &&
                    binaryTreeWalk(node1.right, node2.left);
        }

        if(node1.left!=null)
            return binaryTreeWalk(node1.left, node2.right);
        else
            return binaryTreeWalk(node1.right, node2.left);
    }

    public static void main(String[] args) {

        SymmetricTree101 test = new SymmetricTree101();

        // [1,2,2,3,4,4,3]
/*        TreeNode101 root = new TreeNode101(1, new TreeNode101(2,new TreeNode101(3), new TreeNode101(4)),
                new TreeNode101(2,new TreeNode101(4), new TreeNode101(3)));*/

        // [1,2,2,null,3,null,3]
/*        TreeNode101 root = new TreeNode101(1, new TreeNode101(2,null, new TreeNode101(3)),
                new TreeNode101(2,null, new TreeNode101(3)));*/

        // [9,25,25,null,-95,-95,null,-100,null,null,-15]
/*       TreeNode101 node3 = new TreeNode101(-95, new TreeNode101(-100),null);
         TreeNode101 node4 = new TreeNode101(-95, null, new TreeNode101(-15));
         TreeNode101 node1 = new TreeNode101(25, null , node3);
         TreeNode101 node2 = new TreeNode101(25, node4, null);
         TreeNode101 root = new TreeNode101(9, node1, node2);*/


        //[2,3,3,4,null,5,4]
        TreeNode101 root = new TreeNode101(2,
                new TreeNode101(3, new TreeNode101(4), null),
                new TreeNode101(3, new TreeNode101(5), new TreeNode101(4)));

        System.out.println(test.isSymmetric(root));
    }
}
