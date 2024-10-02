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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null)
            return null;

        for(int i=0; i<k; i++){
            ListNode temp = head;
            while(temp.next.next != null){
                temp = temp.next;
            }

            ListNode end = temp.next;
            temp.next = null;
            end.next = head;
            head = end;
        }
        return head;
    }
}