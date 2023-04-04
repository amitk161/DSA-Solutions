/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode head1, ListNode head2) {
        HashSet<ListNode> set = new HashSet<>();
        while(head1 != null){
            set.add(head1);
            head1 = head1.next;
        }
        
        while(head2 != null){
            if(set.contains(head2))
                return head2;
            head2 = head2.next;
        }
        return null;
    }
}