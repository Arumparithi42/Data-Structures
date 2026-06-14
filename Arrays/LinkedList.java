/*
Applicqtions :
1. Used in OS to tract free memory blocks
2. In Hashing, It is one of the solution to avoid collisions
3. Polynomial manipulation
4. Used in Graph to create adjacency matric
5. Used to implement ADTs such as stack and queue
6. In compiler, used to maintain symbol tables which stores information about variables, functions and classes. 
*/
class Node{
    int data;
    Node next;

    Node(int data){
        this.data = data;
        this.next = null;
    }
}
public class LinkedList {
    Node head = null;

    void display(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    void insertAtFirst(int data){
        Node newNode = new Node(data);

        newNode.next = head;
        head = newNode;
    }
    void insertAtLast(int data){
        if(head == null){
            insertAtFirst(data);
            return;
        }

        Node newNode = new Node(data);

        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = newNode;
    }
    void insert(int data, int index){
        if (index < 0){
            System.out.println("Can't be inserted : negative index");
            return;
        }
        if (index == 0){
            insertAtFirst(data);
            return;
        }

        Node temp = head;
        for(int i = 0; temp != null && i < index - 1; i++){
            temp = temp.next;
        }
        if (temp == null){
            System.out.println("Can't be inserted : index out of range");
            return;
        }

        Node newNode = new Node(data);
        newNode.next = temp.next;
        temp.next = newNode;
    }
    void deleteAtFirst(){
         if (head == null){
            System.out.println("Can't be deleted : The list is already empty");
            return;
        }
        head = head.next;
    }
    void deleteAtLast(){
        Node temp = head;
        if (temp == null){
            System.out.println("Can't be deleted : The list is already empty");
            return;
        }
        if(temp.next == null){
            head = null;
            return;
        }

        while(temp.next.next != null){
            temp = temp.next;
        }
        temp.next = null;
    }
    void delete(int index){
        if (index < 0){
            System.out.println("Can't be deleted : negative index");
            return;
        }
        if (index == 0){
            deleteAtFirst();
            return;
        }
        Node temp = head;
        for(int i = 0; temp != null && i < index - 1; i++){
            temp = temp.next;
        }
        if (temp == null){
            System.out.println("Can't be deleted : index out of range");
            return;
        }
        temp.next = temp.next.next;
    }

    void set(int data, int index){
        if (index < 0){
            System.out.println("Can't be set : negative index");
            return;
        }

        Node temp = head;
        for(int i = 0; temp != null && i < index; i++){
            temp = temp.next;
        }
        if (temp == null){
            System.out.println("Can't be set : index out of range");
            return;
        }

        temp.data = data;
    }
    
    public static void main(String[] args){
        LinkedList list = new LinkedList();

        list.deleteAtLast();
        list.insertAtLast(10);
        list.insertAtLast(20);
        list.insertAtLast(30);
        list.display();
        list.insertAtFirst(1);
        list.insertAtFirst(2);
        list.insertAtFirst(3);
        list.display();
        
        list.insert(100,2);
        list.display();

        list.insert(6,6);
        list.display();

        list.deleteAtFirst();
        list.deleteAtLast();
        list.display();
        list.delete(5);
        list.display();
        list.delete(2);
        list.display();
        list.set(200,4);
        list.display();
    }
}

/*
Advantages :
1. Dynamic memory (not fixed size)
2. Faster access of insertion/deletion at the beginning

Disadavatages :
1. Consumes more memory since it stores pointers.
2. Slower acces at the end since we have to traverse from the head.
3. No random access (i.e no faster access unlike list which uses index for faster access)
*/