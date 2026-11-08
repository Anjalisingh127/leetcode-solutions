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
    public ListNode partition(ListNode head, int x) {

        List<Integer> small = new ArrayList<>();
        List<Integer> large = new ArrayList<>();

        ListNode temp = head;

        while (temp != null) {
            if (temp.val < x) {
                small.add(temp.val);
            } else {
                large.add(temp.val);
            }
            temp = temp.next;
        }

        small.addAll(large);

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        for (int val : small) {
            curr.next = new ListNode(val);
            curr = curr.next;
        }

        return dummy.next;
    }
}