package easy;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
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

 class BinaryTreeInorderTraversal94 {

    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null)
            return new ArrayList<>();
        return traverse(root, new ArrayList<>());

    }

    private List<Integer> traverse(TreeNode node, List<Integer> list){

        if(node == null)
            return list;

        list = traverse(node.left, list);
        list.add(node.val);

        return traverse(node.right, list);
    }

     public static void main(String[] args) {

         TreeNode nodeA = new TreeNode(1);
         TreeNode nodeB = new TreeNode(2);
         TreeNode nodeC = new TreeNode(3);
         TreeNode nodeD = new TreeNode(4);
         TreeNode nodeE = new TreeNode(5);
         TreeNode nodeF = new TreeNode(6);
         TreeNode nodeG = new TreeNode(7);
         TreeNode nodeH = new TreeNode(8);
         TreeNode nodeI = new TreeNode(9);

         nodeA.left = nodeB;
         nodeA.right = nodeC;
         nodeB.right = nodeD;
         nodeC.left = nodeE;
         nodeC.right = nodeF;
         nodeE.left = nodeG;
         nodeF.left = nodeH;
         nodeF.right = nodeI;

         System.out.println(new BinaryTreeInorderTraversal94().inorderTraversal(nodeA));
     }
}
