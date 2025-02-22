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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = head;
        int cnt = 0;

        while(dummy != null){
            cnt++;
            dummy = dummy.next;
        }

        if(cnt == n){
            head = head.next;
            return head;
        } else {
            int diff = cnt - n;
            ListNode temp = head;
            for(int i=0; i<diff-1; i++){
                temp = temp.next;
            }
            temp.next = temp.next.next;
        }
        return head;
    }
}