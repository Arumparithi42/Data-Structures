import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class ZigzagLevelOrderTraversal {
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> outer = new ArrayList<>();
        if (root == null)
            return outer; 

        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int count = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> currentLevel = new ArrayList<>();
            
            for(int i = 0; i < size; i++){
                TreeNode current;
                if (count % 2 == 0){ // even -> normal
                    current = queue.pollFirst();
                    currentLevel.add(current.val);
                    if(current.left != null)
                        queue.addLast(current.left);
                    if(current.right != null)
                        queue.addLast(current.right);
                }
                else{ // odd => reverse
                    current = queue.pollLast();
                    currentLevel.add(current.val);
                    if(current.right != null)
                        queue.addFirst(current.right);
                    if(current.left != null)
                        queue.addFirst(current.left);
                    
                }
            }
            outer.add(currentLevel);
            count++;
        }
        return outer;
    }
    public static void main(String[] args) {
        ContructBFS_BT tree = new ContructBFS_BT();
        TreeNode root = tree.construct(new int[] {1,2,3,4,5,6,7});
        ZigzagLevelOrderTraversal obs = new ZigzagLevelOrderTraversal();
        List<List<Integer>> list = obs.levelOrder(root);
        System.out.println(list);
    }
}