// to be refined
import java.util.*;
public class BTRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> ans = new ArrayList<>();
        if (root == null){
            return ans;    
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            ArrayList<Integer> currentLevel = new ArrayList<>();
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode current = queue.poll();
                currentLevel.add(current.val);
                if (current.left != null)
                    queue.offer(current.left);
                if (current.right != null)
                    queue.offer(current.right);
            }
            ans.add(currentLevel.get(currentLevel.size() -1 ));
        }
        
        return ans;
    }
    
}