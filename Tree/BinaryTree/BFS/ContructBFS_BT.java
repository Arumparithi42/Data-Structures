import java.util.LinkedList;
import java.util.Queue;


public class ContructBFS_BT {
    
    void display(TreeNode root){
        display(root, 0);
    }
    private void display(TreeNode node, int level){
        if(node == null){
            return;
        }
        display(node.right,level+1);
        if(level == 0){
            System.out.println(node.val);
        }
        else{
            for(int i = 0; i < level-1; i++){
                System.out.print("|\t");
            }
            System.out.println("|------>" + node.val);
        }
        display(node.left, level+1);
    }
    public TreeNode construct(int[] values){
        TreeNode root = new TreeNode(values[0]);

        Queue<TreeNode> queue = new LinkedList<>();

        int index = 1;
        queue.offer(root);
        while(!queue.isEmpty() && index < values.length){
            TreeNode current = queue.poll();
            if(index < values.length){ // left child
                current.left = new TreeNode(values[index++]);
                queue.offer(current.left);
            }
            if(index < values.length){ // left child
                current.right = new TreeNode(values[index++]);
                queue.offer(current.right);
            }
        }
        return root;
    }
    public static void main(String[] args) {
        ContructBFS_BT construct = new ContructBFS_BT();
        TreeNode root = construct.construct(new int[] {1,2,3,4,5,6,7});
        construct.display(root);
    }
}
