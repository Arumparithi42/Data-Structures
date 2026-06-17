public class ReverseLinkedList extends LinkedList {
    public void reverse(){
        Node current = head;
        Node prev = null;
        Node next;
        while (current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        System.out.println("Linked List is reversed");
    }
    public static void main(String[] args) {
        ReverseLinkedList list = new ReverseLinkedList();
        
        list.insertAtFirst(1);
        list.insertAtFirst(2);
        list.insertAtFirst(3);
        
        
        list.insert(100,2);
        list.display();

        list.reverse();
        list.display();
    }
}
