public class DLL{
    private int size;
    DLL(){
        this.size = 0;
    }
    private class Node{
        int value;
        Node next;
        Node prev;
        Node(int value){
            this.value = value;
        }
    }

    private Node head;
    private Node tail;
    
    //Dispaly
    public void diplay(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    //Dispaly Reverse
    public void diplayReverse(){
        Node temp = tail;
        while(temp != null){
            System.out.print(temp.value + " ");
            temp = temp.prev;
        }
        System.out.println();
    }
    //Insert First
    public void insertFirst(int value){
        Node newNode = new Node(value);
        newNode.next = head;
        if(head != null)
            head.prev = newNode;
        if (head == null)
            tail = newNode;
        head = newNode;
        size++;
    }
    //insert Last
    public void insertLast(int value){
        if (head == null){
            insertFirst(value);
            return;
        }
        Node newNode = new Node(value);
        Node temp = head;
        while(temp.next != null)
            temp = temp.next;
        temp.next = newNode;
        newNode.prev = temp;
        size++;
    }
    // Insert
    public void insert(int index, int value){
        Node temp = head;
        for(int i = 0; i < index-1; i++)
            temp = temp.next;

        Node newNode = new Node(value);
        newNode.next = temp.next;
        temp.next.prev = newNode;
        temp.next = newNode;
        newNode.prev = temp;
    }

    public static void main(String[] args) {
        DLL list = new DLL();
        list.insertLast(3);
        list.insertFirst(2);
        list.diplay();
        list.insert(1,4);
        list.diplay();
        list.insert(1,5);
        list.diplay();
        list.insert(3,6);
        list.diplay();
        list.diplayReverse();
    }
}