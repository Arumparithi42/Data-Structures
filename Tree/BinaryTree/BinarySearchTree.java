public class BinarySearchTree {
    static class Node{
        int value;
        Node left;
        Node right;
        int height;
        Node(int value){
            this.value = value;
        }
    }

    private int height(Node node){
        if(node == null){
            return -1;
        }
        return node.height;
    }

    private Node root;
    void insert(int value){
        root = insert(root,value);
    }
    
    private Node insert(Node node, int value){
        if (node == null){
            Node newNode = new Node(value);
            return newNode;
        }
        if(value <= node.value){
            node.left = insert(node.left, value);
        }
        else{
            node.right = insert(node.right, value);
        }
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return node;
    }
    void display(){
        display(root, 0);
    }
    private void display(Node node, int level){
        if(node == null){
            return;
        }
        display(node.right,level+1);
        if(level == 0){
            System.out.println(node.value);
        }
        else{
            for(int i = 0; i < level-1; i++){
                System.out.print("|\t");
            }
            System.out.println("|------>" + node.value);
        }
        display(node.left, level+1);
    }
    int getHeight(){
        return height(root);
    }
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        int[] values = {3,5,2,8,6,7};
        for(int i = 0; i < values.length; i++)
            tree.insert(values[i]);
        tree.display();
        System.out.println(tree.getHeight());
    }
    
}
