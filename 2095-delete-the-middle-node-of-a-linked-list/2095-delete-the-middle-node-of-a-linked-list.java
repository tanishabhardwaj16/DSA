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
    public ListNode deleteMiddle(ListNode head) {
        List<ListNode>ans=new ArrayList<>();
        if(head==null || head.next==null)return null;
        // ListNode fast=head;
        // ListNode slow=head;
        // fast=head.next.next;
        // while(fast!=null && fast.next!=null){
        //     slow=slow.next;
        //     fast=fast.next.next;
        // }
        // slow.next=slow.next.next;
        // return head;
        ListNode temp=head;
        while(temp!=null){
            ans.add(temp);
            temp=temp.next;
        }
        int mid=ans.size()/2;;
        ListNode prev=ans.get(mid-1);
        prev.next=ans.get(mid).next;
        return head;
    }
}