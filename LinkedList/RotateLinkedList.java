class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

public class RotateLinkedList {
    public ListNode rotateRight(ListNode head, int k) {
        if (k < 1 || head == null || head.next == null)
            return head;
        int l = 1;
        ListNode temp = head;
        while(temp.next != null){
            l++;
            temp = temp.next;
        }
        temp.next = head;
        k = k % l;
        ListNode last = head;
        for(int i = 0; i < l - k - 1; i++){
            last = last.next;
        }
        head = last.next;
        last.next = null;
        return head;
    }
}