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

class Pair{
    int value;
    ListNode node;

    public Pair(int value, ListNode node){
        this.value = value;
        this.node = node;
    }
}

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0 || lists == null)
            return null;

        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.value - y.value);

        for(int i=0; i<lists.length; i++){
            if(lists[i] != null){
                pq.add(new Pair(lists[i].val, lists[i]));
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        
        while(!pq.isEmpty()){
            Pair it = pq.poll();
            ListNode node = it.node;
            
            if(node.next != null){
                pq.add(new Pair(node.next.val, node.next));
            }

            temp.next = node;
            temp = temp.next;
        }
        return dummy.next;
    }
}