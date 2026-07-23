class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class ReverseLinkedList2 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode prev = null;
        ListNode current = head;
        for(int i = 0; current != null && i < left - 1; i++){
            prev = current;
            current = current.next; 
        }
        ListNode last = prev;
        ListNode newEnd = current;

        ListNode next;
        for(int i = 0; current != null && i < right - left + 1; i++){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        newEnd.next = current;
        if(last == null)
            head = prev;
        else{
            last.next = prev;
        }
        return head;
    }
}