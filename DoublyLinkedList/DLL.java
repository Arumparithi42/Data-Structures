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
        tail = newNode;
        size++;
    }
    // Insert
    public void insert(int index, int value){
        if(index > size){
            System.out.println("Invalid index");
            return;
        }
        if(index == 0){
            insertFirst(value);
            return;
        }
        if(index == size){
            insertLast(value);
            return;
        }
        Node temp = head;
        for(int i = 0; i < index-1; i++)
            temp = temp.next;

        Node newNode = new Node(value);
        newNode.next = temp.next;
        temp.next.prev = newNode;
        temp.next = newNode;
        newNode.prev = temp;
        size++;
    }
    // Delete First
    public void deleteFirst(){
        if(head == null)
            return;
        head = head.next;
        if(head != null)
            head.prev = null;
        else
            tail = null;
        size--;
    }
    // Delete Last
    public void deleteLast(){
        if(head == null){
            return;
        }
        
        if(head.next == null){
            head = null;
            tail = null;
            size--;
            return;
        }
        Node temp = head;
        while(temp.next.next != null){
            temp = temp.next;
        }
        temp.next = null;
        tail = temp;
        size--;
    }
    public void delete(int index){
        if(index < 0 || index > size-1){
            System.out.println("Invlid index");
            return;
        }
        if(index == 0){
            deleteFirst();
            return;
        }
        if(index == size - 1){
            deleteLast();
            return;
        }

        Node temp = head;
        for(int i = 0; i < index - 1; i++){
            temp = temp.next;
        }
        temp.next = temp.next.next;
        temp.next.prev = temp;
        size--;
    }

    public static void main(String[] args) {
        DLL list = new DLL();
        list.insertLast(3);
        list.insertFirst(2);
        //list.diplay();
        list.insert(1,4);
        // list.diplay();
        list.insert(1,5);
        
        list.insert(0,6);
        
        list.diplay();
        list.delete(3);
        list.diplay();
        System.out.print("reverse : ");list.diplayReverse();
    }
}