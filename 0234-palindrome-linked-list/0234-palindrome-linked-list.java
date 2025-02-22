/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null)
            return true;

        ListNode slow = head, fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }    

        slow.next = reverse(slow.next);
        slow = slow.next;
        ListNode dummy = head;

        while(slow != null){
            if(slow.val != dummy.val)
                return false;

            slow = slow.next;
            dummy = dummy.next;    
        }
        return true;
    }

    public ListNode reverse(ListNode head){
        ListNode dummy = null;

        while(head != null){
            ListNode next = head.next;
            head.next = dummy;
            dummy = head;
            head = next;
        }
        return dummy;
    }
}