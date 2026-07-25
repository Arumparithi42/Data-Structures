import java.util.Scanner;
public class BinaryTree {
    private static class ListNode{
        int value;
        ListNode left;
        ListNode right;

        ListNode() {}
        ListNode(int value) {
            this.value = value;
        }
    }
    private ListNode root;


    void display(){
        //display(root, "");    
        prettyDisplay(root,0);
    }
    void prettyDisplay(ListNode node, int level){
        if(node == null){
            return;
        }
        prettyDisplay(node.right, level+1);
        if(level == 0){//root
            System.out.println(node.value);
        }
        else{
            for(int i = 0; i < level-1; i++)
                System.out.print("|\t");
            System.out.println("|------>" + node.value);
        }
        prettyDisplay(node.left, level+1);
    }
    void display(ListNode node, String indent){
        if (node == null){
            return;
        }
        System.out.println(indent + node.value);
        display(node.left, "\t");
        display(node.right, "");
    }
    void populate(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter root node: ");
        int rootValue = input.nextInt();
        root = new ListNode(rootValue);
        populate(root, input);
    }
    void populate(ListNode node, Scanner input){
        System.out.print("Enter left child value(-1 to null) of " + node.value + " : ");
        int left = input.nextInt();
        if(left != -1){
            node.left = new ListNode(left);
            populate(node.left, input);
        }
        System.out.print("Enter right child value(-1 to null) of " + node.value + " : ");
        int right = input.nextInt();
        if(right != -1){
            node.right = new ListNode(right);
            populate(node.right, input);
        }
    }
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.populate();
        tree.display();
    }
}
