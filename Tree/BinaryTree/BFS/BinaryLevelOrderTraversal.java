import java.util.*;
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
public class BinaryLevelOrderTraversal {
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> outer = new ArrayList<List<Integer>>();
        if (root == null)
            return outer; 

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> currentLevel = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode current = queue.poll();
                currentLevel.add(current.val);
                if(current.left != null)
                    queue.add(current.left);
                if(current.right != null)
                    queue.add(current.right);
            }
            outer.add(currentLevel);
        }
        return outer;
    }
}