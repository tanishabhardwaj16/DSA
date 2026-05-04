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
    public ListNode reverseList(ListNode head) {
        // if(head==null || head.next==null)return head;
        // ListNode newhead=reverseList(head.next);
        // ListNode front=head.next;
        // front.next=head;
        // head.next=null;
        // return newhead;
        List<Integer> ans=new ArrayList<>();
        if(head==null) return null;
        ListNode temp=head;
        while(temp!=null){
            ans.add(temp.val);
            temp=temp.next;
        }
        temp=head;
        int i=ans.size()-1;
        while(temp!=null){
            temp.val=ans.get(i--);
            temp=temp.next;
        }
        return head;
    }
}
