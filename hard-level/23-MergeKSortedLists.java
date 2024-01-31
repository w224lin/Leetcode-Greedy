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
    public ListNode mergeKLists(ListNode[] lists) {
        // Create a priorityqueue with every smallest number in the lists.
        int n = lists.length;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>(){
            @Override
            public int compare(ListNode l1, ListNode l2){
                return l1.val - l2.val;
            }
        });
        for (int i = 0; i < n; i++){
            if (lists[i] == null){
                continue;
            }
            pq.add(lists[i]);
        }
        // Create the answer.
        ListNode dummy = new ListNode();
        ListNode p = dummy;
        while(!pq.isEmpty()){
            // The smallest value in the priority queue. Remove it.
            ListNode top = pq.poll();
            // Add the value into answer.
            if (top == null){
                break;
            }
            p.next = new ListNode(top.val);
            p = p.next;
            // Add the pointer of next element in the priority queue.
            top = top.next;
            if(top != null){
                pq.add(top);
            }
        }
        return dummy.next;
    }
}