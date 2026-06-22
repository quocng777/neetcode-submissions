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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode cur = null;
        ListNode head = null;
        while (list1 != null && list2 != null) {
            ListNode next;
            if (list1.val <= list2.val) {
                next = list1;
                list1 = next.next;
            } else {
                next = list2;
                list2 = next.next;
            }

            if (head != null) {
                cur.next = next;
                cur = next;
                next.next = null;
            } else {
                head = next;
                cur = next;
            }
        }

        if (list1 != null) {
            if (head != null) {
                cur.next = list1;
            } else {
                head = list1;
            }
        }
        if (list2 != null) {
            if (head != null) {
                cur.next = list2;
            } else {
                head = list2;
            }
        }

        return head;
    }
}