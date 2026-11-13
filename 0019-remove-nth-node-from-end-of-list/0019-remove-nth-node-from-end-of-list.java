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

        List<ListNode> list = new ArrayList<>();

        ListNode temp = head;

        while (temp != null) {
            list.add(temp);
            temp = temp.next;
        }

        int index = list.size() - n;

        if (index == 0) {
            return head.next;
        }

        list.get(index - 1).next = list.get(index).next;

        return head;
    }
}