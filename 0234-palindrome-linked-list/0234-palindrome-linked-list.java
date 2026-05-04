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
    //     if(head==null || head.next==null)return true;
    //     ListNode slow=head;
    //     ListNode fast=head;
    //     while(fast.next!=null && fast.next.next!=null){
    //         slow=slow.next;
    //         fast=fast.next.next;
    //     }
    //     ListNode newhead=reverseList(slow.next);
    //     ListNode i=head;
    //     ListNode j=newhead;
    //     while(j!=null){
    //         if(i.val != j.val){
    //             reverseList(newhead);
    //             return false;
    //         }
    //         i=i.next;
    //         j=j.next;
    //     }
    //         reverseList(newhead);
    //         return true;
    //     }
    //  private ListNode reverseList(ListNode head) {
    //     if(head==null || head.next==null)return head;
    //     ListNode newhead=reverseList(head.next);
    //     ListNode front=head.next;
    //     front.next=head;
    //     head.next=null;
    //     return newhead;

      List<Integer>ans=new ArrayList<>();
      if(head==null || head.next==null) return true;
      ListNode temp=head;
      while(temp!=null){
        ans.add(temp.val);
        temp=temp.next;
      }
      int i=0;
      int j=ans.size()-1;
      while(i<j){
        if(ans.get(i)!=ans.get(j)) return false;
        i++;
        j--;
      }
      return true;
    }
}