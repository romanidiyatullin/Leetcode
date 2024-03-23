package ya;

import java.util.*;

public class LeetCode230_kth_smallest_BST {

   static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

    public static void main(String[] args) {
       TreeNode root =
               new TreeNode(5,
                            new TreeNode(3,
                                    new TreeNode(2, new TreeNode(1), null), new TreeNode(4)),
                            new TreeNode(6)) ;
       System.out.println(new LeetCode230_kth_smallest_BST().solutionDFSInOrder(root, 3));
       System.out.println(new LeetCode230_kth_smallest_BST().solutionStackIterative(root, 3));
    }

    public int solutionDFSInOrder(TreeNode root, int k){
        List<Integer> result = new ArrayList<>();
        dfs(root, result, k);
        return result.get(k-1);
    }

    /*
     DFS - inorder mode: left child, current node, right child
     */
    public void dfs(TreeNode node, List<Integer> result, int k ){
       if(node == null)
           return;

       dfs(node.left, result, k);
       result.add(node.val);

       if(result.size() == k)
           return;

       dfs(node.right, result,k);
    }

    public int solutionStackIterative(TreeNode head, int k){
       Stack<TreeNode> stack = new Stack<>();
       TreeNode node = head;
       int counter = 0;
       while(true){
           while(node!=null){
               stack.push(node);
               node = node.left;
           }
           node = stack.pop();
           counter++;
           if(counter == k)
               return node.val;
           node = node.right;
       }
    }

}
