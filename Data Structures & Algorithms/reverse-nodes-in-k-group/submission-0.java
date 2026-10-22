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


/*
Thinking naive solution 
Counter start from 0
Create new head and revert from current node till k

Save current as prev node
Reset counter
Create new head from current
Revert node till k
Link prev to head

Loop till end of the list 
Edge-case:
- What happend when the remaining node < k -> not revert 

We can do as recursion 

head = [1,2,3,4,5,6], k = 3

reverseKGroup(head = 1, k = 3)

-> move to k position do the reserve it -> then we will connect to it

ListNode nextNodes = reverseKGroup(head = 4, k = 3)

Then do the reverse from head -> k (1 -> 3)

*/ 
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        return reverse(head, k);
    }

    private ListNode reverse(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        int counter = 0;
        ListNode cur = head;
        while (cur != null && counter < k) {
            cur = cur.next;
            counter++;
        }
        // If remaining lenght not enough, return original list
        if (counter < k) {
            return head;
        }

        counter = 0;
        cur = head;
        ListNode dummy = new ListNode(-1);
        while (cur != null && counter < k) {
            ListNode next = cur.next; // Store the next node
            
            cur.next = dummy.next;
            dummy.next = cur;
            cur = next;
            counter++;
        }

        ListNode nextReserve = reverse(cur, k);
        head.next = nextReserve;
        return dummy.next;
    }
}
