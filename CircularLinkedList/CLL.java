public class CLL{
    private int size;
    CLL(){
        this.size = 0;
    }
    private class Node{
        int value;
        Node next;
        Node(int value){
            this.value = value;
        }
    }

    private Node head;
    private Node tail;
    
    //Dispaly
    public void diplay(){
        Node temp = head;
        do{
            System.out.print(temp.value + " ");
            temp = temp.next;
        }while(temp != head);
        System.out.println();
    }
    //Insert
    public void insert(int value){
        Node newNode = new Node(value);
        if(head == null){
            head = newNode;
            tail = newNode;
            size++;
            return;
        }
        newNode.next = head;
        tail.next = newNode;
        tail = newNode;
        size++;
    }

    public static void main(String[] args) {
        CLL list = new CLL();
        list.insert(3);
        list.insert(2);
        //list.diplay();
        list.insert(4);
        // list.diplay();
        list.insert(5);
        
        list.insert(6);
        
        list.diplay();
    }
}