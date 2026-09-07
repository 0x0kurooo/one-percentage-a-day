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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        int sum = l1.val + l2.val;
        ListNode res = new ListNode(sum % 10);
        // Move to the next number
        l1 = l1.next;
        l2 = l2.next;

        if (sum >= 10) {
            l1 = addTwoNumbers(l1, new ListNode(1));
        }
        res.next = addTwoNumbers(l1, l2);

        return res;

        /*
        Given 2 list 
        We can sum each of first node in the list and manage the plus carrier to the next node
        Pop the first nodes from l1, l2

        Normal case: the sum < 10
        
        Just append the addTwoNumbers(l1', l2'), continue until we found the end;

        Edge-cases:
        The sum is bigger than 9, >= 10

        We have to carry the plus to the new list

        That addTwoNumbers(new LinkedList(1), l1');

        After that we can continue;

        */

    }
}
