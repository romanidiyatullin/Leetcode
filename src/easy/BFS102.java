package easy;

import java.util.*;

public class BFS102 {

    public List<List<Integer>> levelOrder(TreeNode root) {

        if(root == null)
            return new ArrayList<>();

        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> subList = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        //BFS
        while(!queue.isEmpty()){

            int currentLevelSize = queue.size();

            for(int i = 0; i<currentLevelSize; i++){

                TreeNode node = queue.poll();
                subList.add(node.val);

                if(node.left!=null)
                    queue.offer(node.left);
                if(node.right!=null)
                    queue.offer(node.right);
            }

            resultList.add(subList);
            subList = new ArrayList<>();
        }
        return resultList;
    }

}
