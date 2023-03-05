package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

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

    boolean isPopHappened = false;

    public List<Integer> inorderTraversal(TreeNode root) {

        /*
            Input: root = []
            Output: []
         */
        if(root==null)
            return new ArrayList<>();

        /*
            Input: root = [1]
            Output: [1]
         */
        if(root.left==null && root.right == null)
            return List.of(root.val);


        List<Integer> resultList = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();

        traverse(root, resultList, stack);

        return resultList;
    }

    public void traverse(TreeNode node, List<Integer> resultList, Stack<TreeNode> stack){

        if(node!=null) {

            TreeNode currentNode = node;

            if(!isPopHappened)
            {
                if (currentNode.left != null) {
                    stack.push(currentNode);
                    currentNode = currentNode.left;
                } else if (currentNode.right != null) {
                    resultList.add(currentNode.val);
                    currentNode = currentNode.right;
                } else {
                    resultList.add(currentNode.val);
                    currentNode = stack.isEmpty() ? null : stack.pop();
                    isPopHappened = true;
                }
                traverse(currentNode, resultList, stack);
            }
            else {
                isPopHappened = false;
                resultList.add(currentNode.val);

                if (currentNode.right != null) {
                    currentNode = currentNode.right;
                    traverse(currentNode, resultList, stack);
                } else if (!stack.isEmpty()) {
                    currentNode = stack.pop();
                    isPopHappened = true;
                    traverse(currentNode, resultList, stack);
                }
            }
        }
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
