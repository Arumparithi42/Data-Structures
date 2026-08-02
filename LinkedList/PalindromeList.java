public class PalindromeList {
    public boolean isPalindrome(Node head) {
        if (head == null || head.next == null){
            return true;
        }
        Node head1 = head;
        Node head2 = reverse(getMid(head));
        while(head1 != null || head2 != null){
            System.out.println(head1.data);
            System.out.println(head2.data);
            if (head1.data != head2.data){
                return false;
            }
            
            head1 = head1.next;
            head2 = head2.next;
        }
        return true;
    }
    private Node getMid(Node head){
        Node slow = head;
        Node fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node temp = slow.next;
        slow.next = null;
        return temp;
    }
    private Node reverse(Node head){
        Node prev = null;
        Node current = head;
        Node next;
        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insertAtLast(1);
        list.insertAtLast(2);
        list.insertAtLast(2);
        list.insertAtLast(1);

        PalindromeList check = new PalindromeList();
        System.out.println(check.isPalindrome(list.head));
    }
}